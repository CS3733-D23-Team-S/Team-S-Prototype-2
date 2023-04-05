package edu.wpi.teamname;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

public class PathfindingEntity {

  @Getter @Setter String startingLocation;

  @Getter @Setter String destination;

  @Getter @Setter ArrayList<String> nodesTraversed;

  // create AStar object

  public PathfindingEntity(String startingLocation, String destination) {
    this.startingLocation = startingLocation;
    this.destination = destination;
    nodesTraversed = new ArrayList<>();
  }

  /*
  public void generatePath() {
    this.nodesTraversed = this.aStar.findPath(this.startingLocation, this.destination);
  }
   */

}
