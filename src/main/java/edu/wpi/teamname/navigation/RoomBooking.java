package edu.wpi.teamname.navigation;

import static javafx.geometry.Pos.*;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class RoomBooking {

  // set lists
  ArrayList<Room> roomList = new ArrayList<>();
  ArrayList<Reservation> reservationList = new ArrayList<>();

  // getters setters
  public ArrayList<Room> roomList() {
    return roomList;
  }

  public ArrayList<Reservation> reservationList() {
    return reservationList;
  }

  public void setRoomList(ArrayList<Room> roomList) {
    this.roomList = roomList;
  }

  public void setReservationList(ArrayList<Reservation> reservationList) {
    reservationList = reservationList;
  }

  @FXML HBox conferenceRoomsHBox;

  // pull rooms into UI
  public void setRoomsUI(HBox conferenceRoomsHBox) {
    for (int i = 0; i < roomList.size(); i++) {
      // add vbox
      VBox vb = new VBox();
      // styling
      vb.setAlignment(TOP_CENTER);
      vb.setPrefSize(612, 229);

      // add text field - styling
      TextFieldTableCell roomListing = new TextFieldTableCell();
      roomListing.setText(roomList.get(i).getName());
      roomListing.setAlignment(TOP_CENTER);
      roomListing.setTextAlignment(TextAlignment.CENTER);
      roomListing.setPrefSize(86, 247);
      roomListing.setFont(Font.font("Open Sans", 20));

      vb.setId("room" + roomList.get(i).id());
      vb.getChildren().add(roomListing); // add textfield into vbox
      conferenceRoomsHBox.getChildren().add(vb); // add vbox into conf hbox
    }
  }

  public void setReservationList() {
    for (int i = 0; i < reservationList.size(); i++) {
      Room r = reservationList.get(i).room();
      r.addReservation(reservationList.get(i));
    }
  }

  public void setReservationUI(HBox conferenceRoomsHBox) {
    for (int i = 0; i < reservationList.size(); i++) {
      Group resGroup = new Group(); // create group

      Rectangle rect = new Rectangle(); // create rectangle
      rect.setWidth(170);
      rect.setHeight(110);
      rect.setFill(Color.ALICEBLUE);
      rect.setArcHeight(5);

      Text title = new Text(); // create text
      title.setText(reservationList.get(i).eventName);
      title.setFont(Font.font("Open Sans", 15));
      title.setStyle("Bold");
      title.setLayoutX(5);
      title.setLayoutY(25);

      resGroup.getChildren().add(rect);
      resGroup.getChildren().add(title);

      // VBox roomVBox = conferenceRoomsHBox.lookup("room1");

      /*
      for (int j = 0; j < conferenceRoomsHBox.getChildren().size(); j++) {
        if (conferenceRoomsHBox.getChildren().get(j).getId()
            == ("room" + reservationList.get(i).room().id())) {
          System.out.println("Working");
        }
      }

       */
    }
  }
}
