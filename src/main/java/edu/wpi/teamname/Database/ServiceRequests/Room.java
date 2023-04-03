package edu.wpi.teamname.Database.ServiceRequests;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

public class Room {
  @Getter @Setter private int nodeID;
  private int roomSize;

  private ArrayList<RoomFeatures> roomFeatures;

  public Room(int nodeID, int roomSize) {
    this.roomSize = roomSize;
    this.nodeID = nodeID;
  }
}
