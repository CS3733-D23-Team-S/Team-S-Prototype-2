package edu.wpi.teamname;

import edu.wpi.teamname.Database.DAOManager;
import edu.wpi.teamname.Database.Map.Edge;
import edu.wpi.teamname.Database.Map.Node;
import edu.wpi.teamname.Database.csvConverter;
import edu.wpi.teamname.Database.Map.AStar;
import edu.wpi.teamname.Database.Map.BFS;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Sdb {
  public static void main(String[] args) throws SQLException, NoSuchElementException {
    Scanner sc = new Scanner(System.in);
    String floorPath = "src/main/java/edu/wpi/teamname/L1Nodes.csv";
    String edgePath = "src/main/java/edu/wpi/teamname/L1Edges.csv";
    System.out.println(
        "Please enter the path to the CSV that contains the information for the nodes."
            + "\nIf you have no path to specify, then please press 1 and the program will use a preloaded database:");
    String temp = sc.nextLine();
    if (!temp.equals("1")) floorPath = temp;

    System.out.println(
        "Please enter the path to the CSV that contains the information for the edges. "
            + "\nIf you have no path to specify, then please press 1 and the program will use a preloaded databased:");
    temp = sc.nextLine();
    if (!temp.equals("1")) edgePath = temp;

    csvConverter converter = new csvConverter();
    converter.csvToNode(floorPath);
    converter.csvToEdges(edgePath);

    //    for (Edge thisEdge : converter.getEdges()) {
    //      System.out.println(thisEdge.toString());
    //    }

    DAOManager dbManager = new DAOManager();
    // Establish connection to database
    dbManager.establishConnection();

    // Create Empty Table
    dbManager.initTables();

    // Inputing Nodes into Data base
    for (Node thisNode : converter.getNodes().values()) {
      dbManager.addNode(thisNode);
    }

    // Inputting Edges into Database
    for (Edge thisEdge : converter.getEdges()) {
      dbManager.addEdge(thisEdge);
    }
    dbManager.constructLocalDataBase();
    //    dbManager.printLocalDatabases();
    //    dbManager.updateLocationName("CLABS002L1", "White House");
    //    dbManager.updateCoord("CLABS002L1", 200, 300);
    //    dbManager.retrieveRow("CLABS002L1");
    //    dbManager.deleteNode("CSERV001L2");

    //    dbManager.printLocalDatabases();

    help();
    while (true) {
      System.out.println("----------Home-----------");
      String choice = sc.nextLine();

      switch (choice) {
        case "information":
          System.out.println(
              "You're trying to access information from the table.\n"
                  + "Please type either 'node' or 'edge' in order to specify the type of data to access.\n"
                  + "Otherwise, press any key to got back to the beginning");
          choice = sc.nextLine();
          switch (choice) {
            case "node":
              choice = sc.nextLine();
              dbManager.retrieveNodeRow(choice);
              break;
            case "edge":
              choice = sc.nextLine();
              dbManager.retrieveEdgeInformation(choice);
              break;
            default:
              break;
          }
        case "update":
          {
            System.out.println(
                "You're trying to update information from the table.\n"
                    + "Please type either 'name' or 'location' in order to specify the type of data to access.\n"
                    + "Otherwise, press any key to got back to the beginning");
            choice = sc.nextLine();
            String id = sc.nextLine();
            switch (choice) {
              case "location":
                int xcoord = sc.nextInt();
                int ycoord = sc.nextInt();
                dbManager.updateCoord(id, xcoord, ycoord);
                break;
              case "name":
                String name = sc.nextLine();
                dbManager.updateLocationName(id, name);
                break;
              default:
                break;
            }
          }
        case "reset":
          {
            System.out.println("You have chosen to reset the database.\nResetting the database.");
            dbManager.initTables();
            for (Node thisNode : converter.getNodes().values()) dbManager.addNode(thisNode);
            for (Edge thisEdge : converter.getEdges()) dbManager.addEdge(thisEdge);
            dbManager.constructLocalDataBase();
            break;
          }
        case "import":
          {
            System.out.println(
                "You have chosen to import an new table into the database.\n"
                    + "Please enter the path to the node CSV table");
            floorPath = sc.nextLine();
            System.out.println("Please enter the path to the edge CSV table");
            edgePath = sc.nextLine();
            converter.csvToNode(floorPath);
            converter.csvToEdges(edgePath);
            dbManager.initTables();
            for (Node thisNode : converter.getNodes().values()) dbManager.addNode(thisNode);
            for (Edge thisEdge : converter.getEdges()) dbManager.addEdge(thisEdge);
            dbManager.constructLocalDataBase();
            break;
          }
        case "export":
          System.out.println(
              "You have chosen to export the database.\n"
                  + "Please enter the path to the node CSV table");
          String floorExport = sc.nextLine();
          System.out.println("Please enter the path to the edge CSV table");
          String edgeExport = sc.nextLine();
          break;
        case "BFS":
          {
            System.out.println(
                "You selected to run a BFS search. Please enter the name of the first node:");
            String id1 = sc.nextLine();
            System.out.println("Please enter the name of the second node");
            String id2 = sc.nextLine();
            BFS bfs = new BFS(dbManager);
            ArrayList<String> path = bfs.findPath(id1, id2);
            System.out.println("The path generated by BFS is:\n" + path);
            break;
          }
        case "Astar":
          {
            System.out.println(
                "You selected to run an A* search. Please enter the name of the first node:");
            String id1 = sc.nextLine();
            System.out.println("Please enter the name of the second node");
            String id2 = sc.nextLine();
            AStar astar = new AStar(dbManager);
            ArrayList<String> path = astar.findPath(id1, id2);
            System.out.println("The fastest path between these points using A* is: \n" + path);
            break;
          }
        case "help":
          help();
          break;
        case "exit":
          System.exit(0);
        default:
          System.out.println("This is not an option, you might have made a typo");
          break;
      }
    }
    // App.launch(App.class, args);
  }

  public static void help() {
    System.out.println("HELP------------");
    System.out.println(
        "To access information from the table, please type 'information'\n"
            + "\tThen type either 'node' or 'edge' to specify if you want to access a node or an edge.\n"
            + "\tThen specify the name of the node/edge that you want to access.");
    System.out.println(
        "To update information in a node, please type 'update'\n"
            + "\tThen type either 'location' or 'name' to specify if you are updating either the node's coordinates or it's name, Then submit the node's ID\n "
            + "\tIf you are updating the coordinates, then type the coordinates as (x,y),"
            + " where x and y are whole numbers"
            + "\tIf you are updating the name, please just type the desired name");
    System.out.println(
        "To reload\\load from a CSV, type 'import'\n"
            + "\tIf you just want to reset the database, type 'reset'\n"
            + "\tIf you want to overwrite the current database with new data, submit first the path to the CSV with the nodes and then the CSV with the edges");
    System.out.println(
        "To export to CSV, please type 'export'\n"
            + "\tThen specify the output path for the CSV for the nodes and then the output path for the CSV for the edges");
    System.out.println(
        "To run an BFS search between nodes, please type 'BFS' and then submit the names of the start and end nodes");
    System.out.println(
        "To run an A* search between nodes, please type 'Astar' and then submit the names of the start and end nodes");
    System.out.println("To exit, type 'exit'");
    System.out.println("Type 'help' in order to see this menu again");
  }
}
