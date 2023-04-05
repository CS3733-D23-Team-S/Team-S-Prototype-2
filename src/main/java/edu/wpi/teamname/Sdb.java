package edu.wpi.teamname;

import edu.wpi.teamname.Database.DAOManager;
import edu.wpi.teamname.Database.Map.Edge;
import edu.wpi.teamname.Database.Map.Node;
import edu.wpi.teamname.Database.csvConverter;
import edu.wpi.teamname.algorithms.AStar;
import edu.wpi.teamname.algorithms.BFS;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Sdb {
  public static void main(String[] args) throws SQLException, NoSuchElementException {

    //    for (Edge thisEdge : converter.getEdges()) {
    //      System.out.println(thisEdge.toString());
    //    }

    DAOManager dbManager = new DAOManager();
    // Establish connection to database
    dbManager.establishConnection();

    // Create Empty Table
    dbManager.initTables();

  }
}
