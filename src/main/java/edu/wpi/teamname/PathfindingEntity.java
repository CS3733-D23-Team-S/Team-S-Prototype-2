package edu.wpi.teamname;

import edu.wpi.teamname.Database.Map.Node;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class PathfindingEntity {

  @Getter @Setter
  String startingLocation;

  @Getter
  @Setter
  String destination;

  @Getter @Setter
  ArrayList<Node> nodesTraversed;



  public PathfindingEntity(String startingLocation, String destination) {
    this.startingLocation = startingLocation;
    this.destination = destination;
    nodesTraversed = new ArrayList<>();
  }

  /*
  public Boolean realLocations() {
    if (listOfLocations.contains(this.startingLocation) && listOfLocations.contains(this.destination)) {
      return true;
    } else {
      return false;
    }
  }
   */


  /*
  public void generatePath() {
    if (realLocation(this.startingLocation) && realLocation(destination)) {
      // run search
      // this.nodesTraversed = pathFromSearch;
    }
  }
  */


}
