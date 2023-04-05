package edu.wpi.teamname;

import edu.wpi.teamname.Database.ServiceRequests.ConferenceRoom.ConfRoomRequest;
import edu.wpi.teamname.Database.ServiceRequests.ConferenceRoom.RoomRequestDAO;
import edu.wpi.teamname.Database.ServiceRequests.Room;
import edu.wpi.teamname.Database.ServiceRequests.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class RoomBookingTest {
  RoomRequestDAO roomRequestDAO = RoomRequestDAO.getInstance();


  @Test
  public void addtoDaoTest() {
    ConfRoomRequest res1 =
            new ConfRoomRequest(
                    LocalDate.now(),
                    LocalTime.of(6, 0, 0, 0),
                    LocalTime.of(8, 0, 0, 0),
                    new Room(Integer.parseInt(" "), "Cafe", "Floor", 50, "F"),
                    "Sarah Kogan",
                    "Checking for update",
                    "description description description",
                    null,
                    Status.Received,
                    "");
    int id = res1.getReservationID();
    roomRequestDAO.addRequest(res1);
    assert(roomRequestDAO.getRequest(id) == res1);
  }
}
