package edu.wpi.teamname.navigation;

public class Reservation {

  int startTime, endTime;
  String eventName,
      eventDescription,
      reservedBy; // TODO reservedBy user, name+floor -> roomLocation
  Room room;

  public Reservation(
      int startTime,
      int endTime,
      Room room,
      String eventName,
      String eventDescription,
      String reservedBy) {
    this.startTime = startTime;
    this.endTime = endTime;
    this.room = room;
    this.eventName = eventName;
    this.eventDescription = eventDescription;
    this.reservedBy = reservedBy;
  }

  // CONSTRUCTORS
  public int startTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    startTime = startTime;
  }

  public int endTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    endTime = endTime;
  }

  public Room room() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  };

  public String eventName() {
    return eventName;
  }

  public void setEventName(String eventName) {
    eventName = eventName;
  }

  public String eventDescription() {
    return eventDescription;
  }

  public void setEventDescription(String eventDescription) {
    eventDescription = eventDescription;
  }

  public String reservedBy() {
    return reservedBy;
  }

  public void setReservedBy(String reservedBy) {
    reservedBy = reservedBy;
  }
}
