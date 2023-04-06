package edu.wpi.teamname.controllers;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;

class MealRequest {
  @Getter public String mealId;
  @Getter public String orderTime;

  MealRequest(String mealID, String orderTime) {
    this.orderTime = orderTime;
    this.mealId = mealID;
  }
}

public class SubmittedMealRequestController implements Initializable {
  @FXML TableView<MealRequest> mealRequestsTable;
  @FXML TableColumn<MealRequest, String> mealID = new TableColumn<>("Meal ID");
  @FXML TableColumn<MealRequest, String> orderTime = new TableColumn<>("Order Time");
  // @FXML TableColumn<MealRequest, Integer> itemsOrdered = new TableColumn<>("Items Ordered");
  // @FXML TableColumn<MealRequest, Integer> specialRequests = new TableColumn<>("Special
  // Requests");
  // @FXML TableColumn<MealRequest, Integer> orderStatus = new TableColumn<>("Order Status");

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    //    mealID.setPrefWidth(320.0);
    List<MealRequest> mealRequests = new LinkedList<>();
    mealRequests.add(new MealRequest("1", "noon"));
    mealRequests.add(new MealRequest("1", "noon"));
    mealRequests.add(new MealRequest("1", "noon"));
    mealRequests.add(new MealRequest("1", "noon"));
    mealRequests.add(new MealRequest("1", "noon"));

    mealID.setCellValueFactory(new PropertyValueFactory<>("mealId"));
    orderTime.setCellValueFactory(new PropertyValueFactory<>("orderTime"));

    final ObservableList<MealRequest> observableMealList =
        FXCollections.observableList(mealRequests);
    mealRequestsTable.setItems(observableMealList);

    System.out.println("i am running (controller)");
  }
}
