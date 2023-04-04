package edu.wpi.teamname.Database.ServiceRequests.FoodService;

import edu.wpi.teamname.Database.ServiceRequests.Room;
import edu.wpi.teamname.Database.ServiceRequests.Status;
import java.time.LocalTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class FoodDelivery {

  @Getter int deliveryID;
  @Getter OrderItemDAO cart;
  @Getter @Setter Date date;
  @Getter @Setter LocalTime time;
  @Getter Room room;
  @Getter @Setter String orderer;
  @Getter@Setter String assignedTo;
  @Getter @Setter Status orderStatus;
  @Getter @Setter String notes = "";

  public FoodDelivery(int deliveryID, OrderItemDAO cart, Date date, Room room, String orderedBy) {
    this.deliveryID = deliveryID;
    this.cart = cart;
    this.date = date;
    this.room = room;
    this.orderer = orderedBy;
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
