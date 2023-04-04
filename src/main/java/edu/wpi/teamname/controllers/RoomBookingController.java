package edu.wpi.teamname.controllers;

import static javafx.geometry.Pos.CENTER;
import static javafx.geometry.Pos.TOP_CENTER;

import edu.wpi.teamname.navigation.*;
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
  ArrayList<Reservation> reservationList = new ArrayList<>();

  RoomBooking rb = new RoomBooking();

  @FXML
  public void initialize() {
    addMeetingButton.setOnMouseClicked(event -> Navigation.navigate(Screen.ROOM_BOOKING_DETAILS));
    backButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));

    // create rooms TODO: replace with db items
    Room r1 = new Room(1, "Hale Cafe", "L1", 30,  "All");
    Room r2 = new Room(2, "Teaching Room", "L2", 50,  "All");
    Room r3 = new Room(3, "Conference Room", "L1", 30,  "All");
    Room r4 = new Room(4, "Lab Room", "L2", 20, "None");
    roomList.add(r1);
    roomList.add(r2);
    roomList.add(r3);
    roomList.add(r4);
    // create reservations
    Reservation res1 = new Reservation(8, 10, r1, "Policy Change Meeting", "Change policy", "Sarah Kogan");
    Reservation res2 = new Reservation(16, 18, r1, "Meeting2", "Test meeting 2", "Sarah Kogan");
    Reservation res3 = new Reservation(12, 14, r1, "Meeting3", "test time ordering", "Sarah Kogan");
    Reservation res4 = new Reservation(11, 15, r1, "Overlapping meeting", "test overlapping throw error", "Sarah Kogan");
    Reservation res5 = new Reservation(10, 13, r2, "Test meeting again", "Testing testing testing", "John Adams");
    Reservation res6 = new Reservation(14, 16, r2, "Another meeting", "Another another test test", "Jimmy Buffet");
    reservationList.add(res1);
    reservationList.add(res2);
    reservationList.add(res3);
    reservationList.add(res4);
    reservationList.add(res5);
    reservationList.add(res6);

    // set room list
    rb.setRoomList(roomList);

    // set rooms into UI
    rb.setRoomsUI();

    // set meeting list
    rb.setReservationList();

    // set meetings into UI
    rb.setReservationUI();

        // order meetings (later)

    // add a meeting to the system




    // FILTERS

    // filter by date

    // filter by time

    // filter by features


  }
}