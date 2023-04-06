package edu.wpi.teamname.controllers;

import edu.wpi.teamname.Database.Map.Node;
import edu.wpi.teamname.Database.Map.NodeType;
import edu.wpi.teamname.MapEditorEntity;
import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MapEditorController {

  @FXML MFXButton mapEditorToHomeButton;
  @FXML TableView<Object> nodeTable;
  @FXML TableView<Object> locationTable;
  @FXML TableView<Object> edgeTable;
  @FXML TableView<Object> moveTable;
  @FXML TableColumn<Object, Integer> ntNodeIDCol = new TableColumn<>("Node ID");
  @FXML TableColumn<Object, Integer> xCoordCol = new TableColumn<>("XCoord");
  @FXML TableColumn<Object, String> yCoordCol = new TableColumn<>("YCoord");
  @FXML TableColumn<Object, String> floorCol = new TableColumn<>("Floor");
  @FXML TableColumn<Object, String> buildingCol = new TableColumn<>("Building");
  @FXML TableColumn<Object, NodeType> nodeTypeCol = new TableColumn<>("Node Type");
  @FXML TableColumn<Object, String> longNameCol = new TableColumn<>("Long Name");
  @FXML TableColumn<Object, String> shortNameCol = new TableColumn<>("Short Name");
  @FXML TableColumn<Object, Date> recentMoveCol = new TableColumn<>("Most Recent Move");
  @FXML TableColumn<Object, Node> startNodeCol = new TableColumn<>("Start Node");
  @FXML TableColumn<Object, Node> endNodeCol = new TableColumn<>("End Node");
  @FXML TableColumn<Object, Integer> mtNodeIDCol = new TableColumn<>("Node ID");
  @FXML TableColumn<Object, String> locationCol = new TableColumn<>("Location");
  @FXML TableColumn<Object, ArrayList<LocalDate>> datesCol = new TableColumn<>("Dates");

  public void createLists() {
    MapEditorEntity mee = new MapEditorEntity();
    final ObservableList nodeList = FXCollections.observableList(mee.getNodeList());
    final ObservableList edgeList = FXCollections.observableList(mee.getEdgeList());
    final ObservableList locationList = FXCollections.observableList(mee.getLocationList());
    final ObservableList moveList = FXCollections.observableList(mee.getMoveList());

    for (int i = 0; i < nodeList.size(); i++) {
      nodeTable.getItems().add(nodeList.get(i));
    }
    for (int i = 0; i < edgeList.size(); i++) {
      edgeTable.getItems().add(edgeList.get(i));
    }
    for (int i = 0; i < locationList.size(); i++) {
      locationTable.getItems().add(locationList.get(i));
    }
    for (int i = 0; i < moveList.size(); i++) {
      moveTable.getItems().add(moveList.get(i));
    }
  }

  public void initialize() {
    mapEditorToHomeButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));

    ntNodeIDCol.setCellValueFactory(new PropertyValueFactory<>("nodeID"));
    xCoordCol.setCellValueFactory(new PropertyValueFactory<>("xCoord"));
    yCoordCol.setCellValueFactory(new PropertyValueFactory<>("yCoord"));
    floorCol.setCellValueFactory(new PropertyValueFactory<>("floor"));
    buildingCol.setCellValueFactory(new PropertyValueFactory<>("building"));
    nodeTable.getColumns().add(0, ntNodeIDCol);
    nodeTable.getColumns().add(1, xCoordCol);
    nodeTable.getColumns().add(2, yCoordCol);
    nodeTable.getColumns().add(3, floorCol);
    nodeTable.getColumns().add(4, buildingCol);

    nodeTypeCol.setCellValueFactory(new PropertyValueFactory<>("nodeType"));
    shortNameCol.setCellValueFactory(new PropertyValueFactory<>("shortName"));
    longNameCol.setCellValueFactory(new PropertyValueFactory<>("longName"));
    recentMoveCol.setCellValueFactory(new PropertyValueFactory<>("mostRecentMove"));
    locationTable.getColumns().add(0, nodeTypeCol);
    locationTable.getColumns().add(1, shortNameCol);
    locationTable.getColumns().add(2, longNameCol);
    locationTable.getColumns().add(3, recentMoveCol);

    startNodeCol.setCellValueFactory(new PropertyValueFactory<>("startNode"));
    endNodeCol.setCellValueFactory(new PropertyValueFactory<>("endNode"));
    edgeTable.getColumns().add(0, startNodeCol);
    edgeTable.getColumns().add(1, endNodeCol);

    mtNodeIDCol.setCellValueFactory(new PropertyValueFactory<>("nodeID"));
    locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
    datesCol.setCellValueFactory(new PropertyValueFactory<>("dates"));
    moveTable.getColumns().add(0, mtNodeIDCol);
    moveTable.getColumns().add(1, locationCol);
    moveTable.getColumns().add(2, datesCol);

    createLists();
  }
}
