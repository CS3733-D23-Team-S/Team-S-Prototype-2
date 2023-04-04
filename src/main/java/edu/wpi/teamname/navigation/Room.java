package edu.wpi.teamname.navigation;

import java.util.ArrayList;

public class Room {         // TODO name + floor -> roomLocation, features -> list(?)
    String name;
    String floor;
    int cap;
    String features;
    ArrayList<Reservation> reservationsList = new ArrayList<Reservation>();

    public Room(String name, String floor, int cap, String features) {
        this.name = name;
        this.floor = floor;
        this.cap = cap;
        this.features = features;
    }

    public String name() {
        return name;
    }
    public String getName() {
        return name;
    };
    public String floor() {
        return floor;
    }
    public void setFloor(String floor) {
        floor = floor;
    }
    public int cap() {
        return cap;
    }
    public void setCap(int cap) {
        cap = cap;
    }

    public boolean addReservation(Reservation r) {
        // rough function!!! just for testing TODO rewrite this!
        for (int i=0; i<reservationsList.size(); i++) {
            if (r.startTime() > reservationsList.get(i).endTime() && reservationsList.get(i).startTime() < r.endTime()) {
                return false;
            } else {
                reservationsList.add(r);
                return true;
            }
        }
        return true;
    }
}
