package edu.wpi.teamname.navigation;

import static javafx.geometry.Pos.*;

import edu.wpi.teamname.Database.ServiceRequests.ConferenceRoom.ConfRoomRequest;
import edu.wpi.teamname.Database.ServiceRequests.Room;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import lombok.Getter;
import lombok.Setter;

public class RoomBooking {

  // set lists
  @Getter @Setter ArrayList<Room> roomList = new ArrayList<>();
  @Getter @Setter ArrayList<ConfRoomRequest> roomRequestList = new ArrayList<>();

  @FXML HBox conferenceRoomsHBox;
  private TextFieldTableCell roomListing;

  // pull rooms into UI
  public void createRoomsUI(HBox conferenceRoomsHBox) {
    for (int i = 0; i < roomList.size(); i++) {
      // add vbox
      VBox vb = new VBox();
      // styling
      vb.setAlignment(TOP_CENTER);
      vb.setPrefSize(612, 229);

      // add text field - styling
      TextFieldTableCell roomListing = new TextFieldTableCell();
      roomListing.setText(roomList.get(i).getName());
      roomListing.setAlignment(CENTER);
      roomListing.setTextAlignment(TextAlignment.CENTER);
      roomListing.setPrefSize(247, 86);
      roomListing.setFont(Font.font("Open San s", 20));
      roomListing.setTextFill(Paint.valueOf("#1D3D94"));
      vb.setId("room" + roomList.get(i).getId());
      vb.getChildren().add(roomListing); // add textfield into vbox
      conferenceRoomsHBox.getChildren().add(vb); // add vbox into conf hbox

      System.out.println(vb.getId());
    }
  }

  public void createReservationsUI(HBox conferenceRoomsHBox) {

    for (int i = 0; i < roomRequestList.size(); i++) {
      Group resGroup = new Group(); // create group

      Rectangle rect = new Rectangle(); // create rectangle
      rect.setWidth(170);
      rect.setHeight(110);
      rect.setArcHeight(5);

      resGroup.getChildren().add(rect);
      System.out.println("CHILDREN: ");
      System.out.println(conferenceRoomsHBox.getChildren());

      // for (int j=0; j<conferenceRoomsHBox.getChildren().size(); j++) {
      //  if (conferenceRoomsHBox.getChildren().get(j).getId() == "room" +
      // roomRequestList.get(i).getRoom().getId()) {
      //    conferenceRoomsHBox.getChildren().add(resGroup);
      //   }
      // }
      // for (int j = 0; j < roomList.size(); j++) {
      //  conferenceRoomsHBox.getChildren().lookup("#room" + roomList.get(j).getId());
      // }
    }
    /*
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
     */

    // VBox roomVBox = (VBox) conferenceRoomsHBox.lookup("room1");

    // roomVBox.getChildren().add(resGroup);

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
