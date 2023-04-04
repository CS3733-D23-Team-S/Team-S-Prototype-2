package edu.wpi.teamname.Database.ServiceRequests.FoodService;

import edu.wpi.teamname.Database.dbConnection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class FoodDAOImpl implements FoodDAO_I {
  private static FoodDAOImpl single_instance;
  HashMap<Integer, Food> foods = new HashMap<>();
  dbConnection connection = dbConnection.getInstance();
  protected static final String foodsTable = "hospitaldb" + "." + "foods";

  private FoodDAOImpl() {}

  public static synchronized FoodDAOImpl getInstance() {
    if (single_instance == null) single_instance = new FoodDAOImpl();

    return single_instance;
  }

  public void addFood(Food thisFood) {
    try {
      PreparedStatement preparedStatement =
          connection
              .getC()
              .prepareStatement(
                  "INSERT INTO "
                      + foodsTable
                      + " (FoodID , Name ,Type , PrepTime, Cuisine, Price, Description, Quantity, SoldOut, Image) "
                      + " VALUES (?, ?, ? ,?, ?, ?, ?, ?, ?, ?)");
      preparedStatement.setInt(1, thisFood.getFoodID());
      preparedStatement.setString(2, thisFood.getFoodName());
      preparedStatement.setString(3, thisFood.getFoodType());
      preparedStatement.setInt(4, thisFood.getFoodPrepTime());
      preparedStatement.setString(5, thisFood.getFoodCuisine());
      preparedStatement.setDouble(6, thisFood.getFoodPrice());
      preparedStatement.setString(7, thisFood.getFoodDescription());
      preparedStatement.setInt(8, thisFood.getQuantity());
      preparedStatement.setBoolean(9, thisFood.isSoldOut());
      preparedStatement.setString(10, thisFood.getImage());

      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println(e.getSQLState());
    }
  }

  public void csvToFood(String csvFilePath) {

    try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
      String headerLine = reader.readLine();
      String line;
      while ((line = reader.readLine()) != null) {
        String[] fields = line.split(",");
        // int fid, String fn, String ft, int fpt, String fc, double fp, String fd, int q
        Food thisFood =
            new Food(
                Integer.parseInt(fields[0]),
                (fields[1]),
                (fields[2]),
                Integer.parseInt(fields[3]),
                fields[4],
                Double.parseDouble(fields[5]),
                fields[6],
                Integer.parseInt(fields[7]));
        foods.put(Integer.valueOf(fields[0]), thisFood);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
