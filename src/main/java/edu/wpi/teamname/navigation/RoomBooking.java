package edu.wpi.teamname.navigation;

import edu.wpi.teamname.controllers.RoomBookingController;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

import static javafx.geometry.Pos.CENTER;
import static javafx.geometry.Pos.TOP_CENTER;

public class RoomBooking {

  ArrayList<Room> roomList = new ArrayList<>();

  public void setRoomList(ArrayList<Room> roomList) {
    this.roomList = roomList;
  }

  public void setUpRooms(HBox conferenceRoomsHBox) {
    for (int i = 0; i < roomList.size(); i++) {
      // add vbox
      VBox vb = new VBox();
      // styling
      vb.setAlignment(TOP_CENTER);
      vb.setPrefSize(612, 229);

      // add textfield - styling
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