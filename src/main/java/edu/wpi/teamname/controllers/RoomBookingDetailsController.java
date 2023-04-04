package edu.wpi.teamname.controllers;

import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class RoomBookingDetailsController {

  @FXML MFXButton submitDetailsButton;
  @FXML MFXTextField roomLocationText;
  @FXML MFXTextField roomTimesText;
  @FXML MFXTextField eventTitleText;
  @FXML MFXTextField eventDescriptionText;
  @FXML MFXButton backButton;

  String roomLocation;
  String roomTimes;
  String eventTitle;
  String eventDescription;

  @FXML
  public void initialize() {
    submitDetailsButton.setOnMouseClicked(event -> Navigation.navigate(Screen.ROOM_BOOKING));
  }

  @FXML
  public void submitDetails(ActionEvent event) {
    roomLocation = roomLocationText.getText();
    roomTimes = roomTimesText.getText();
    eventTitle = eventTitleText.getText();
    eventDescription = eventDescriptionText.getText();
  }
}
