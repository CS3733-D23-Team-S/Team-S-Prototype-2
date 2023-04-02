package edu.wpi.teamname.Database.Map;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

public class Node {
  @Getter @Setter private String nodeID;
  @Getter @Setter private int xCoord;
  @Getter @Setter private int yCoord;
  @Getter @Setter private Floor floor;
  @Getter @Setter private String building;
  @Getter @Setter private LinkedList<Location> locations;



  public Node(
      String nodeID,
      int xCoord,
      int yCoord,
      Floor floor,
      String building

      ) {
    this.nodeID = nodeID;
    this.xCoord = xCoord;
    this.yCoord = yCoord;
    this.floor = floor;
    this.building = building;


  }

  @Override
  public String toString() {

    return "Node{"
        + "nodeID="
        + nodeID
        + "  "
        + "coords=("
        + xCoord
        + ", "
        + yCoord
        + "  "
        + "floor="
        + floor
        + "  "
        + "building="
        + building;
  }
}
