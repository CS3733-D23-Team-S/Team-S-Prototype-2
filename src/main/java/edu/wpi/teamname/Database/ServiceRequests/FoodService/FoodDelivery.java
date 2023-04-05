package edu.wpi.teamname.Database.ServiceRequests.FoodService;

import java.time.LocalTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class FoodDelivery {

  @Getter int deliveryID;
  @Getter OrderItemDAO cart;
  @Getter @Setter Date date;
  @Getter @Setter LocalTime time;
  @Getter int room;
  @Getter @Setter String orderer;
  @Getter @Setter String assignedTo;
  @Getter @Setter String orderStatus;
  @Getter @Setter String notes = "";

  public FoodDelivery(
      int deliveryID,
      OrderItemDAO cart,
      Date date,
      LocalTime time,
      int room,
      String orderedBy,
      String assignedTo,
      String orderStatus,
      String notes) {
    this.deliveryID = deliveryID;
    this.cart = cart;
    this.date = date;
    this.time = time;
    this.room = room;
    this.orderer = orderedBy;
    this.assignedTo = assignedTo;
    this.orderStatus = orderStatus;
    this.notes = notes;
  }

  public float orderTotal() {
    float total = 0;
    for (OrderItem orderItem : cart.cart) {
      total += orderItem.calculateCost();
    }
    return total;
  }
}
