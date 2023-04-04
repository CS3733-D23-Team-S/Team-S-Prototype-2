package edu.wpi.teamname.Database.ServiceRequests.FoodService;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.wpi.teamname.Database.dbConnection;
import lombok.Getter;

public class OrderItemDAO {
  @Getter int cartID;
  protected static final String schemaName = "hospitaldb";
  protected static final String cartTable = schemaName + "." + "cart";
  private final dbConnection connection = dbConnection.getInstance();

  List<OrderItem> cart = new ArrayList<>();

  public OrderItemDAO(int id) {
    this.cartID = id;
  }

  public List<OrderItem> getAllOrderItems() {
    return cart;
  }

  public OrderItem getOrderItem(String foodName) throws Exception {
    for (OrderItem orderItem : cart)
      if (orderItem.getItem().getFoodName().equals(foodName)) return orderItem;
    throw new NullPointerException("Item Not Present");
  }

  public void addOrderItem(Food item, int quantity) throws Exception {
    cart.add(new OrderItem(this.cartID, item, quantity));
  }

  public void addOrderItemToDb(OrderItem orderItem, int cartID) {
    try {
      PreparedStatement preparedStatement =
              connection.c.prepareStatement(
                      "INSERT INTO " + cartTable + " (CartID, FoodID ,quantity) " + " VALUES (?, ?, ?)");
      preparedStatement.setInt(1, cartID);
      preparedStatement.setInt(2, orderItem.getItem().getFoodID());
      preparedStatement.setInt(3, orderItem.getQuantity());

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println(e.getSQLState());
    }
  }

  public void updateOrderQuantity(String foodName, int newQuantity) {
    for (OrderItem orderItem : cart)
      if (orderItem.getItem().getFoodName().equals(foodName)) orderItem.setQuantity(newQuantity);
    throw new NullPointerException("Item Not Present");
  }

  public void deleteOrderItem(String foodName) {
    cart.removeIf(orderItem -> orderItem.getItem().getFoodName().equals(foodName));
    throw new NullPointerException("Item Not Present");
  }
}
