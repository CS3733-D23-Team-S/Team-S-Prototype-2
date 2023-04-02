package edu.wpi.teamname.Database.Map;

import lombok.Getter;
import lombok.Setter;

public class Edge {
  @Getter @Setter private Node startNode;
  @Getter @Setter private Node endNode;
  @Getter @Setter private String edgeID;

  public Edge(Node sN, Node eN) {
    startNode = sN;
    endNode = eN;
    edgeID = sN.getNodeID() + "_" + eN.getNodeID();
  }

  public void updateEdge(Node sN, Node eN) {
    startNode = sN;
    endNode = eN;
    edgeID = sN.getNodeID() + "_" + eN.getNodeID();
  }

  @Override
  public String toString() {
    return "Edge{"
        + "startNode="
        + startNode.getNodeID()
        + ", endNode="
        + endNode.getNodeID()
        + ", edgeID='"
        + edgeID
        + '}';
  }
}
