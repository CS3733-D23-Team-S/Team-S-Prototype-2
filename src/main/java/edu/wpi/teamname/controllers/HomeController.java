package edu.wpi.teamname.controllers;

import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;

public class HomeController {

  @FXML MFXButton navigateButton;
  @FXML MFXButton mealdeliveryButton;
  @FXML MFXButton roomBookingButton;

  @FXML
  public void initialize() {
    navigateButton.setOnMouseClicked(event -> Navigation.navigate(Screen.SERVICE_REQUEST));
    mealdeliveryButton.setOnMouseClicked(event -> Navigation.navigate(Screen.MEAL_DELIVERY1));

    roomBookingButton.setOnMouseClicked(event -> Navigation.navigate(Screen.ROOM_BOOKING));
  }
}
