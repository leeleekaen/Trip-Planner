package nautilussoup.tripplanner.Models;

import android.location.Location;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Event implements Serializable {
    private static final long serialVersionUID = 48L;
    private String eventName;
    private GregorianCalendar startTime;
    private GregorianCalendar endTime;
    private Location eventLocation;

    //Placeholder constructor for view testing
    public Event(String name) {
        eventName = name;
        startTime = new GregorianCalendar();
        endTime = new GregorianCalendar();
    }

    public Event(String name, GregorianCalendar start, GregorianCalendar end) {
        eventName = name;
        startTime = start;
        endTime = end;
    }

    public Event(String name, Location targetLocation) {
        eventName = name;
        startTime = new GregorianCalendar();
        endTime = new GregorianCalendar();
        this.eventLocation = targetLocation;
    }

    public String getName() {
        return eventName;
    }

    public GregorianCalendar getStartTime() {
        return startTime;
    }

    public GregorianCalendar getEndTime() {
        return endTime;
    }

    public Location getEventLocation() {
        return eventLocation;
    }
}
