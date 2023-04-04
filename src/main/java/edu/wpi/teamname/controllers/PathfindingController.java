package edu.wpi.teamname.controllers;

import edu.wpi.teamname.PathfindingEntity;
import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class PathfindingController {
  @FXML MFXButton pathfindingToHomeButton;

  @FXML MFXButton findPathButton;

  @FXML MFXTextField startingLocation;

  @FXML MFXTextField destination;

  @FXML MFXButton pathfindingToProfileButton;
  @FXML MFXButton clearFieldsButton;
  @FXML MFXButton emailTextualDirections;

  @FXML
  TableView<String> stepsTable;

  /*
  public void makePathfindingEntity(String startingLocation, String destination) {
    PathfindingEntity pfEntity = new PathfindingEntity(startingLocation, destination);
    if (pfEntity.realLocations) {
      pfEntity.generatePath();
      displayNodes(pfEntity);
    } else {
      stepsTable.getItems().add(new String
              ("Your starting location and/or destination are not real locations. Please try again."));
    }

  }

   */

  public void clearFields() {
    startingLocation.setText("");
    destination.setText("");
  }


  public void displayNodes(PathfindingEntity pathfindingEntity) {
    for (int i = 0; i < pathfindingEntity.getNodesTraversed().size(); i++) {
      stepsTable.getItems().add(new String(pathfindingEntity.getNodesTraversed().get(i).getNodeID()));
    }
  }



  public void initialize() {
    pathfindingToHomeButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));

    clearFieldsButton.setOnMouseClicked(event -> clearFields());

    //pathfindingToProfileButton.setOnMouseClicked(event -> Navigation.navigate(Screen.ADMIN));

    /*
    findPathButton.setOnMouseClicked(
        event -> makePathfindingEntity(startingLocation.getText(), destination.getText()));
     */
  }
}
