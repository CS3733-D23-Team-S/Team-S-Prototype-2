package edu.wpi.teamname.Database.ServiceRequests.FoodService;

import edu.wpi.teamname.Database.ServiceRequests.Room;
import edu.wpi.teamname.Database.ServiceRequests.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class FoodDelivery {

  int deliveryID;
  OrderItemDAO cart;
  Date date;
  Room room;
  String user;
  @Getter @Setter Status orderStatus;

  public FoodDelivery(int deliveryID, int cartID, Date date, Room room, String user) {
    this.deliveryID = deliveryID;
    this.cart = new OrderItemDAO(cartID);
    this.date = date;
    this.room = room;
    this.user = user;
    this.orderStatus = Status.valueOf("Received");
  }

  public float orderTotal() {
    float total = 0;
    for (OrderItem orderItem : cart.cart) {
      total += orderItem.calculateCost();
    }
    return total;
  }


}
