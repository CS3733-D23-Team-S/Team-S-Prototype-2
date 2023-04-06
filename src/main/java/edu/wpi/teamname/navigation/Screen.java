package edu.wpi.teamname.navigation;

public enum Screen {
  ROOT("views/Root.fxml"),
  WELCOME_PAGE("views/WelcomePage.fxml"),
  LOGIN_PAGE("views/LoginPage.fxml"),
  HOME("views/Home.fxml"),
  ROOM_BOOKING("views/RoomBooking.fxml"),
  HELP_PAGE("views/HelpPage.fxml"),
  PATHFINDING("views/Pathfinding.fxml"),
  MEAL_DELIVERY("views/ServiceRequestPages/MealDelivery.fxml"), // Meal Request
  SIGNAGE_PAGE("views/SignagePage.fxml"),


  KITCHEN_STAFF("views/KitchenStaff.fxml"),
  FACILITIES_STAFF("views/FacilitiesStaff.fxml"),
  MAP_EDITOR("views/MapEditor.fxml"),
  CSV_MANAGE("views/CSVPage.fxml");

  private final String filename;

  Screen(String filename) {
    this.filename = filename;
  }

  public String getFilename() {
    return filename;
  }
}
