package edu.wpi.teamname;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FacilitiesStaffEntity {

    @Setter @Getter ArrayList<RoomBooking> listOfRoomBookings;

    public FacilitiesStaffEntity(ArrayList<RoomBooking> listOfRoomBookings) {
        this.listOfRoomBookings = listOfRoomBookings;
    }

}
