package edu.wpi.teamname;

import edu.wpi.teamname.Database.DAOManager;
import edu.wpi.teamname.Database.ServiceRequests.FoodService.*;
import edu.wpi.teamname.Database.ServiceRequests.Room;

public class Sdb {
  public static void main(String[] args) throws Exception {
    // String foodPath = "";

    FoodDAOImpl foodDao = FoodDAOImpl.getInstance();
    // foodDao.csvToFood(foodPath);

    DAOManager dbManager = new DAOManager();
    // Establish connection to database
    dbManager.establishConnection();

    /*
        // Create Empty Table
        dbManager.initTables();

        Food newFood =
            new Food(
                5,
                "Pizza",
                "Hello",
                10,
                "String fc",
                2,
                "String fd",
                false,
                "image",
                69,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false);
        Food newFoodt =
            new Food(
                6,
                "za",
                "Hello",
                4,
                "String fc",
                60,
                "String fd",
                false,
                "image",
                420,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false);
        // OrderItem orderItem = new OrderItem(1, newFood, 3);
        // OrderItemDAO cart = new OrderItemDAO(1);
        // cart.addOrderItem(newFood, 3);
        // FoodDelivery newRequest = new FoodDelivery(1, cart, new Date(), new Room(1, 3), "admin");

        foodDao.addFood(newFood);
        foodDao.addFood(newFoodt);
    */
    foodDao.loadToRemote();
    System.out.println(foodDao.retrieveFood(7).toString());

    /*
    System.out.println(foodDao.getFoods().get(newFood.getFoodID()));
    newFood.setFoodDescription("I changed the description to this");

    System.out.println(foodDao.getFoods().get(newFood.getFoodID()));

    foodDao.updateFood(newFood.getFoodID());
    */

    // foodDao.deleteFood(5);
    // dbManager.addOrderItem(orderItem, 1);
    // dbManager.addfoodRequest(newRequest);
    // foodDao.addFood(newFood);
    /*
    OrderItemDAO cart = new OrderItemDAO(1);
    cart.addOrderItem(newFood, 3);
    FoodDelivery newRequest =
        new FoodDelivery(1, cart, null, new Room(1, "Conference Room", 3), "admin");

    FoodDeliveryDAOImp foodRequest = FoodDeliveryDAOImp.getInstance();
    foodRequest.addFoodRequest(newRequest);

     */
  }
}
