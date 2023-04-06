package edu.wpi.teamname.controllers;

import edu.wpi.teamname.Database.ServiceRequests.ConferenceRoom.RoomRequestDAO;
import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.sql.SQLException;
import javafx.fxml.FXML;

public class HomeController {

  @FXML MFXButton navigateButton;
  @FXML MFXButton mealdelivery1Button;
  @FXML MFXButton roomBookingButton;
  RoomRequestDAO roomRequestDAO = RoomRequestDAO.getInstance();

  @FXML
  public void initialize() throws SQLException {
    roomRequestDAO.initTable();
    navigateButton.setOnMouseClicked(event -> Navigation.navigate(Screen.SERVICE_REQUEST));
    mealdelivery1Button.setOnMouseClicked(event -> Navigation.navigate(Screen.MEAL_DELIVERY1));
    roomBookingButton.setOnMouseClicked(event -> Navigation.navigate(Screen.ROOM_BOOKING));
  }
}
