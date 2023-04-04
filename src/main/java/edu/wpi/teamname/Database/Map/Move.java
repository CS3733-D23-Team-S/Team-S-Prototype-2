package edu.wpi.teamname.Database.Map;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

public class Move {
  @Getter @Setter private int nodeID;
  @Getter @Setter private String location;
  @Getter @Setter private LocalDate date;

  public Move(int nodeID, String location, LocalDate date) {
    this.nodeID = nodeID;
    this.date = date;
    this.location = location;
  }

  @Override
  public String toString() {
    return "Move{"
        + "nodeID = "
        + nodeID
        + ", location = '"
        + location
        + ", date = "
        + date.toString()
        + '}';
  }
}
