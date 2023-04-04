package edu.wpi.teamname.Database.Map;

import edu.wpi.teamname.Database.dbConnection;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

public class LocationDoaImpl implements LocationDOA_I {
	private static LocationDoaImpl single_instance;
	@Getter
	String name;
	@Getter
	private HashMap<String, Location> locations;

	dbConnection connection;

	private LocationDoaImpl() {
		connection = dbConnection.getInstance();
	}

	public static synchronized LocationDoaImpl getInstance() {
		if (single_instance == null) single_instance = new LocationDoaImpl();

		return single_instance;
	}

	@Override
	public List<Location> getAllLocations() {
		return (List<Location>) this.locations.values();
	}

	@Override
	public void initTable(String name) {
		this.name = name;
		String locationTable = "CREATE TABLE IF NOT EXISTS " + name + " " + "(longname varchar(100)," + "shortname varchar(100)," + "nodetype int)";

		try {
			Statement stmt = connection.getConnection().createStatement();
			stmt.execute(locationTable);
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println("Error with creating the node table");
		}

	}

	@Override
	public Location getLocation(String longName) {
		return this.locations.get(longName);
	}

	@Override
	public void loadToRemote(String pathToCSV) {

	}

	@Override
	public void addLocation(Location thisLocation) {
		try {
			Statement stmt = connection.getConnection().createStatement();
			String addLocation = "INSERT INTO " + name + "(" + thisLocation.getLongName() + ", " + thisLocation.getShortName() + ", " +
								 thisLocation.getNodeType().ordinal() + ")";
			stmt.executeQuery(addLocation);
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private void constructFromRemote() {
		try {
			Statement stmt = connection.getConnection().createStatement();
			String listOfLocs = "SELECT * FROM " + name;
			ResultSet data = stmt.executeQuery(listOfLocs);
			while (data.next()) {
				String longName = data.getString("longname");
				String shortName = data.getString("shortname");
				NodeType type = NodeType.values()[data.getInt("nodetype")];
				Location location = new Location(longName, shortName, type);
				locations.put(longName, location);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getSQLState());
			System.out.println("Error accessing the remote and constructing the list of nodes");
		}
	}


	private void constructRemote(String csvFilePath) {
		try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
			reader.readLine();
			String line;
			try {
				while ((line = reader.readLine()) != null) {
					String[] fields = line.split(",");
					NodeType value = NodeType.values()[Integer.parseInt(fields[2])];
					Location location = new Location(fields[0], fields[1], value);
					locations.put(fields[0], location);
					this.addLocation(location);

					Statement stmt = connection.getConnection().createStatement();
					String insert = "INSERT INTO " + name + "(" + fields[0] + ", " + fields[1] + ", " + Integer.parseInt(fields[2]) + ")";
					stmt.executeQuery(insert);

				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getSQLState());
				System.out.println("Error accessing the remote and constructing the list of nodes");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
