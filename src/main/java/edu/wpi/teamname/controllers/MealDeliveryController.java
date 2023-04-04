package edu.wpi.teamname.controllers;

import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

public class MealDeliveryController {

  @FXML MFXButton backButton1;
  @FXML HBox wf;

  ArrayList<Integer> foodPrice = new ArrayList<Integer>();

  @FXML
  public void initialize() {
    backButton1.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));

    foodPrice.add(3);
    foodPrice.add(24);
    foodPrice.add(32);
    foodPrice.add(20);

    walletFriendly();
  }

  public void walletFriendly() {
    for (int i = 0; i < foodPrice.size(); i++) {
      if (foodPrice.get(i) < 30) {
        MFXButton btn = new MFXButton();
        btn.setId(foodPrice.get(i).toString());
        String button = foodPrice.get(i).toString();
        btn.setText(foodPrice.get(i).toString());
        btn.setMaxWidth(103);
        btn.setMaxHeight(87);
        wf.getChildren().add(btn);
        btn.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));
      }
    }
  }
}
