package edu.wpi.teamname.controllers;

import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;

public class PathfindingController {
  @FXML MFXButton backButton;
  @FXML MFXButton backHome;

  @FXML
  public void initialize() {
    backButton.setOnMouseClicked(event -> Navigation.navigate(Screen.WELCOME_PAGE));
    backHome.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));

  }
}
