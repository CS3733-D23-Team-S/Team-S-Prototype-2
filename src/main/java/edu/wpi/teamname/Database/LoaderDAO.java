package edu.wpi.teamname.Database;

import edu.wpi.teamname.Database.Login.LoginDAOImpl;
import edu.wpi.teamname.Database.Map.EdgeDaoImpl;
import edu.wpi.teamname.Database.Map.LocationDoaImpl;
import edu.wpi.teamname.Database.Map.MoveDaoImpl;
import edu.wpi.teamname.Database.Map.NodeDaoImpl;
import java.sql.SQLException;
import java.sql.Statement;

public class LoaderDAO {
  final String schemaName = "hospitaldb";
  final String nodeTable = schemaName + "." + "nodes";
  final String edgesTable = schemaName + "." + "edges";
  final String locationTable = schemaName + "." + "locations";
  final String moveTable = schemaName + "." + "moves";

  final String loginTable = schemaName + "." + "login";
  final String defaultNodePath = "src/main/java/edu/wpi/teamname/Node.csv";
  final String defaultEdgePath = "src/main/java/edu/wpi/teamname/Edge.csv";
  final String defaultLocationPath = "src/main/java/edu/wpi/teamname/LocationName.csv";
  final String defaultMovePath = "src/main/java/edu/wpi/teamname/Move.csv";
  dbConnection connection;

  public LoaderDAO() {}

  public void load() throws SQLException {
    establishConnection();
    initTables();
    loadDataIfEmpty();
  }

  public void establishConnection() {
    connection = dbConnection.getInstance();
  }

  private void initTables() throws SQLException {
    Statement stmt = connection.getConnection().createStatement();
    String createSchema = "CREATE SCHEMA IF NOT EXISTS " + schemaName;
    try {
      stmt.execute(createSchema);
      System.out.println("Created the schema");
      NodeDaoImpl.getInstance().initTable(nodeTable);
      EdgeDaoImpl.getInstance().initTable(edgesTable);
      LocationDoaImpl.getInstance().initTable(locationTable);
      MoveDaoImpl.getInstance().initTable(moveTable);
      LoginDAOImpl.getInstance().initTables(loginTable);

    } catch (SQLException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getSQLState());
      System.out.println("Database update/creation error");
    }
  }

  private void loadDataIfEmpty() {
    NodeDaoImpl.getInstance().loadToRemote(defaultNodePath);
    EdgeDaoImpl.getInstance().loadToRemote(defaultEdgePath);
    LocationDoaImpl.getInstance().loadToRemote(defaultLocationPath);
    MoveDaoImpl.getInstance().loadToRemote(defaultMovePath);
  }

  public void resetData() throws SQLException {
    Statement stmt = connection.getConnection().createStatement();
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
