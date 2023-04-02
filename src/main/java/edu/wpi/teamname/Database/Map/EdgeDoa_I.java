package edu.wpi.teamname.Database.Map;

import java.util.List;

public interface EdgeDoa_I {
    public List<Edge> getAllEdges();
    public Edge getEdge(Node startNode, Node endNode);

    public void deleteEdge(Node startNode, Node endNode);
}
