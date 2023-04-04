package edu.wpi.teamname.Database.ServiceRequests.FoodService;

import edu.wpi.teamname.Database.dbConnection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import lombok.Getter;

public class FoodDAOImpl implements FoodDAO_I {
  private static FoodDAOImpl single_instance;
  @Getter private HashMap<Integer, Food> foods = new HashMap<>();
  private dbConnection connection = dbConnection.getInstance();
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
                      + " (FoodID, Name, Type, PrepTime, Cuisine, Price, Description, SoldOut, Image, "
                      + "Calories, Italian, American, Indian, Mexican, Vegetarian, Halal, Vegan, GlutenFree, Kosher) "
                      + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
      preparedStatement.setInt(1, thisFood.getFoodID());
      preparedStatement.setString(2, thisFood.getFoodName());
      preparedStatement.setString(3, thisFood.getFoodType());
      preparedStatement.setInt(4, thisFood.getFoodPrepTime());
      preparedStatement.setString(5, thisFood.getFoodCuisine());
      preparedStatement.setDouble(6, thisFood.getFoodPrice());
      preparedStatement.setString(7, thisFood.getFoodDescription());
      preparedStatement.setBoolean(8, thisFood.isSoldOut());
      preparedStatement.setString(9, thisFood.getImage());
      preparedStatement.setInt(10, thisFood.getCalories());
      preparedStatement.setBoolean(11, thisFood.isItalian());
      preparedStatement.setBoolean(12, thisFood.isAmerican());
      preparedStatement.setBoolean(13, thisFood.isIndian());
      preparedStatement.setBoolean(14, thisFood.isMexican());
      preparedStatement.setBoolean(15, thisFood.isVegetarian());
      preparedStatement.setBoolean(16, thisFood.isHalal());
      preparedStatement.setBoolean(17, thisFood.isVegan());
      preparedStatement.setBoolean(18, thisFood.isGlutFree());
      preparedStatement.setBoolean(19, thisFood.isKosher());

      preparedStatement.executeUpdate();

      foods.put(thisFood.getFoodID(), thisFood);

      System.out.println("Food added");

    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println(e.getSQLState());
    }
  }

  public void deleteFood(int target) throws SQLException {
    PreparedStatement deleteFood =
        connection.getC().prepareStatement("DELETE FROM " + foodsTable + " WHERE FoodID = ?");
    try {
      deleteFood.setInt(1, target);
      deleteFood.execute();

      // remove from local Hashmap
      foods.remove(target);

      System.out.println("Food deleted");

    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println(e.getSQLState());
    }
  }

  public void updateFood(int updateNeededFood) {

    Food thisFood = foods.get(updateNeededFood);

    try {
      PreparedStatement preparedStatement =
          connection
              .getC()
              .prepareStatement(
                  "Update "
                      + foodsTable
                      + " SET Name = ? ,Type = ?, PrepTime = ? , Cuisine = ?, Price = ?, Description = ?, SoldOut = ?, "
                      + "Image = ?, Calories = ?, Italian = ?, American = ?, Indian = ?, Mexican = ?, Vegetarian = ?, "
                      + "Halal = ?, Vegan = ?, GlutenFree = ?, Kosher = ?"
                      + " WHERE FoodID = ?");

      preparedStatement.setString(1, thisFood.getFoodName());
      preparedStatement.setString(2, thisFood.getFoodType());
      preparedStatement.setInt(3, thisFood.getFoodPrepTime());
      preparedStatement.setString(4, thisFood.getFoodCuisine());
      preparedStatement.setDouble(5, thisFood.getFoodPrice());
      preparedStatement.setString(6, thisFood.getFoodDescription());
      preparedStatement.setBoolean(7, thisFood.isSoldOut());
      preparedStatement.setString(8, thisFood.getImage());
      preparedStatement.setInt(9, thisFood.getCalories());
      preparedStatement.setBoolean(10, thisFood.isItalian());
      preparedStatement.setBoolean(11, thisFood.isAmerican());
      preparedStatement.setBoolean(12, thisFood.isIndian());
      preparedStatement.setBoolean(13, thisFood.isMexican());
      preparedStatement.setBoolean(14, thisFood.isVegetarian());
      preparedStatement.setBoolean(15, thisFood.isHalal());
      preparedStatement.setBoolean(16, thisFood.isVegan());
      preparedStatement.setBoolean(17, thisFood.isGlutFree());
      preparedStatement.setBoolean(18, thisFood.isKosher());
      preparedStatement.setInt(19, thisFood.getFoodID());
      preparedStatement.executeUpdate();

      System.out.println("Food updated");

    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println(e.getSQLState());
    }
  }

  public Food retrieveFood(int target) {
    if (foods.get(target) == null) {
      System.out.println("This node is not in the database, so its row cannot be printed");
      return null;
    }
    return foods.get(target);
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
                Boolean.parseBoolean(fields[7]),
                fields[8],
                Integer.parseInt(fields[9]),
                Boolean.parseBoolean(fields[10]),
                Boolean.parseBoolean(fields[11]),
                Boolean.parseBoolean(fields[12]),
                Boolean.parseBoolean(fields[13]),
                Boolean.parseBoolean(fields[14]),
                Boolean.parseBoolean(fields[15]),
                Boolean.parseBoolean(fields[16]),
                Boolean.parseBoolean(fields[17]),
                Boolean.parseBoolean(fields[18]));
        foods.put(Integer.valueOf(fields[0]), thisFood);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
