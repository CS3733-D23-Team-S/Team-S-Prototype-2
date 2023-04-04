package edu.wpi.teamname;

import edu.wpi.teamname.Database.LoaderDAO;
import java.sql.SQLException;

public class Main {

  public static void main(String[] args) throws SQLException {
    LoaderDAO loader = new LoaderDAO();
    loader.establishConnection();
    loader.resetData();
    loader.load();
    System.out.println("Loaded everything");
  }
}
