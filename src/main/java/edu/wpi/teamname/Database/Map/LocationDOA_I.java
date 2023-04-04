package edu.wpi.teamname.Database.Map;

import java.util.List;

public interface LocationDOA_I {
  public List<Location> getAllLocations();

  public Location getLocation(String longName);
}
