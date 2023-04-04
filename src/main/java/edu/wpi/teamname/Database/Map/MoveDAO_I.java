package edu.wpi.teamname.Database.Map;

import java.time.LocalDate;
import java.util.List;

public interface MoveDAO_I {
  List<Move> getAllMoves();

  void initTable(String name);

  List<Move> getLocationMove(String location);

  Move getMove(String location, LocalDate moveDate) throws Exception;

  void loadToRemote(String pathToCSV);
}
