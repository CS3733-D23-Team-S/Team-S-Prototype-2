package edu.wpi.teamname.Database.ServiceRequests.FoodService;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class OrderItemDAO {
  @Getter int cartID;

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
