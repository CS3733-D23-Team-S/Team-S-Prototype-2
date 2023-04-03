package edu.wpi.teamname.controllers;

import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;

public class RoomBookingController {

  @FXML MFXButton addMeetingButton;
  @FXML MFXButton backButton;

  @FXML
  public void initialize() {
    addMeetingButton.setOnMouseClicked(event -> Navigation.navigate(Screen.ROOM_BOOKING_DETAILS));
    backButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));
  }
}
