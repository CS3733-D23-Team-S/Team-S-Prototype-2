package edu.wpi.teamname.Database.ServiceRequests;

import edu.wpi.teamname.Database.Map.Node;

import java.util.ArrayList;

public class Room {
  private int nodeID;
  private int roomSize;

  private ArrayList<RoomFeatures> roomFeatures;

  public Room(int nodeID, int roomSize) {
    this.roomSize = roomSize;
    this.nodeID = nodeID;

  }
}
