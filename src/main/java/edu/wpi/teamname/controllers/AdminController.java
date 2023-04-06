package edu.wpi.teamname.controllers;

import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class AdminController {
  @FXML ImageView homeIcon;
  @FXML ImageView profileIcon;
  @FXML ImageView helpIcon;
  @FXML Button submittedMealButton;
  @FXML Button submittedRoomButton;
  @FXML Button mapEditorButton;
  @FXML Label mealIDRequestSubmission;
  @FXML Label orderTimeRequestSubmission;
  @FXML Label itemsOrderedRequestSubmission;
  @FXML Label mealSpecialRequestSubmission;
  @FXML Label orderStatusRequestSubmission;
  @FXML Label roomsBookedRequestSubmission;
  @FXML Label timeBookedRequestSubmission;
  @FXML Label maxRoomSizeRequestSubmission;
  @FXML Label roomSpecialRequestSubmission;

  public void initialize() {
    homeIcon.setOnMouseClicked(event -> goToHomePage());
    helpIcon.setOnMouseClicked(event -> goToHelpPage());
    submittedMealButton.setOnMouseClicked(event -> goToSubmittedMealRequestsPage());
    submittedRoomButton.setOnMouseClicked(event -> goToSubmittedRoomRequestsPage());
    mapEditorButton.setOnMouseClicked(event -> goToMapEditorPage());
  }

  public void goToHomePage() {
    Navigation.navigate(Screen.HOME);
  }

  public void goToHelpPage() {
    Navigation.navigate(Screen.HELP_PAGE);
  }

  public void goToSubmittedMealRequestsPage() {
    System.out.println("i am running");
    Navigation.navigate(Screen.SUBMITTED_MEAL_REQUESTS);
  }

  public void goToSubmittedRoomRequestsPage() {
    Navigation.navigate(Screen.SUBMITTED_ROOM_REQUESTS);
  }

  public void goToMapEditorPage() {
    Navigation.navigate(Screen.MAP_EDITOR);
  }
}
