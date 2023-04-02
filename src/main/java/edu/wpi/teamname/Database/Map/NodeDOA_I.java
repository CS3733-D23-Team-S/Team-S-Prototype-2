package edu.wpi.teamname.Database.Map;

import java.util.List;

public interface NodeDOA_I {
    public List<Node> getAllStudents();
    public Node getNode(int nodeID);
    public void updateNode(Node node);
    public void deleteStudent(Node node);
}