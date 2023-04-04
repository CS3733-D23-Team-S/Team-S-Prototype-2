package edu.wpi.teamname.Database.Map;

import edu.wpi.teamname.Database.dbConnection;
import lombok.Getter;
import lombok.Setter;
import oracle.ucp.proxy.annotation.Pre;

import javax.swing.plaf.nimbus.State;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class NodeDaoImpl implements NodeDOA_I {
	private static NodeDaoImpl single_instance;
	@Getter
	private String name;
	dbConnection connection;

	@Getter
	private HashMap<Integer, Node> nodes = new HashMap<>();

	private NodeDaoImpl() {
		connection = dbConnection.getInstance();
	}

	public static synchronized NodeDaoImpl getInstance() {
		if (single_instance == null) single_instance = new NodeDaoImpl();

		return single_instance;
	}

	@Override
	public List<Node> getAllNodes() {
		return new ArrayList<>(this.nodes.values());
	}

	@Override
	public void initTable(String name) {
		this.name = name;
		String nodeTable =
				"CREATE TABLE IF NOT EXISTS "
				+ name
				+ " (nodeID Varchar(100) UNIQUE PRIMARY KEY,"
				+ "xcoord int,"
				+ "ycoord int,"
				+ "floor varchar(10),"
				+ "Building Varchar(100))";
		try {
			Statement stmt = connection.getConnection().createStatement();
			stmt.execute(nodeTable);
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println("Error with creating the node table");
		}

	}

	@Override
	public Node getNode(int nodeID) {
		return nodes.get(nodeID);
	}

	@Override
	public void updateNode(Node node) {

	}

	@Override
	public void deleteNode(Node node) {
		nodes.remove(node.getNodeID());
	}

	@Override
	public void loadToRemote(String pathToCSV) {
		try {
			Statement stmt = connection.getConnection().createStatement();
			String checkTable = "SELECT * FROM " + name;
			ResultSet check = stmt.executeQuery(checkTable);
			if (check.next())
				constructFromRemote();
			else
				constructRemote(pathToCSV);
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	@Override
	public void addNode(Node thisNode) {
		try {
			Statement stmt = connection.getConnection().createStatement();
			String addNode = ("INSERT INTO " + name + "(" + thisNode.getNodeID() + ", " + thisNode.getXCoord() + ", " +
							  thisNode.getYCoord() + ", " + thisNode.getFloor() + ", " + thisNode.getBuilding() + ")");
			stmt.executeQuery(addNode);
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}


	private void constructFromRemote() {
		try {
			Statement stmt = connection.getConnection().createStatement();
			String listOfNodes = "SELECT * FROM " + name;
			ResultSet data = stmt.executeQuery(listOfNodes);
			while (data.next()) {
				int nodeID = data.getInt("nodeID");
				int xCoord = data.getInt("xCoord");
				int yCoord = data.getInt("yCoord");
				int floor = data.getInt("Floor");
				String building = data.getString("Building");
				Node floorNode = new Node(nodeID, xCoord, yCoord, Floor.values()[floor], building);
				nodes.put(nodeID, floorNode);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getSQLState());
			System.out.println("Error accessing the remote and constructing the list of nodes");
		}

	}


	private void constructRemote(String csvFilePath) {
		try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
			try {
				PreparedStatement stmt = connection.getConnection().prepareStatement("INSERT INTO " + name + " (?, ?, ?, ?, ?)");
				reader.readLine();
				String line;
				while ((line = reader.readLine()) != null) {
					String[] fields = line.split(",");
					stmt.setInt(1,Integer.parseInt(fields[0]));
					stmt.setInt(2,Integer.parseInt(fields[1]));
					stmt.setInt(3,Integer.parseInt(fields[2]));
					stmt.setString(4,"Floor"+fields[3]);
					stmt.setString(5, fields[4]);
					stmt.execute();
					Node thisNode =
							new Node(
									Integer.parseInt(fields[0]),
									Integer.parseInt(fields[1]),
									Integer.parseInt(fields[2]),
									Floor.valueOf("Floor" + fields[3]),
									fields[4]);
					nodes.put(Integer.valueOf(fields[0]), thisNode);
					this.addNode(thisNode);
				}
			} catch (SQLException e) {
				e.getMessage();
				e.printStackTrace();
				;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
