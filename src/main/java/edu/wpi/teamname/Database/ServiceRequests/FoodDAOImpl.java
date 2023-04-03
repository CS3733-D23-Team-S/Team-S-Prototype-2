package edu.wpi.teamname.Database.ServiceRequests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FoodDAOImpl implements FoodDAO_I {
  private static FoodDAOImpl single_instance;
  HashMap<Integer, Food> foods = new HashMap<>();

  private FoodDAOImpl() {}

  public static synchronized FoodDAOImpl getInstance() {
    if (single_instance == null) single_instance = new FoodDAOImpl();

    return single_instance;
  }

  // public

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
