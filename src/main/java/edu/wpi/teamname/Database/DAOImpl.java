package edu.wpi.teamname.Database;

import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAOImpl {
  private static final String url = "jdbc:postgresql://database.cs.wpi.edu:5432/teamsdb";
  private static final String user = "teams";
  private static final String password = "teams160";
  protected static final String schemaName = "hospitaldb";
  protected static final String nodeTable = schemaName + "." + "nodes";
  protected static final String edgesTable = schemaName + "." + "edges";
  protected static final String foodsTable = schemaName + "." + "foods";
  dbConnection connection;

  public void establishConnection() {
    connection = dbConnection.getInstance();
  }

  public void initTables() throws SQLException {
    Statement stmt = connection.c.createStatement();

    String dropEdgeTable = "DROP TABLE IF EXISTS " + edgesTable;
    String dropFloorTable = "DROP TABLE IF EXISTS " + nodeTable + " CASCADE";
    String dropFoodTable = "DROP TABLE IF EXISTS " + foodsTable;

    String createSchema = "CREATE SCHEMA IF NOT EXISTS " + schemaName;
    String floorTableConstruct =
        "CREATE TABLE IF NOT EXISTS "
            + nodeTable
            + " (nodeID Varchar(100) UNIQUE PRIMARY KEY,"
            + "xcoord int,"
            + "ycoord int,"
            + "Floor int,"
            + "Building Varchar(100),"
            + "nodeType int,"
            + "longName Varchar(100),"
            + "shortName Varchar(100))";
    String edgeTableConstruct =
        "CREATE TABLE IF NOT EXISTS "
            + edgesTable
            + " "
            + "(startNode Varchar(100),"
            + "endNode Varchar(100),"
            + "edgeID Varchar(100) UNIQUE )";

    String foodTableConstruct =
        "CREATE TABLE IF NOT EXISTS "
            + foodsTable
            + " "
            + "(FoodID int,"
            + "Name Varchar(100),"
            + "Type Varchar(100),"
            + "PrepTime int,"
            + "Cuisine Varchar(100),"
            + "Price double precision,"
            + "Description Varchar(100),"
            + "Quantity int,"
            + "SoldOut boolean,"
            + "Image Varchar(100))";
    try {
      stmt.execute(createSchema);
      stmt.execute(dropFloorTable);
      stmt.execute(dropEdgeTable);
      stmt.execute(dropFoodTable);
      stmt.execute(floorTableConstruct);
      stmt.execute(edgeTableConstruct);
      stmt.execute(foodTableConstruct);
      System.out.println("Loaded the tables into the database");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getSQLState());
      System.out.println("Database update/creation error");
    }
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
