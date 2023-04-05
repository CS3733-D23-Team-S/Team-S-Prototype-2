package edu.wpi.teamname.controllers;

import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.application.Platform;
import javafx.fxml.FXML;

public class HomeController {
  @FXML MFXButton logout;
  @FXML MFXButton exitApp;

  public void initialize() {
    logout.setOnMouseClicked(event -> Navigation.navigate(Screen.LOGIN_PAGE));
    exitApp.setOnMouseClicked(event -> Platform.exit());
  }
}
