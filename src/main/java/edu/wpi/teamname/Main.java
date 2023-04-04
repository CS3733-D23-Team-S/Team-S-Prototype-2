package edu.wpi.teamname;

import edu.wpi.teamname.Database.LoaderDAO;
import edu.wpi.teamname.Database.Map.EdgeDaoImpl;
import edu.wpi.teamname.Database.Map.MoveDaoImpl;
import edu.wpi.teamname.Database.Map.NodeDaoImpl;
import java.sql.SQLException;

public class Main {

  public static void main(String[] args) throws SQLException {
    LoaderDAO loader = new LoaderDAO();
    //    loader.establishConnection();
    //    loader.resetData();
    loader.load();
    //Debugging stuff in order to check everything looks about right
    System.out.println("Loaded everything");
    for (int key : NodeDaoImpl.getInstance().getNodes().keySet())
      System.out.println(NodeDaoImpl.getInstance().getNodes().get(key).toString());
    for (int key : MoveDaoImpl.getInstance().getMovesORM().keySet())
      System.out.println(MoveDaoImpl.getInstance().getMovesORM().get(key).toString());
    for (int key : EdgeDaoImpl.getInstance().getNeighbors().keySet()) {
      System.out.print(key);
      System.out.print("\t Neighbors:\t");
      System.out.println(EdgeDaoImpl.getInstance().getNeighbors().get(key).toString());
    }
  }
}
