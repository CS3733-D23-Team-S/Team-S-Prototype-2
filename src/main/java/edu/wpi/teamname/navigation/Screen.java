package edu.wpi.teamname.navigation;

public enum Screen {
  ROOT("views/Root.fxml"),
  WELCOME_PAGE("views/WelcomePage.fxml"),
  LOGIN_PAGE("views/LoginPage.fxml"),
  HOME("views/Home.fxml"),

  HELP_PAGE("views/HelpPage.fxml"),

  PATHFINDING("views/Pathfinding.fxml"),
  ROOM_BOOKING("views/RoomBooking.fxml"),
  SERVICE_REQUEST("views/ServiceRequestPages/ServiceRequest.fxml"), // Meal Request

  CSV_MANAGE("views/CSVPage.fxml");

  private final String filename;

  Screen(String filename) {
    this.filename = filename;
  }

  public String getFilename() {
    return filename;
  }
}
