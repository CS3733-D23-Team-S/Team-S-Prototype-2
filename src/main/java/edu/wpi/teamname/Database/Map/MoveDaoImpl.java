package edu.wpi.teamname.Database.Map;

import edu.wpi.teamname.Database.dbConnection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import lombok.Getter;

public class MoveDaoImpl implements MoveDAO_I {

  private static MoveDaoImpl single_instance;
  @Getter private String name;
  dbConnection connection;
  @Getter List<Move> moves;
  @Getter HashMap<Integer, Move> movesORM = new HashMap<>();
  LocationDoaImpl locationDoa = LocationDoaImpl.getInstance();
  NodeDaoImpl nodeDao = NodeDaoImpl.getInstance();

  private MoveDaoImpl() {
    connection = dbConnection.getInstance();
  }

  public static MoveDaoImpl getInstance() {
    if (single_instance == null) single_instance = new MoveDaoImpl();

    return single_instance;
  }

  @Override
  public List<Move> getAllMoves() {
    return moves;
  }

  @Override
  public void initTable(String name) {
    this.name = name;
    String moveTable =
        "CREATE TABLE IF NOT EXISTS "
            + name
            + " "
            + "(nodeID int, location varchar(100), date DATE)";
    try {
      Statement stmt = connection.getConnection().createStatement();
      stmt.execute(moveTable);
    } catch (SQLException e) {
      e.getMessage();
      e.printStackTrace();
      System.out.println("Error with creating the node table");
    }
  }

  @Override
  public List<Move> getLocationMove(String location) {
    List<Move> previousMoves = new ArrayList<>();

    for (Move thisMove : moves) {
      if (thisMove.getLocation().equals(location)) previousMoves.add(thisMove);
    }
    return previousMoves;
  }

  @Override
  public Move getMove(String location, Date moveDate) throws Exception {
    for (Move thisMove : moves) {
      if (thisMove.getLocation().equals(location) && thisMove.getDate().equals(moveDate))
        return thisMove;
    }
    throw new NullPointerException();
  }

  public void processMoveRequest(int nodeID, String location, LocalDate date) throws Exception {
    Node newNode = nodeDao.getNode(nodeID);

    if (!locationDoa.getLocation(location).checkDateEquals(date)) {
      Location thisLocation = locationDoa.getLocation(location);
      newNode.addLocation(thisLocation);
      thisLocation.setNode(newNode);
      moves.add(new Move(nodeID, location, date));
    } else throw new Exception("Moved Today already");
  }

  public void loadToRemote(String pathToCSV) {
    try {
      Statement stmt = connection.getConnection().createStatement();
      String checkTable = "SELECT * FROM " + name;
      ResultSet check = stmt.executeQuery(checkTable);
      if (check.next()) constructFromRemote();
      else constructRemote(pathToCSV);
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
        LocalDate date = DateParser.parseDate(data.getString("date"));
        Move thisMove = new Move(data.getInt("nodeID"), data.getString("location"), date);
        moves.add(thisMove);
        movesORM.put(thisMove.getNodeID(), thisMove);
      }
      String getNodes = "SELECT nodeID FROM " + nodeDao.getName();

    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println(e.getSQLState());
      System.out.println("Error accessing the remote and constructing the list of moves");
    }
  }

  private void constructRemote(String csvFilePath) {
    try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
      try {
        reader.readLine();
        String line;
        while ((line = reader.readLine()) != null) {
          String[] fields = line.split(",");
          LocalDate date = DateParser.parseDate(fields[2]);
          System.out.println(Arrays.toString(fields));
          Move thisMove = new Move(Integer.parseInt(fields[0]), fields[1], date);
          Statement stmt = connection.getConnection().createStatement();
          String insertMove =
              "INSERT INTO "
                  + name
                  + " (nodeID, location, date) VALUES ("
                  + Integer.parseInt(fields[0])
                  + ", "
                  + fields[1]
                  + ", "
                  + date
                  + ")";
          stmt.executeUpdate(insertMove);
          moves.add(thisMove);
          movesORM.put(thisMove.getNodeID(), thisMove);
        }
        constructFromRemote();
      } catch (SQLException e) {
        e.printStackTrace();
        System.out.println(e.getSQLState());
        System.out.println("Error accessing the remote and constructing the list of moves");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static class DateParser {
    public static LocalDate parseDate(String dateString) {
      // Create a formatter for the input date string format
      DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

      // Parse the input date string into a LocalDate object
      LocalDate date = LocalDate.parse(dateString, inputFormatter);

      // Create a formatter for the output date string format
      DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

      // Format the LocalDate object as a string in the desired output format
      String outputString = date.format(outputFormatter);

      // Parse the output string into a LocalDate object
      return LocalDate.parse(outputString);
    }
  }
}
