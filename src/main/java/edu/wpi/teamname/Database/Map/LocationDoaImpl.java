package edu.wpi.teamname.Database.Map;

import java.util.HashMap;
import java.util.List;

public class LocationDoaImpl implements LocationDOA_I{
    private static LocationDoaImpl single_instance;
    HashMap<String ,Location> locations;

    LocationDoaImpl(){}
    public static synchronized LocationDoaImpl getInstance()
    {
        if (single_instance == null)
            single_instance = new LocationDoaImpl();

        return single_instance;
    }
    @Override
    public List<Location> getAllLocations() {
        return (List<Location>) this.locations.values();
    }

    @Override
    public Location getLocation(String longName) {
        return this.locations.get(longName);
    }



}
