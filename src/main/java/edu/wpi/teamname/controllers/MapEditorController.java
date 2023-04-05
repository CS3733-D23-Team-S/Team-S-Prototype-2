package edu.wpi.teamname.controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MapEditorController {

  @FXML MFXButton mapEditorToAdminButton;
  @FXML TableView mapEditorTable;
  @FXML TableColumn nodeCol;
  @FXML TableColumn locationNameCol;
  @FXML TableColumn moveCol;
  @FXML TableColumn edgeCol;

  public void initialize() {
    // mapEditorToAdminButton.setOnMouseClicked(event -> Navigation.navigate(Screen.ADMIN));
  }
}
