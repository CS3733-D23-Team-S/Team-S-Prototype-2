package edu.wpi.teamname.Database.ServiceRequests.ConferenceRoom;

import edu.wpi.teamname.Database.dbConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class RoomRequestDAO implements RoomRequest_I{
    protected static final String schemaName = "hospitaldb";
    protected final String roomRequestsTable = schemaName + "." + "roomRequests";
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
            try (PreparedStatement preparedStatement = connection.getC()
                    .prepareStatement(
                            "INSERT INTO "
                                    + roomRequestsTable
                                    + " (deliveryID, orderDate , assignedBy, assignedTo, room, notes) "
                                    + " VALUES (?, ?, ?, ?, ?, ?, ?)")) {
                preparedStatement.setInt(1, request.getReservationID());
                preparedStatement.setDate(2, null);
                preparedStatement.setString(3, request.getOrderer());
                preparedStatement.setString(4, request.getAssignedTo());
                preparedStatement.setInt(5, request.getRoom().getNodeID());
                preparedStatement.setString(6, request.getNotes());


                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }

    }

    @Override
    public void deleteRequest(ConfRoomRequest request) {

    }
}
