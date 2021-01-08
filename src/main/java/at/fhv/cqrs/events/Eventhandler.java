package at.fhv.cqrs.events;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import at.fhv.cqrs.events.listener.*;
public class Eventhandler {
    private static List<Eventroot> Events = new LinkedList<>();
    private static Set<IHotelRoomCreatedListener> hotelRoomCreatedListener = new HashSet<>();
    private static Set<IRoomBookedListener> roomBookedListener = new HashSet<>();

	public static void addEvent(Eventroot event) { 
        Events.add(event);
        System.out.println(event);

        if(event instanceof HotelRoomCreated){
            hotelRoomCreatedListener.forEach(listener -> {
                listener.inform(event);
                System.out.println(event);
            });
        }

        if(event instanceof HotelRoomCreated){
            roomBookedListener.forEach(listener -> {
                listener.inform(event);
                System.out.println(event);
            });
        }
    }

    public static void subscribe(IHotelEventListener listener){
        if(listener instanceof IHotelRoomCreatedListener){
            hotelRoomCreatedListener.add((IHotelRoomCreatedListener)listener);
        }

        if(listener instanceof IRoomBookedListener){
            roomBookedListener.add((IRoomBookedListener)listener);
        }
    }

    public static void unsubscribe(IHotelEventListener listener){

        if(listener instanceof IHotelRoomCreatedListener){
            hotelRoomCreatedListener.remove(listener);
        }

        if(listener instanceof IRoomBookedListener){
            hotelRoomCreatedListener.remove(listener);
        }
    }

}
