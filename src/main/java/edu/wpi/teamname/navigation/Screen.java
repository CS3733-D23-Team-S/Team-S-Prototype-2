package edu.wpi.teamname.navigation;

public enum Screen {
  ROOT("views/Root.fxml"),
  HOME("views/Home.fxml"),
  MEAL_DELIVERY1("views/ServiceRequestPages/MealDelivery1.fxml"),
  SERVICE_REQUEST("views/ServiceRequestPages/ServiceRequest.fxml");

  private final String filename;

  Screen(String filename) {
    this.filename = filename;
  }

  public String getFilename() {
    return filename;
  }
}
