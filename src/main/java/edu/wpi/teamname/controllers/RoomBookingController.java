package edu.wpi.teamname.controllers;

import edu.wpi.teamname.Database.ServiceRequests.ConferenceRoom.ConfRoomRequest;
import edu.wpi.teamname.Database.ServiceRequests.ConferenceRoom.RoomRequestDAO;
import edu.wpi.teamname.Database.ServiceRequests.Room;
import edu.wpi.teamname.Database.ServiceRequests.Status;
import edu.wpi.teamname.navigation.*;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

public class RoomBookingController {

  @FXML MFXButton addMeetingButton;
  @FXML MFXButton backButton;
  @FXML HBox conferenceRoomsHBox; // hbox containing all conference rooms and schedules

  RoomBooking rb = new RoomBooking();
  RoomRequestDAO roomRequestDAO = RoomRequestDAO.getInstance();

  Room r1, r2, r3, r4;

  ArrayList<Room> roomList = new ArrayList<>();
  ArrayList<ConfRoomRequest> reservationList = new ArrayList<>();

  @FXML
  public void initialize() {
    addMeetingButton.setOnMouseClicked(event -> Navigation.navigate(Screen.ROOM_BOOKING_DETAILS));
    backButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));

    createDummyRooms(); // create dummy rooms
    createDummyRoomRequests(); // create dummy reservations
    rb.setRoomList(roomList); // later -- read from DB
    rb.setRoomRequestList(reservationList);

    // read room requests from DB

    rb.createRoomsUI(conferenceRoomsHBox);
  }

  public static void addNewRequest(
      String roomLocation,
      String startTime,
      String endTime,
      String eventTitle,
      String eventDescription) {
    ConfRoomRequest newRequest =
        new ConfRoomRequest(
            LocalDate.now(),
            LocalTime.of(Integer.parseInt(startTime), 0, 0, 0),
            LocalTime.of(Integer.parseInt(endTime), 0, 0, 0),
            new Room(Integer.parseInt(roomLocation), "Cafe", "Floor", 50, "F"),
            "TestReserve",
            eventTitle,
            eventDescription,
            "Assignee",
            Status.Received,
            "No notes");
    // roomRequestDAO.addRequest(request); TODO need this?
  }

  public void createDummyRooms() {
    Room r1 = new Room(1, "Hale Cafe", "L1", 30, "All");
    Room r2 = new Room(2, "Teaching Room", "L2", 50, "All");
    Room r3 = new Room(3, "Conference Room", "L1", 30, "All");
    Room r4 = new Room(4, "Lab Room", "L2", 20, "None");
    roomList.add(r1);
    roomList.add(r2);
    roomList.add(r3);
    roomList.add(r4);
  }

  public void createDummyRoomRequests() {
    ConfRoomRequest res1 =
        new ConfRoomRequest(
            LocalDate.now(),
            LocalTime.of(6, 0, 0, 0),
            LocalTime.of(8, 0, 0, 0),
            r1,
            "Sarah Kogan",
            "Checking for update",
            "description description description",
            null,
            Status.Received,
            "");
    ConfRoomRequest res2 =
        new ConfRoomRequest(
            LocalDate.now(),
            LocalTime.of(8, 0, 0, 0),
            LocalTime.of(10, 0, 0, 0),
            r1,
            "Jimmy Buffett",
            "Meeting Test 2",
            "description 2",
            null,
            Status.Received,
            "");
    ConfRoomRequest res3 =
        new ConfRoomRequest(
            LocalDate.now(),
            LocalTime.of(12, 0, 0, 0),
            LocalTime.of(4, 0, 0, 0),
            r2,
            "Christine Dion",
            "Conference Rooooooom",
            "description description description",
            null,
            Status.InProgress,
            "");
    roomRequestDAO.addRequest(res1);
    roomRequestDAO.addRequest(res2);
    roomRequestDAO.addRequest(res3);

    reservationList.add(res1);
    reservationList.add(res2);
    reservationList.add(res3);

    roomRequestDAO.addRequest(res1);
    roomRequestDAO.addRequest(res2);
    roomRequestDAO.addRequest(res3);
  }
}
