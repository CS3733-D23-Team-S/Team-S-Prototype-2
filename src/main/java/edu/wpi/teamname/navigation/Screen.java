package edu.wpi.teamname.navigation;

public enum Screen {
  ROOT("views/Root.fxml"),
  HOME("views/Home.fxml"),
  SERVICE_REQUEST("views/ServiceRequest.fxml"),
  ROOM_BOOKING("views/RoomBooking.fxml"),
  ROOM_BOOKING_DETAILS("views/RoomBookingDetails.fxml");

  private final String filename;

  Screen(String filename) {
    this.filename = filename;
  }

  public String getFilename() {
    return filename;
  }
}
