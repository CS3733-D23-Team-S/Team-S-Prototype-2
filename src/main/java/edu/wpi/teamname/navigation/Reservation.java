package edu.wpi.teamname.navigation;

public class Reservation {

    int startTime, endTime;
    String name, floor, eventName, eventDescription, reservedBy;    // TODO reservedBy user, name+floor -> roomLocation

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
    public String name() {
        return name;
    }
    public void setName(String name) {
        name = name;
    }
    public String floor() {
        return floor;
    }
    public void setFloor(String floor) {
        floor = floor;
    }
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
