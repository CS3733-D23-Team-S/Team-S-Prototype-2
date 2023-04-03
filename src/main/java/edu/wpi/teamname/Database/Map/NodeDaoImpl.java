package edu.wpi.teamname.Database.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class NodeDaoImpl implements NodeDOA_I {
  private static NodeDaoImpl single_instance;

  private NodeDaoImpl() {}

  HashMap<Integer, Node> nodes = new HashMap<>();

  public static synchronized NodeDaoImpl getInstance() {
    if (single_instance == null) single_instance = new NodeDaoImpl();

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
  public void updateNode(Node node) {}

  @Override
  public void deleteStudent(Node node) {}

  public void csvToNode(String csvFilePath) {

    try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
      String headerLine = reader.readLine();
      String line;
      while ((line = reader.readLine()) != null) {
        String[] fields = line.split(",");
        //
        Node thisNode =
            new Node(
                Integer.parseInt(fields[0]),
                Integer.parseInt(fields[1]),
                Integer.parseInt(fields[2]),
                Floor.valueOf((String) fields[3]),
                fields[4]);
        nodes.put(Integer.valueOf(fields[0]), thisNode);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
