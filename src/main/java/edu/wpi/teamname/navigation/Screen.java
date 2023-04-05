package edu.wpi.teamname.navigation;

public enum Screen {
  ROOT("views/Root.fxml"),
  HOME("views/Home.fxml"),
  LOGIN_PAGE("views/LoginPage.fxml"),
  HELP_PAGE("views/HelpPage.fxml"),

  PATHFINDING("views/Pathfinding.fxml"),
  ROOM_BOOKING("views/RoomBooking.fxml"),
  SERVICE_REQUEST("views/ServiceRequest.fxml"); // Meal Request



  private final String filename;

  Screen(String filename) {
    this.filename = filename;
  }

  public String getFilename() {
    return filename;
  }
}
