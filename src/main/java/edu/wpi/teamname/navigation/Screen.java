package edu.wpi.teamname.navigation;

public enum Screen {
  ROOT("views/Root.fxml"),
  HOME("views/Home.fxml"),
  ADMIN_PAGE("views/AdminPage.fxml"),
  SIGNAGE_PAGE("views/SignagePage.fxml"),
  HELP_PAGE("views/HelpPage.fxml"),
  MAP_EDITOR("views/mapEditor.fxml"),

  PATHFINDING("views/Pathfinding.fxml"),
  SUBMITTED_MEAL_REQUESTS("views/SubmittedMealRequests.fxml"),
  SUBMITTED_ROOM_REQUESTS("views/SubmittedRoomRequests.fxml"),
  SERVICE_REQUEST("views/ServiceRequest.fxml");

  private final String filename;

  Screen(String filename) {
    this.filename = filename;
  }

  public String getFilename() {
    return filename;
  }
}
