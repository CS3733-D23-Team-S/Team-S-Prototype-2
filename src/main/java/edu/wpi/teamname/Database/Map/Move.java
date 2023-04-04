package edu.wpi.teamname.Database.Map;

import java.util.Date;

public class Move {
  int nodeID;
  String location;

  Date date;

  public Move(int nodeID, String location, Date date) {
    this.nodeID = nodeID;
    this.date = date;
    this.location = location;
  }

  @Override
  public String toString() {
    return "Move{" + "nodeID=" + nodeID + ", location='" + location + '\'' + ", date=" + date + '}';
  }
}
