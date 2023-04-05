package edu.wpi.teamname.controllers.ServiceRequestControllers;

import static edu.wpi.teamname.controllers.ServiceRequestControllers.MealDeliveryController.clickedFoodID;

import edu.wpi.teamname.Database.ServiceRequests.FoodService.Food;
import edu.wpi.teamname.Database.ServiceRequests.FoodService.FoodDAOImpl;
import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

public class ProductDetailsController {
  @FXML MFXButton back3;
  @FXML MFXButton addCart;

  @FXML MFXButton clear;
  @FXML MFXTextField quantity;
  @FXML MFXTextField request;
  @FXML FoodDAOImpl foodDAO = FoodDAOImpl.getInstance();
  @FXML HBox foodName;
  @FXML HBox fDescription;
  @FXML HBox fPrice;

  public void initialize() {

    back3.setOnMouseClicked(event -> Navigation.navigate(Screen.MEAL_DELIVERY1));
    addCart.setOnMouseClicked(event -> Navigation.navigate(Screen.MEAL_DELIVERY1));
    clearFields();
    clear.setOnMouseClicked(event -> clearFields());
    clearFields();
    selectedFood();
    foodNamer();
    foodDescription();
    foodPrice();
    System.out.println(selectedFood().getFoodDescription());
  }

  public void clearFields() {
    quantity.clear();
    request.clear();
  }

  public Food selectedFood() {
    return foodDAO.retrieveFood(clickedFoodID);
  }

  public void foodNamer() {

    MFXButton namer = new MFXButton();
    namer.setId(selectedFood().getFoodDescription());
    namer.setText(selectedFood().getFoodName().toString());
    namer.setMaxWidth(103);
    namer.setMaxHeight(87);
    foodName.getChildren().add(namer);
  }

  public void foodDescription() {

    MFXButton description = new MFXButton();
    description.setId(selectedFood().getFoodDescription());
    description.setText(selectedFood().getFoodDescription().toString());
    description.setMaxWidth(500);
    description.setMaxHeight(87);
    fDescription.getChildren().add(description);
  }

  public void foodPrice() {

    MFXButton fprice = new MFXButton();
    fprice.setId(Double.toString(selectedFood().getFoodPrice()));
    fprice.setText(Double.toString(selectedFood().getFoodPrice()));
    fprice.setMaxWidth(500);
    fprice.setMaxHeight(87);
    fPrice.getChildren().add(fprice);
  }
}
