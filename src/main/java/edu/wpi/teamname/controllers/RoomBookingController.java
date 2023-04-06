package edu.wpi.teamname.controllers;


import static javafx.geometry.Pos.CENTER;
import static javafx.geometry.Pos.TOP_CENTER;

import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class RoomBookingController {

  @FXML MFXButton addMeetingButton;
  @FXML MFXButton backButton;

  @FXML HBox conferenceRoomsHBox; // hbox containing all conference rooms and schedules

  /*

    create new vbox
    add the first box with title and height to the vbox
    add that to the hbox

  */

  @FXML
  public void initialize() {
    addMeetingButton.setOnMouseClicked(event -> Navigation.navigate(Screen.ROOM_BOOKING_DETAILS));
    backButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));

    // set up rooms
    Room r1 = new Room("Hale Cafe", "L1", 30, true, "All");
    Room r2 = new Room("Teaching Room", "L2", 50, true, "All");
    Room r3 = new Room("Conference Room", "L1", 30, true, "All");
    Room r4 = new Room("Lab Room", "L2", 20, true, "None");

    ArrayList<Room> roomList = new ArrayList<>();
    roomList.add(r1);
    roomList.add(r2);
    roomList.add(r3);
    roomList.add(r4);

    // set the titles of the rooms
    for (int i = 0; i < roomList.size(); i++) {
      // add vbox
      VBox vb = new VBox();
      vb.setAlignment(TOP_CENTER);
      vb.setPrefSize(612, 229);

      // add textfield
      TextFieldTableCell roomListing = new TextFieldTableCell();
      roomListing.setText(roomList.get(i).getName());
      roomListing.setAlignment(CENTER);
      roomListing.setTextAlignment(TextAlignment.CENTER);
      roomListing.setPrefSize(86, 247);
      roomListing.setFont(Font.font("Open Sans", 20));

      vb.getChildren().add(roomListing);

      conferenceRoomsHBox.getChildren().add(vb);
    }
  }
}

class Room {
  String name;
  String floor;
  int cap;
  boolean availability;
  String features;

  public Room(String name, String floor, int cap, boolean availability, String features) {
    this.name = name;
    this.floor = floor;
    this.cap = cap;
    this.availability = availability;
    this.features = features;
  }

  public String name() {
    return name;
  }

  public String getName() {
    return name;
  };

  public String floor() {
    return floor;
  }

  public void setFloor(String floor) {
    floor = floor;
  }

  public int cap() {
    return cap;
  }

  public void setCap(int cap) {
    cap = cap;
  }

  public boolean availability() {
    return availability;
  }

  public void setAvailability(String availability) {
    availability = availability;
(event -> Navigation.navigate(Screen.HOME));
  }
}
