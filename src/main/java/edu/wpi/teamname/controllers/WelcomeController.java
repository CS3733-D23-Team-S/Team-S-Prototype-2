package edu.wpi.teamname.controllers;

import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;

public class WelcomeController {

  @FXML MFXButton loginButton;

  @FXML
  public void initialize() {
    loginButton.setOnMouseClicked(event -> Navigation.navigate(Screen.LOGIN_PAGE));
  }
}
