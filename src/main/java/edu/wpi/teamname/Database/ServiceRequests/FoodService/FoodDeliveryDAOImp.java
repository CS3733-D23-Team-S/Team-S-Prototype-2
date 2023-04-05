package edu.wpi.teamname.Database.ServiceRequests.FoodService;

import edu.wpi.teamname.Database.dbConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class FoodDeliveryDAOImp implements FoodDeliveryDAO_I {
  protected static final String schemaName = "hospitaldb";
  protected static final String foodRequestsTable = schemaName + "." + "foodRequests";
  HashMap<Integer, FoodDelivery> requests = new HashMap<>();
  dbConnection connection = dbConnection.getInstance();
  static FoodDeliveryDAOImp single_instance = null;

  private FoodDeliveryDAOImp() {}

  public static synchronized FoodDeliveryDAOImp getInstance() {

    if (single_instance == null) single_instance = new FoodDeliveryDAOImp();

    return single_instance;
  }

  public void addFoodRequest(FoodDelivery request) {
    requests.put(request.deliveryID, request);
    try {
      PreparedStatement preparedStatement =
          connection
              .getC()
              .prepareStatement(
                  "INSERT INTO "
                      + foodRequestsTable
                      + " (deliveryID, CartID, orderDate , employee, room, cost, notes) "
                      + " VALUES (?, ?, ?, ?, ?, ?, ?)");
      preparedStatement.setInt(1, request.getDeliveryID());
      preparedStatement.setInt(2, request.getCart().getCartID());
      preparedStatement.setDate(3, null);
      preparedStatement.setString(4, request.getOrderer());
      preparedStatement.setInt(5, request.getDeliveryID());
      preparedStatement.setDouble(6, request.orderTotal());
      preparedStatement.setString(7, request.getNotes());

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println(e.getSQLState());
    }
  }

  @Override
  public List<FoodDelivery> getAllRequests() {
    return null;
  }

  @Override
  public FoodDelivery getRequest(int requestID) {
    return null;
  }

  @Override
  public void addRequest(FoodDelivery request) {}

  @Override
  public void deleteRequest(FoodDelivery request) {}
}
