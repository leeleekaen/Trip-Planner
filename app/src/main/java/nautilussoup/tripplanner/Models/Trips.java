package nautilussoup.tripplanner.Models;

import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Trips implements Serializable {
    private static Trips instance;
    private List<Trip> tripList;

    private Trips() {
        tripList = new ArrayList<Trip>();
    }

    public static Trips getInstance() {
        if (instance == null) {
            instance = new Trips();
            Log.d("TAG", "Creating new instance of Trips");
        }
        Log.d("TAG", "Utilizing instance of Trips");
        return instance;
    }

    public void setTripList(List<Trip> TripList) {
        this.tripList = TripList;
    }

    public void setTrip(Trip tripToSet, int positionToSet) {
        tripList.set(positionToSet, tripToSet);
    }

    public List<Trip> getTripList() {
        return tripList;
    }


}