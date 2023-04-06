package edu.wpi.teamname.Database.ServiceRequests.ConferenceRoom;

import edu.wpi.teamname.Database.ServiceRequests.Room;
import edu.wpi.teamname.Database.ServiceRequests.Status;
import java.time.LocalTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class ConfRoomRequest {
  @Getter int reservationID;

  @Getter @Setter Date date;
  @Getter @Setter LocalTime time;
  @Getter Room room;
  @Getter @Setter String orderer;
  @Getter @Setter String assignedTo;
  @Getter @Setter Status orderStatus;

  @Getter @Setter String notes = "";

  public ConfRoomRequest(int reservationID, Date date, Room room, String orderedBy) {
    this.reservationID = reservationID;

    this.date = date;
    this.room = room;
    this.orderer = orderedBy;
    this.orderStatus = Status.valueOf("Received");
  }
}
