package edu.wpi.teamname;

import edu.wpi.teamname.Database.DAOManager;
import edu.wpi.teamname.Database.ServiceRequests.FoodService.*;
import edu.wpi.teamname.Database.ServiceRequests.Room;

public class Sdb {
  public static void main(String[] args) throws Exception {
    // String foodPath = "";
    FoodDAOImpl foodDao = FoodDAOImpl.getInstance();
    // foodDao.csvToFood(foodPath);

    DAOManager dbManager = new DAOManager();
    // Establish connection to database
    dbManager.establishConnection();

    // Create Empty Table
    dbManager.initTables();

    Food newFood =
        new Food(
            5,
            "Pizza",
            "Hello",
            4,
            "String fc",
            3.99,
            "String fd",
            false,
            "image",
            69,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false);
    Food newFoodt =
        new Food(
            6,
            "za",
            "Hello",
            4,
            "String fc",
            3.99,
            "String fd",
            false,
            "image",
            420,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false);
    // OrderItem orderItem = new OrderItem(1, newFood, 3);
    // OrderItemDAO cart = new OrderItemDAO(1);
    // cart.addOrderItem(newFood, 3);
    // FoodDelivery newRequest = new FoodDelivery(1, cart, new Date(), new Room(1, 3), "admin");

    foodDao.addFood(newFood);
    foodDao.addFood(newFoodt);
    /*
    System.out.println(foodDao.getFoods().get(newFood.getFoodID()));
    newFood.setFoodDescription("I changed the description to this");

    System.out.println(foodDao.getFoods().get(newFood.getFoodID()));

    foodDao.updateFood(newFood.getFoodID());
    */

    // foodDao.deleteFood(5);
    // dbManager.addOrderItem(orderItem, 1);
    // dbManager.addfoodRequest(newRequest);
    // foodDao.addFood(newFood);
    OrderItemDAO cart = new OrderItemDAO(1);
    cart.addOrderItem(newFood, 3);
    FoodDelivery newRequest =
        new FoodDelivery(1, cart, null, new Room(1, "Conference Room", 3), "admin");

    FoodDeliveryDAOImp foodRequest = FoodDeliveryDAOImp.getInstance();
    foodRequest.addFoodRequest(newRequest);
  }
  //
  //    String floorPath = "src/main/java/edu/wpi/teamname/Node.csv";
  //    String edgePath = "src/main/java/edu/wpi/teamname/Edge.csv";
  //
  //    NodeDaoImpl nodeDao = NodeDaoImpl.getInstance();
  //    EdgeDaoImpl edgeDao = EdgeDaoImpl.getInstance();
  //    nodeDao.csvToNode(floorPath);
  //    edgeDao.csvToEdges(edgePath);
  //
  //    //    for (Edge thisEdge : converter.getEdges()) {
  //    //      System.out.println(thisEdge.toString());
  //    //    }
  //
  //    DAOManager dbManager = new DAOManager();
  //    // Establish connection to database
  //    dbManager.establishConnection();
  //
  //    // Create Empty Table
  //    dbManager.initTables();
  //
  //    // Inputing Nodes into Data base
  //    for (Node thisNode : nodeDao.getAllNodes()) {
  //      dbManager.addNode(thisNode);
  //    }
  //
  //    // Inputting Edges into Database
  //    for (Edge thisEdge : edgeDao.getAllEdges()) {
  //      dbManager.addEdge(thisEdge);
  //    }
  //    dbManager.constructLocalDataBase();
  //    //    dbManager.printLocalDatabases();
  //    //    dbManager.updateLocationName("CLABS002L1", "White House");
  //    //    dbManager.updateCoord("CLABS002L1", 200, 300);
  //    //    dbManager.retrieveRow("CLABS002L1");
  //    //    dbManager.deleteNode("CSERV001L2");
  //
  //    //    dbManager.printLocalDatabases();
  //
  //    // App.launch(App.class, args);
  //  }

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
