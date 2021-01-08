package at.fhv.cqrs.events;

import java.util.LinkedList;
import java.util.List;

public class Eventhandler {
    private static List<Eventroot> Events = new LinkedList<>();
    
	public static void addEvent(Eventroot event) { 
        Events.add(event);

    }

}
