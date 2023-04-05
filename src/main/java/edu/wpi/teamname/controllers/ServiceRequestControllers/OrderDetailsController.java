package edu.wpi.teamname.controllers.ServiceRequestControllers;

import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;

public class OrderDetailsController {

  @FXML MFXButton back2;
  @FXML MFXButton submit;

  @FXML
  public void initialize() {

    back2.setOnMouseClicked(event -> Navigation.navigate(Screen.MEAL_DELIVERY1));
    submit.setOnMouseClicked(event -> Navigation.navigate(Screen.ORDER_CONFIRMATION));
  }
}
