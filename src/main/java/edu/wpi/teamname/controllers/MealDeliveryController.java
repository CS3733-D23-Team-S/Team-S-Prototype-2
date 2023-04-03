package edu.wpi.teamname.controllers;

import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;

public class MealDeliveryController {

  @FXML MFXButton backButton1;

  @FXML
  public void initialize() {
    backButton1.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));
  }
}
