package edu.wpi.teamname.Database.ServiceRequests;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

public class Room {
  @Getter @Setter private int nodeID;
  private String name;
  private int roomSize;

  private ArrayList<RoomFeatures> roomFeatures;

  public Room(int nodeID, String name, int roomSize) {

    this.roomSize = roomSize;
    this.name = name;
    this.nodeID = nodeID;
  }
}
