package edu.wpi.teamname.Database.Map;

import java.util.HashMap;
import java.util.List;

public class NodeDaoImpl implements NodeDOA_I{
    private static NodeDaoImpl single_instance;
    HashMap<Integer, Node> nodes;
    public static synchronized NodeDaoImpl getInstance()
    {
        if (single_instance == null)
            single_instance = new NodeDaoImpl();

        return single_instance;
    }
    @Override
    public List<Node> getAllNodes() {
        return null;
    }

    @Override
    public Node getNode(int nodeID) {
        return nodes.get(nodeID);
    }

    @Override
    public void updateNode(Node node) {

    }

    @Override
    public void deleteStudent(Node node) {

    }
}
