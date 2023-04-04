package edu.wpi.teamname.Database.Login;

import edu.wpi.teamname.Database.dbConnection;

import java.sql.*;
import java.util.HashMap;

public class LoginDAOImpl implements LoginDAOI {
	private dbConnection connection;

	HashMap<String, String> loginInfo;
	String loginTableName = "Name";

	public LoginDAOImpl(HashMap<String, String> loginInfo) {
		establishConnection();
		this.loginInfo = loginInfo;
	}

	public void establishConnection() {
		connection = dbConnection.getInstance();
	}

	public void initTables() throws SQLException {

		String loginTableConstruct =
				"CREATE TABLE IF NOT EXISTS "
				+ loginTableName
				+ " (username Varchar(100) UNIQUE PRIMARY KEY,"
				+ "password Varchar(100) NOT NULL";
	}

	/**
	 * @param username
	 * @return true if user exists, false if otherwise
	 */
	private boolean checkIfUserExists(String username) {
		try {
			PreparedStatement preparedStatement =
					connection.getConnection().prepareStatement("SELECT * from " + loginTableName + " WHERE username = ?");
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) return true;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}

	/**
	 * @param username
	 * @param password
	 * @return false if user already exists, true if user is made successfully
	 */
	public boolean createLoginInfo(String username, String password) {
		// Check if username already exists
		boolean doesUserExist = checkIfUserExists(username);
		if (doesUserExist) return false;

		try {
			PreparedStatement preparedStatement =
					connection.getConnection().prepareStatement(
							"INSERT INTO " + loginTableName + " VALUES (username, password, permission)");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return true;
	}

	/**
	 * @param username
	 * @param password
	 * @return false if username/password does not exist, true if login is successful
	 */
	public boolean login(String username, String password) {
		boolean doesUserExist = checkIfUserExists(username);
		if (!doesUserExist) return false;

		String dbPassword;
		try {
			PreparedStatement preparedStatement =
					connection.getConnection().prepareStatement(
							"SELECT password FROM " + loginTableName + " WHERE username = ?");

			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			dbPassword = rs.getString("password");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return password.equals(dbPassword);
	}

	// public void setGlobalPermission(){}

	// public boolean checkEntry(String str){}

}
