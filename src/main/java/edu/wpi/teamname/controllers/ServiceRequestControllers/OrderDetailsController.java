package edu.wpi.teamname.controllers.ServiceRequestControllers;

import edu.wpi.teamname.Database.ServiceRequests.FoodService.Food;
import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class OrderDetailsController {

  @FXML MFXButton back2;
  @FXML MFXButton submit;
  @FXML MFXButton clear2;
  @FXML VBox orderVBox;
  @FXML MFXTextField roomNum;
  @FXML MFXTextField empNum;

  @FXML
  public void initialize() {
    clearFields2();
    multSelectedFood();
    back2.setOnMouseClicked(event -> Navigation.navigate(Screen.MEAL_DELIVERY1));
    submit.setOnMouseClicked(event -> Navigation.navigate(Screen.ORDER_CONFIRMATION));
    clear2.setOnMouseClicked(event -> clearFields2());

    // foodNamer1();
  }

  public Food multSelectedFood() {

    return null;
  }

  public void clearFields2() {
    roomNum.clear();
    empNum.clear();
  }

  /*

  public void addedOrder() {
    for (int i = 0; i < foodDAO.getQuick().size(); i++) {
      Label newItem = new Label();
      HBox newRow = new HBox();

      newItem.setText(foodDAO.getQuick().get(i).toString());

      orderVBox.getChildren().add(newRow);
      newRow
          .getChildren()
          .add(newItem); // add newItem.name, new item.description, newItemQty, newItemRequest
    }
  }

  */

}
