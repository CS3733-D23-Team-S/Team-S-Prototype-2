package edu.wpi.teamname.navigation;

public enum Screen {
  ROOT("views/Root.fxml"),
  HOME("views/Home.fxml"),
  SIGNAGE_PAGE("views/SignagePage.fxml"),
  HELP_PAGE("views/HelpPage.fxml"),

  PATHFINDING("views/Pathfinding.fxml"),
  SERVICE_REQUEST("views/ServiceRequest.fxml");

  private final String filename;

  Screen(String filename) {
    this.filename = filename;
  }

  public String getFilename() {
    return filename;
  }
}
