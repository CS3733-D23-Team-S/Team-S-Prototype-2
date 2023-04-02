package edu.wpi.teamname.Database.Map;

import java.util.Date;
import java.util.List;

public interface MoveDAO_I {
    public List<Move> getAllMoves();
    public List<Move> getLocationMove(String location );

    public Move getMove(String location, Date moveDate) throws Exception;
}
