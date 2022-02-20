package pl.adrian_komuda.manipulate_volume_object.services;

import org.bukkit.Location;
import pl.adrian_komuda.manipulate_volume_object.messages.MessagesWith0Params;
import pl.adrian_komuda.manipulate_volume_object.messages.MessagesWith2Params;

public class LocationService {

    private static LocationService instance;

    private Location location1;
    private Location location2;

    LocationService() {}

    public static LocationService getInstance() {
        if (instance == null) {
            instance = new LocationService();
        }
        return instance;
    }

    public String markLocation(Location location) {
        if (location1 == null || location2 != null) {
            location2 = null;
            location1 = location;
            return MessagesWith0Params.LOCATION1_SET.getMessage();
        } else {
            location2 = location;
            return MessagesWith0Params.LOCATION2_SET.getMessage();
        }
    }

    public String getLocationsAsMessage() {
        return MessagesWith2Params.GET_LOCATIONS.getMessage(String.valueOf(location1), String.valueOf(location2));
    }

    public void resetLocations() {
        location1 = null;
        location2 = null;
    }

    public boolean areLocationsSet() {
        return location1 != null && location2 != null;
    }

    public boolean isLocation1Set() {
        return location1 != null;
    }

    public Location getLocation1() {
        return location1;
    }

    public Location getLocation2() {
        return location2;
    }
}