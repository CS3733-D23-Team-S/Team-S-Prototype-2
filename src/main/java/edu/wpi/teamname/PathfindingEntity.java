package edu.wpi.teamname;

import edu.wpi.teamname.Database.DAOManager;
import edu.wpi.teamname.algorithms.AStar;
import java.sql.SQLException;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

public class PathfindingEntity {

  @Getter @Setter String startingLocation;

  @Getter @Setter String destination;

  @Getter @Setter ArrayList<String> nodesTraversed;

  @Getter @Setter DAOManager manager;

  @Getter @Setter AStar aStar;

  public PathfindingEntity(String startingLocation, String destination) {
    this.startingLocation = startingLocation;
    this.destination = destination;
    this.nodesTraversed = new ArrayList<>();
    this.manager = new DAOManager();
    this.aStar = new AStar(manager);
  }

  public void generatePath() throws SQLException {
    this.nodesTraversed = this.aStar.findPath(this.startingLocation, this.destination);
    this.manager.constructLocalDataBase();
    this.nodesTraversed = this.aStar.findPath(this.startingLocation, this.destination);
  }
}
