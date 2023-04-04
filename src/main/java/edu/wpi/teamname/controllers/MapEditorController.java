package edu.wpi.teamname.controllers;

import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
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
