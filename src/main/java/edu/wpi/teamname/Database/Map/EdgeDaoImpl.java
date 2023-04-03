package edu.wpi.teamname.Database.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class EdgeDaoImpl implements EdgeDoa_I {
  private static EdgeDaoImpl single_instance;
  NodeDaoImpl nodeDao = NodeDaoImpl.getInstance();
  List<Edge> edges;

  private EdgeDaoImpl() {}

  public static synchronized EdgeDaoImpl getInstance() {
    if (single_instance == null) single_instance = new EdgeDaoImpl();

    return single_instance;
  }

  @Override
  public List<Edge> getAllEdges() {
    return edges;
  }

  @Override
  public Edge getEdge(Node startNode, Node endNode) {
    return null;
  }

  @Override
  public void deleteEdge(Node startNode, Node endNode) {}

  public void csvToEdges(String csvFilePath) {

    try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
      String headerLine = reader.readLine();
      String line;
      while ((line = reader.readLine()) != null) {
        String[] fields = line.split(",");
        //
        Edge thisEdge =
            new Edge(
                nodeDao.nodes.get(Integer.parseInt(fields[1])),
                nodeDao.nodes.get(Integer.parseInt(fields[2])));
        edges.add(thisEdge);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
