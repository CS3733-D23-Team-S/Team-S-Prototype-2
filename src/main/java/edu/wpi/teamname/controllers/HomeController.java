package edu.wpi.teamname.controllers;

import static edu.wpi.teamname.navigation.Screen.PATHFINDING;

import edu.wpi.teamname.Main;
import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class HomeController {

  @FXML MFXButton mealDeliveryButton;
  @FXML MFXButton reserveRoomButton;

  @FXML MFXButton logoutButton;

  @FXML ButtonBar buttonBar;

  @FXML MenuButton app;
  @FXML Button buttonBarPathfinding;
  @FXML Button buttonBarReserveRoom;
  @FXML Button buttonBarMealDelivery;

  @FXML MenuItem exitOption;

  @FXML ImageView helpIcon;

  @FXML ImageView hospitalBg;

  @FXML MFXButton homeToPathfindingButton;

  @FXML
  public void initialize() {
    // Adding the menu option to exit application

    mealDeliveryButton.setOnMouseClicked(event -> goToMealPage());
    reserveRoomButton.setOnMouseClicked(event -> goToRoomPage());
    logoutButton.setOnMouseClicked(event -> goToLoginPage());
    helpIcon.setOnMouseClicked(event -> goToHelpPage());
    exitOption.setOnAction(event -> exitApplication());
    homeToPathfindingButton.setOnMouseClicked(event -> Navigation.navigate(PATHFINDING));

    // Menu bar button handlers
    buttonBarPathfinding.setOnMouseClicked(event -> Navigation.navigate(PATHFINDING));
    buttonBarMealDelivery.setOnMouseClicked(event -> goToMealPage());
    buttonBarReserveRoom.setOnMouseClicked(event -> goToRoomPage());


    Image hospitalBackground = new Image(Main.class.getResource("./HomepageImages/BrighamandWomensHospitalImage.jpeg").toString());
    hospitalBg.setImage(hospitalBackground);


  }

  public void goToRoomPage() {
    Navigation.navigate(Screen.ROOM_BOOKING);
  }

  public void goToMealPage() {
    Navigation.navigate(Screen.SERVICE_REQUEST);
  }

  public void goToLoginPage() {
    Navigation.navigate(Screen.LOGIN_PAGE);
  }

  public void exitApplication() {
    Platform.exit();
  }

  public void goToHelpPage() {
    Navigation.navigate(Screen.HELP_PAGE);
  }

}
