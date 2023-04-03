package edu.wpi.teamname.Database.ServiceRequests;

import java.util.ArrayList;

public class Room {
  private int RoomSize;
  private int RoomCap;
  private ArrayList<RoomFeatures> RoomFeats;

  public Room(int rs, int rc, ArrayList<RoomFeatures> rf) {
    RoomSize = rs;
    RoomCap = rc;
    RoomFeats = rf;
  }
}
