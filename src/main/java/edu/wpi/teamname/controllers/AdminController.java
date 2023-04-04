package edu.wpi.teamname.controllers;


import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class AdminController {
    @FXML ImageView homeIcon;
    @FXML ImageView profileIcon;
    @FXML ImageView helpIcon;
    @FXML Button submittedMealButton;
    @FXML Button submittedRoomButton;
    @FXML Label mealIDRequestSubmission;
    @FXML Label orderTimeRequestSubmission;
    @FXML Label itemsOrderedRequestSubmission;
    @FXML Label mealSpecialRequestSubmission;
    @FXML Label orderStatusRequestSubmission;
    @FXML Label roomsBookedRequestSubmission;
    @FXML Label timeBookedRequestSubmission;
    @FXML Label maxRoomSizeRequestSubmission;
    @FXML Label roomSpecialRequestSubmission;

    public void Initialize() {
        homeIcon.setOnMouseClicked(event -> goToHomePage());
        helpIcon.setOnMouseClicked(event -> goToHelpPage());
        submittedMealButton.setOnMouseClicked(event -> goToSubmittedRequestsPage());
        submittedRoomButton.setOnMouseClicked(event -> goToSubmittedRequestsPage());


    }

    public void goToHomePage() {
        Navigation.navigate(Screen.HOME);
    }

    public void goToHelpPage() {
        Navigation.navigate(Screen.HELP_PAGE);
    }

    public void goToSubmittedRequestsPage() {
        Navigation.navigate(Screen.SUBMITTED_REQUESTS);
    }




}
