package edu.wpi.teamname.Database.Map;

import edu.wpi.teamname.Database.dbConnection;
import lombok.Getter;

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

public class EdgeDaoImpl implements EdgeDoa_I {
	private static EdgeDaoImpl single_instance;
	@Getter
	private String name;
	dbConnection connection;
	NodeDaoImpl nodeDao = NodeDaoImpl.getInstance();
	List<Edge> edges = new ArrayList<>();
	HashMap<Integer, HashSet<Integer>> neighbors = new HashMap<>();

	private EdgeDaoImpl() {
		connection = dbConnection.getInstance();
	}

	public static synchronized EdgeDaoImpl getInstance() {
		if (single_instance == null) single_instance = new EdgeDaoImpl();

		return single_instance;
	}

	@Override
	public List<Edge> getAllEdges() {
		return edges;
	}

	@Override
	public void initTable(String name) {
		this.name = name;
		String edgeTable =
				"CREATE TABLE IF NOT EXISTS "
				+ name
				+ " "
				+ "(startNode int,"
				+ "endNode int)";
		try {
			Statement stmt = connection.getConnection().createStatement();
			stmt.execute(edgeTable);
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println("Error with creating the node table");
		}

	}

	@Override
	public Edge getEdge(Node startNode, Node endNode) {
		return null;
	}

	@Override
	public void deleteEdge(Node startNode, Node endNode) {
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

	private void constructFromRemote() {
		try {
			Statement stmt = connection.getConnection().createStatement();
			String getData = "SELECT * FROM " + name;
			ResultSet data = stmt.executeQuery(getData);
			while (data.next()) {
				Edge thisEdge = new Edge(nodeDao.getNode(data.getInt("startNode")), nodeDao.getNode(data.getInt("endNode")));
			}
			String getNodes = "SELECT nodeID FROM " + nodeDao.getName();
			PreparedStatement getNeighbors =
					connection.getConnection().prepareStatement(
							"SELECT * FROM " + name + " WHERE startNode = ? OR endnode = ?");
			try {
				ResultSet listOfNodes = stmt.executeQuery(getNodes);
				while (listOfNodes.next()) {
					int currentNode = listOfNodes.getInt("nodeID");
					getNeighbors.setInt(1, currentNode);
					getNeighbors.setInt(2, currentNode);
					data = getNeighbors.executeQuery();
					HashSet<Integer> neighbors = new HashSet<>();
					while (data.next()) {
						neighbors.add(data.getInt("endNode"));
						neighbors.add(data.getInt("startNode"));
					}
					neighbors.remove(currentNode);
					this.neighbors.put(currentNode, neighbors);
				}
			} catch (SQLException e) {
				System.out.println("Error accessing the remote and constructing the list of edges");
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
				String line;
				while ((line = reader.readLine()) != null) {
					String[] fields = line.split(",");
					Edge thisEdge =
							new Edge(
									nodeDao.getNodes().get(Integer.parseInt(fields[0])),
									nodeDao.getNodes().get(Integer.parseInt(fields[1])));
					edges.add(thisEdge);
					Statement stmt = connection.getConnection().createStatement();
					String insertEdge = "INSERT INTO " + name + " (" + Integer.parseInt(fields[0]) + ", " + Integer.parseInt(fields[1]) + ")";
					stmt.execute(insertEdge);
				}
				constructFromRemote();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getSQLState());
				System.out.println("Error accessing the remote and constructing the list of edges");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

