package edu.wpi.teamname.Database.Map;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Move {
  @Getter @Setter
  private int nodeID;
  @Getter @Setter
  private  String location;
@Getter @Setter
  private Date date;

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
