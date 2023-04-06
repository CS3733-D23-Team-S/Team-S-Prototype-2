package edu.wpi.teamname.Database.ServiceRequests;

import edu.wpi.teamname.Database.ServiceRequests.ConferenceRoom.ConfRoomRequest;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

// TODO read from pathfinding

public class Room { // TODO name + floor -> roomLocation, features -> list(?)
  @Getter @Setter int id; // TODO can be replaced if too complex!
  @Getter @Setter String name;
  @Getter @Setter String floor;
  @Getter @Setter int cap;
  @Getter @Setter String features;
  @Getter @Setter ArrayList<ConfRoomRequest> roomRequestList = new ArrayList<ConfRoomRequest>();

  public Room(int id, String name, String floor, int cap, String features) {
    this.id = id;
    this.name = name;
    this.floor = floor;
    this.cap = cap;
    this.features = features;
  }

  /*
  public boolean addReservation(Reservation r) {
    // rough function!!! just for testing TODO rewrite this!
    for (int i = 0; i < reservationsList.size(); i++) {
      if (r.getStartTime() > reservationsList.get(i).getEndTime()
          && reservationsList.get(i).startTime() < r.endTime()) {
        return false;
      } else {
        reservationsList.add(r);
        System.out.println("ERROR: Time is already booked.");
        return true;
      }
    }
    return true;
  }

   */
}
