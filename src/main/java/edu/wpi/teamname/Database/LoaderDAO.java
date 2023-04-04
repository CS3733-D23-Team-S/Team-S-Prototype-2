package edu.wpi.teamname.Database;

import edu.wpi.teamname.Database.Map.*;

import java.sql.SQLException;
import java.sql.Statement;

public class LoaderDAO {
	final String schemaName = "hospitaldb";
	final String nodeTable = schemaName + "." + "nodes";
	final String edgesTable = schemaName + "." + "edges";
	final String locationTable = schemaName + "." + "locations";
	final String moveTable = schemaName + "." + "moves";

	dbConnection connection;


	public LoaderDAO() throws SQLException {
		establishConnection();
		initTables();
	}

	public void establishConnection() {
		connection = dbConnection.getInstance();
	}

	public void initTables() throws SQLException {
		Statement stmt = connection.getConnection().createStatement();
		String createSchema = "CREATE SCHEMA IF NOT EXISTS " + schemaName;
		try {
			stmt.execute(createSchema);
			NodeDaoImpl.getInstance().initTable(nodeTable);
			EdgeDaoImpl.getInstance().initTable(edgesTable);
			LocationDoaImpl.getInstance().initTable(locationTable);
			MoveDaoImpl.getInstance().initTable(moveTable);
			System.out.println("Created the schema and the database");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getSQLState());
			System.out.println("Database update/creation error");
		}
	}

	public void loadDataIfEmpty() {
		NodeDaoImpl.getInstance().loadToRemote(null);
		EdgeDaoImpl.getInstance().loadToRemote(null);
		LocationDoaImpl.getInstance().loadToRemote(null);
		MoveDaoImpl.getInstance().loadToRemote(null);
	}

	public void resetData() throws SQLException {
		Statement stmt = connection.c.createStatement();
		String resetCommand = "DROP SCHEMA IF EXISTS " + schemaName + " CASCADE";
		try {
			stmt.executeUpdate(resetCommand);
			System.out.println("Deleted the database");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getSQLState());
			System.out.println("Could not reset the database");
		}
	}
}
