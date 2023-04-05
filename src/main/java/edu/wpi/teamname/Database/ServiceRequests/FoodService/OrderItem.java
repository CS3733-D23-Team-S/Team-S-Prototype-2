package edu.wpi.teamname.Database.ServiceRequests.FoodService;

import lombok.Getter;
import lombok.Setter;

/** The cart, stores food in DAOImpl */
public class OrderItem {

  private int cartID; // For past purchases
  @Getter private Food item;
  @Getter @Setter private int quantity;

  private FoodDAOImpl foodDAO = FoodDAOImpl.getInstance();

  public OrderItem(int cartID, Food item, int quantity) {
    this.cartID = cartID;
    this.item = item;
    this.quantity = quantity;
  }

  public double calculateCost() {
    return item.getFoodPrice() * quantity;
  }
}
