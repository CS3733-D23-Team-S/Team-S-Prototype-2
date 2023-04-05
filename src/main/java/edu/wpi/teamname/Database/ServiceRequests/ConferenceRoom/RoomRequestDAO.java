package edu.wpi.teamname.Database.ServiceRequests.ConferenceRoom;

import edu.wpi.teamname.Database.dbConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class RoomRequestDAO implements RoomRequest_I {
  protected static final String schemaName = "hospitaldb";
  protected final String roomReservationsTable = schemaName + "." + "roomReservations";
  HashMap<Integer, ConfRoomRequest> requests = new HashMap<Integer, ConfRoomRequest>();
  dbConnection connection = dbConnection.getInstance();
  static RoomRequestDAO single_instance = null;

  private RoomRequestDAO() {}

  public static synchronized RoomRequestDAO getInstance() {

    if (single_instance == null) single_instance = new RoomRequestDAO();

    return single_instance;
  }

  @Override
  public List<ConfRoomRequest> getAllRequests() {
    return null;
  }

  @Override
  public ConfRoomRequest getRequest(int requestID) {
    return null;
  }

  @Override
  public void addRequest(ConfRoomRequest request) {
    requests.put(request.getReservationID(), request);
    try {
      PreparedStatement preparedStatement =
          connection
              .getC()
              .prepareStatement(
                  "INSERT INTO "
                      + roomReservationsTable
                      + " (reservationID, date, startTime, endTime, room, reservedBy, eventName, eventDescription, assignedTo, orderStatus, notes) "
                      + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
      preparedStatement.setInt(1, request.getReservationID());
      preparedStatement.setDate(2, null);
      preparedStatement.setTime(3, null);
      preparedStatement.setTime(4, null);
      preparedStatement.setString(5, "ROOM"); // TODO add room id
      preparedStatement.setString(6, request.getReservedBy());
      preparedStatement.setString(7, request.getEventName());
      preparedStatement.setString(8, request.getEventDescription());
      preparedStatement.setString(9, request.getAssignedTo());
      preparedStatement.setString(10, request.getOrderStatus().name()); // TODO fix
      preparedStatement.setString(11, request.getNotes());

      preparedStatement.executeUpdate();
    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }
  }

  @Override
  public void deleteRequest(ConfRoomRequest request) {}
}
