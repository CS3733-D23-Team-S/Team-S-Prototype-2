package edu.wpi.teamname.controllers;

import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class RoomBookingDetailsController {

  @FXML MFXButton submitButton;
  @FXML MFXTextField roomLocationText;
  @FXML MFXTextField roomTimesText;
  @FXML MFXTextField eventNameText;
  @FXML MFXTextField eventDescriptionText;
  @FXML MFXButton backButton;

  String roomLocation;
  String roomTimes;
  String eventName;
  String eventDescription;

  @FXML
  public void initialize() {
    submitButton.setOnMouseClicked(event -> Navigation.navigate(Screen.ROOM_BOOKING));

  }

  @FXML
  public void submitDetails(ActionEvent event) {
    roomLocation = roomLocationText.getText();
    roomTimes = roomTimesText.getText();
    eventName = eventNameText.getText();
    eventDescription = eventDescriptionText.getText();
  }
}
