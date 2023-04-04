package edu.wpi.teamname.Database.ServiceRequests.ConferenceRoom;

import edu.wpi.teamname.Database.ServiceRequests.FoodService.FoodDelivery;

import java.util.List;

public interface RoomRequest_I {
    public List<ConfRoomRequest> getAllRequests();

    public ConfRoomRequest getRequest(int requestID);

    public void addRequest(ConfRoomRequest request);

    public void deleteRequest(ConfRoomRequest request);
}
