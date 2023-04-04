package edu.wpi.teamname.controllers;

import static javafx.geometry.Pos.CENTER;
import static javafx.geometry.Pos.TOP_CENTER;

import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Room;
import edu.wpi.teamname.navigation.RoomBooking;
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

  ArrayList<Room> roomList = new ArrayList<>();

  RoomBooking rb = new RoomBooking();

  @FXML
  public void initialize() {
    addMeetingButton.setOnMouseClicked(event -> Navigation.navigate(Screen.ROOM_BOOKING_DETAILS));
    backButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));

    // create rooms (TDDB: replace with db items)
    Room r1 = new Room("Hale Cafe", "L1", 30,  "All");
    Room r2 = new Room("Teaching Room", "L2", 50,  "All");
    Room r3 = new Room("Conference Room", "L1", 30,  "All");
    Room r4 = new Room("Lab Room", "L2", 20, "None");

    roomList.add(r1);
    roomList.add(r2);
    roomList.add(r3);
    roomList.add(r4);

    // set up room list
    rb.setRoomList(roomList);

    // set the titles of the rooms
    rb.setUpRooms(conferenceRoomsHBox);

    // read in meetings to frontend that were already set


    // add a meeting to the system


    // FILTERS

    // filter by date

    // filter by time

    // filter by features


  }
}