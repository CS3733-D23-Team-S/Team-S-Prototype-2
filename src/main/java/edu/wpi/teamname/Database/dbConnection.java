package edu.wpi.teamname.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
  private static dbConnection single_instance;

  Connection c;
  private static final String url = "jdbc:postgresql://database.cs.wpi.edu:5432/teamsdb";
  private static final String user = "teams";
  private static final String password = "teams160";
  protected static final String schemaName = "hospitaldb";
  protected static final String nodeTable = schemaName + "." + "nodes";
  protected static final String edgesTable = schemaName + "." + "edges";

  private dbConnection() {
    try {
      Class.forName("org.postgresql.Driver");
      c = DriverManager.getConnection(url, user, password);
    } catch (Exception e) {
      e.printStackTrace();
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
    System.out.println("Opened database successfully");
  }

  // Static method
  // Static method to create instance of Singleton class
  public static synchronized dbConnection getInstance() {
    if (single_instance == null) single_instance = new dbConnection();

    return single_instance;
  }
}
