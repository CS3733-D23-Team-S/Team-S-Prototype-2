package edu.wpi.teamname.Database;

import edu.wpi.teamname.Database.Map.Edge;
import edu.wpi.teamname.Database.Map.Floor;
import edu.wpi.teamname.Database.Map.Node;
import edu.wpi.teamname.Database.ServiceRequests.FoodService.Food;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import lombok.Getter;

public class DAOManager extends DAOImpl implements DAO_I {

  @Getter private HashMap<String, HashSet<String>> neighbors;
  @Getter private HashMap<Integer, Node> nodes;
  @Getter private HashMap<Integer, Food> foods;

  public DAOManager() {
    neighbors = new HashMap<>();
    nodes = new HashMap<>();
    foods = new HashMap<>();
  }

  @Override
  public void constructLocalDataBase() throws SQLException {
    if (!nodes.isEmpty()) nodes.clear();
    if (!neighbors.isEmpty()) neighbors.clear();
    if (!foods.isEmpty()) foods.clear();
    constructLocalFloorDataBase();
    constructLocalNeighborsDB();
  }

  public void addNode(Node thisNode) {
    try {
      PreparedStatement preparedStatement =
          connection.c.prepareStatement(
              "INSERT INTO "
                  + nodeTable
                  + " (nodeID ,xCoord ,yCoord , Floor, Building) "
                  + " VALUES (?, ?, ? ,?, ?)");
      preparedStatement.setInt(1, thisNode.getNodeID());
      preparedStatement.setInt(2, thisNode.getXCoord());
      preparedStatement.setInt(3, thisNode.getYCoord());
      preparedStatement.setInt(4, thisNode.getFloor().ordinal());
      preparedStatement.setString(5, thisNode.getBuilding());

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println(e.getSQLState());
    }
  }

  //  (deliveryID int UNIQUE PRIMARY KEY, "
  //          + "int cartID, "
  //          + "Date orderDate, "
  //          + "String user, "
  //          + "String room,
  /*
   public void addfoodRequest(FoodDelivery request) {
     try {
       PreparedStatement preparedStatement =
           connection.c.prepareStatement(
               "INSERT INTO "
                   + foodRequestsTable
                   + " (deliveryID, CartID, orderDate , employee, room, cost, notes) "
                   + " VALUES (?, ?, ?, ?, ?, ?, ?)");
       preparedStatement.setInt(1, request.getDeliveryID());
       preparedStatement.setInt(2, request.getCart().getCartID());
       preparedStatement.setDate(3, null);
       preparedStatement.setString(4, request.getUser());
       preparedStatement.setInt(5, request.getRoom().getNodeID());
       preparedStatement.setDouble(6, request.orderTotal());
       preparedStatement.setString(7, request.getNotes());

       preparedStatement.executeUpdate();

     } catch (SQLException e) {
       e.printStackTrace();
       System.out.println(e.getSQLState());
     }
   }


  */
  public void addEdge(Edge thisEdge) {
    try {
      PreparedStatement preparedStatement =
          connection.c.prepareStatement(
              "INSERT INTO " + edgesTable + " (startNode, endNode) " + " VALUES (?, ?)");

      preparedStatement.setInt(1, thisEdge.getStartNode().getNodeID());
      preparedStatement.setInt(2, thisEdge.getEndNode().getNodeID());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  // Left if desired to use, but technically the above method will be faster and not rely on the
  // remote
  public void updateLocationName(int nodeId, String longName) {
    try {
      PreparedStatement preparedStatement =
          connection.c.prepareStatement(
              "UPDATE " + nodeTable + " SET longname = ? WHERE nodeID = ?");
      preparedStatement.setString(1, longName);
      preparedStatement.setInt(2, nodeId);
      Node temp = nodes.get(nodeId);
      if (temp == null) {
        System.out.println("This node is not in the database");
        return;
      }

      nodes.put(nodeId, temp);
      preparedStatement.executeUpdate();
      System.out.println("Updated Node");
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println(e.getSQLState());
      // Handle the exception appropriately
    }
    // Handles the edge updates as well
  }

  public void updateCoord(int nodeId, int xcoord, int ycoord) {
    try {
      PreparedStatement preparedStatement =
          connection.c.prepareStatement(
              "UPDATE " + nodeTable + " SET xcoord = ?, ycoord = ? WHERE nodeID = ?");
      preparedStatement.setInt(1, xcoord);
      preparedStatement.setInt(2, ycoord);
      preparedStatement.setInt(3, nodeId);
      Node temp = nodes.get(nodeId);
      if (temp == null) {
        System.out.println("This node is not in the database");
        return;
      }
      temp.setXCoord(xcoord);
      temp.setXCoord(ycoord);
      nodes.put(nodeId, temp);
      preparedStatement.executeUpdate();
      System.out.println("Updated Coordinates");
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println(e.getSQLState());
      // Handle the exception appropriately
    }
  }

  public void deleteNode(String target) throws SQLException {
    PreparedStatement deleteNode =
        connection.c.prepareStatement("DELETE FROM " + nodeTable + " WHERE nodeID = ?");
    try {
      deleteNode.setString(1, target);
      deleteNode.execute();
      nodes.remove(target);
      neighbors.remove(target);

      for (String key : neighbors.keySet()) {
        neighbors.get(key).remove(target);
        if (neighbors.get(key).isEmpty()) neighbors.remove(key);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println(e.getSQLState());
    }
  }

  //	private void addNodeToFloorDB(Node node) {
  //		nodes.put(node.getNodeID(), node);
  //	}

  private void constructLocalFloorDataBase() throws SQLException {
    Statement stmt = connection.c.createStatement();
    String listOfNodes = "SELECT * FROM " + nodeTable;
    try {
      ResultSet data = stmt.executeQuery(listOfNodes);
      while (data.next()) {
        int nodeID = data.getInt("nodeID");
        int xCoord = data.getInt("xCoord");
        int yCoord = data.getInt("yCoord");
        int floor = data.getInt("Floor");
        String building = data.getString("Building");

        Node floorNode = new Node(nodeID, xCoord, yCoord, Floor.values()[floor], building);
        nodes.put(nodeID, floorNode);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println(e.getSQLState());
      System.out.println("Error accessing the remote and constructing the list of nodes");
    }
  }

  private void constructLocalNeighborsDB() throws SQLException {
    Statement stmt = connection.c.createStatement();
    String getNodes = "SELECT nodeID FROM " + nodeTable;
    PreparedStatement getNeighbors =
        connection.c.prepareStatement(
            "SELECT * FROM " + edgesTable + " WHERE startNode = ? OR endnode = ?");
    try {
      ResultSet listOfNodes = stmt.executeQuery(getNodes);
      while (listOfNodes.next()) {
        String currentNode = listOfNodes.getString("nodeID");
        getNeighbors.setString(1, currentNode);
        getNeighbors.setString(2, currentNode);
        ResultSet data = getNeighbors.executeQuery();
        HashSet<String> neighbors = new HashSet<>();
        while (data.next()) {
          neighbors.add(data.getString("endNode"));
          neighbors.add(data.getString("startNode"));
        }
        neighbors.remove(currentNode);
        this.neighbors.put(currentNode, neighbors);
      }
    } catch (SQLException e) {
      System.out.println("Error accessing the remote and constructing the list of edges");
    }
  }

  public void retrieveNodeRow(String target) {
    if (nodes.get(target) == null) {
      System.out.println("This node is not in the database, so its row cannot be printed");
      return;
    }
    System.out.println(nodes.get(target).toString());
  }

  public void retrieveEdgeInformation(String target) {
    if (neighbors.get(target) == null) {
      System.out.println("This node is not in the database, so its row cannot be printed");
      return;
    }
    System.out.println("From this starting node, the following edges exist:");
    for (String name : neighbors.get(target)) {
      System.out.println(target + "_" + name);
    }
  }

  public void printLocalDatabases() {
    for (int key : nodes.keySet()) {
      System.out.println(nodes.get(key));
    }
    for (String key : neighbors.keySet()) {
      System.out.print(key + "\t");
      System.out.println(neighbors.get(key).toString());
    }
  }
}
