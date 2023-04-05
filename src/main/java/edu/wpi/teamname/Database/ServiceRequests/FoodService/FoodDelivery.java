package edu.wpi.teamname.Database.ServiceRequests.FoodService;

import java.time.LocalTime;
import java.sql.*;
import lombok.Getter;
import lombok.Setter;


public class FoodDelivery {

  @Getter int deliveryID;
  @Getter String cart;
  @Getter @Setter java.sql.Date date;
  @Getter @Setter Time time;
  @Getter int room;
  @Getter @Setter String orderer;
  @Getter @Setter String assignedTo;
  @Getter @Setter String orderStatus;
  @Getter @Setter double cost;
  @Getter @Setter String notes = "";

  public FoodDelivery(
      int deliveryID,
      OrderItem cart,
      Date date,
      Time time,
      int room,
      String orderedBy,
      String assignedTo,
      String orderStatus,
      String notes) {
    this.deliveryID = deliveryID;
    this.cart = cart.toString();
    this.date = date;
    this.time = time;
    this.room = room;
    this.orderer = orderedBy;
    this.assignedTo = assignedTo;
    this.orderStatus = orderStatus;
    this.cost = cart.getTotalPrice();
    this.notes = notes;
  }

}
