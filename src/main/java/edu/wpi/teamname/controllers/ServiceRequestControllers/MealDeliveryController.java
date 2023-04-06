package edu.wpi.teamname.controllers.ServiceRequestControllers;

import edu.wpi.teamname.Database.DAOManager;
import edu.wpi.teamname.Database.ServiceRequests.FoodService.Food;
import edu.wpi.teamname.Database.ServiceRequests.FoodService.FoodDAOImpl;
import edu.wpi.teamname.Database.ServiceRequests.FoodService.FoodDeliveryDAOImp;
import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

public class MealDeliveryController {

  @FXML MFXButton backButton1;
  @FXML MFXButton checkout;
  @FXML HBox wf;
  @FXML HBox qd;
  // @FXML HBox fname;

  @FXML private FoodDAOImpl foodDAO = FoodDAOImpl.getInstance();
  @FXML private FoodDeliveryDAOImp foodel = FoodDeliveryDAOImp.getInstance();
  public static int clickedFoodID;

  @FXML
  public void initialize() {

    DAOManager dbManager = new DAOManager();
    // Establish connection to database
    dbManager.establishConnection();
    // Create Empty Table

    foodDAO.initFood();
    foodel.initFoodRequests();

    // adding Foods
    Food Pizza =
        new Food(
            1,
            "Pizza",
            "Hello",
            10,
            "String fc",
            10,
            "String fd",
            1,
            false,
            "image",
            20,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false);

    Food Burger =
        new Food(
            2,
            "Burger",
            "Hello",
            10,
            "String fc",
            12,
            "String fd",
            1,
            false,
            "image",
            14,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false);

    Food StirFry =
        new Food(
            3,
            "StirFry",
            "Hello",
            10,
            "String fc",
            10,
            "String fd",
            1,
            false,
            "image",
            5,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false);

    Food Chicken =
        new Food(
            4,
            "Chicken",
            "Hello",
            10,
            "String fc",
            21,
            "String fd",
            1,
            false,
            "image",
            12,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false);

    Food Tacos =
        new Food(
            5,
            "Tacos",
            "Hello",
            10,
            "String fc",
            11,
            "String fd",
            1,
            false,
            "image",
            20,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false);

    Food Pasta =
        new Food(
            6,
            "Pasta",
            "Hello",
            10,
            "String fc",
            14,
            "String fd",
            1,
            false,
            "image",
            15,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false);

    Food Bagel =
        new Food(
            7,
            "Bagel",
            "Hello",
            10,
            "String fc",
            13,
            "String fd",
            1,
            false,
            "image",
            10,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false);

    Food Tea =
        new Food(
            8,
            "Tea",
            "Hello",
            10,
            "String fc",
            65,
            "String fd",
            1,
            false,
            "image",
            11,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false);

    Food OrangeChicken =
        new Food(
            9,
            "OrangeChicken",
            "Hello",
            10,
            "String fc",
            15,
            "String fd",
            1,
            false,
            "image",
            10,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false);

    Food FriedRice =
        new Food(
            10,
            "FriedRice",
            "Hello",
            10,
            "String fc",
            10,
            "String fd",
            1,
            false,
            "image",
            1,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false);

    Food HotDog =
        new Food(
            11,
            "HotDog",
            "Hello",
            10,
            "String fc",
            12,
            "String fd",
            1,
            false,
            "image",
            10,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false);

    Food RiceAndBeans =
        new Food(
            12,
            "RiceAndBeans",
            "Hello",
            10,
            "String fc",
            2,
            "String fd",
            1,
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

    Food Quesadillas =
        new Food(
            13,
            "Quesadillas",
            "Hello",
            10,
            "String fc",
            2,
            "String fd",
            1,
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

    foodDAO.addFood(Pizza);
    foodDAO.addFood(Burger);
    foodDAO.addFood(StirFry);
    foodDAO.addFood(Chicken);
    foodDAO.addFood(Tacos);
    foodDAO.addFood(Pasta);
    foodDAO.addFood(Bagel);

    foodDAO.addFood(Tea);
    foodDAO.addFood(OrangeChicken);

    foodDAO.addFood(FriedRice);
    foodDAO.addFood(HotDog);
    foodDAO.addFood(RiceAndBeans);
    foodDAO.addFood(Quesadillas);

    backButton1.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));
    checkout.setOnMouseClicked(event -> Navigation.navigate(Screen.ORDER_DETAILS));

    walletFriendly();
    quickDelivery();
  }

  public void walletFriendly() {
    for (int i = 0; i < foodDAO.getWalletFriendlyFood().size(); i++) {

      MFXButton btn1 = new MFXButton();
      btn1.setId(foodDAO.getWalletFriendlyFood().get(i).toString());
      btn1.setText(foodDAO.getWalletFriendlyFood().get(i).toString());
      btn1.setMaxWidth(103);
      btn1.setMaxHeight(87);
      wf.getChildren().add(btn1);
      btn1.setOnMouseClicked(event -> Navigation.navigate(Screen.PRODUCT_DETAILS));
      int finalII = i;
      btn1.setOnMouseClicked(
          event -> store(foodDAO.getWalletFriendlyFood().get(finalII).getFoodID()));
    }
  }

  public void quickDelivery() {
    for (int i = 0; i < foodDAO.getQuick().size(); i++) {
      MFXButton btn = new MFXButton();
      btn.setId(foodDAO.getQuick().get(i).toString());
      System.out.println(foodDAO.getQuick().get(i).toString());
      btn.setText(foodDAO.getQuick().get(i).toString());
      btn.setMaxWidth(103);
      btn.setMaxHeight(87);
      qd.getChildren().add(btn);
      btn.setOnMouseClicked(event -> Navigation.navigate(Screen.PRODUCT_DETAILS));
      int finalI = i;
      btn.setOnMouseClicked(event -> store(foodDAO.getQuick().get(finalI).getFoodID()));
    }
  }

  public void store(int x) {
    clickedFoodID = x;
    Navigation.navigate(Screen.PRODUCT_DETAILS);
  }
}
