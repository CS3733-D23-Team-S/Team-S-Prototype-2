package edu.wpi.teamname.controllers;

import edu.wpi.teamname.PathfindingEntity;
import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.sql.SQLException;
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

  @FXML TableView stepsTable;

  @FXML TableColumn nodesTraversedCol;

  public void makePathfindingEntity(String startingLocation, String destination)
      throws SQLException {
    PathfindingEntity pfEntity = new PathfindingEntity(startingLocation, destination);
    pfEntity.generatePath();
    for (int i = 0; i < pfEntity.getNodesTraversed().size(); i++) {
      stepsTable.getItems().add(pfEntity.getNodesTraversed().get(i));
    }
  }

  public void clearFields() {
    startingLocation.setText("");
    destination.setText("");
  }

  public void initialize() {
    pathfindingToHomeButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));

    clearFieldsButton.setOnMouseClicked(event -> clearFields());

    findPathButton.setOnMouseClicked(
        event -> {
          try {
            makePathfindingEntity(startingLocation.getText(), destination.getText());
          } catch (SQLException e) {
            throw new RuntimeException(e);
          }
        });

    // pathfindingToProfileButton.setOnMouseClicked(event -> Navigation.navigate(Screen.ADMIN));

    /*
    findPathButton.setOnMouseClicked(
        event -> makePathfindingEntity(startingLocation.getText(), destination.getText()));
     */
  }
}
