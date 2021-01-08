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
    private static Set<ICancledBookingListener> cancledBookingListener = new HashSet<>();

	public static void addEvent(Eventroot event) { 
        Events.add(event);

        if(event instanceof HotelRoomCreated){
            hotelRoomCreatedListener.forEach(listener -> {
                listener.informHotelRoomCreated((HotelRoomCreated)event);
            });
        }

        if(event instanceof RoomBooked){
            roomBookedListener.forEach(listener -> {
                listener.informRoomBooked((RoomBooked)event);
            });
        }

        if(event instanceof  CancledBooking){
            cancledBookingListener.forEach(listener -> {
                listener.informCancledBookingListener((CancledBooking)event);
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

        if(listener instanceof ICancledBookingListener){
            cancledBookingListener.add((ICancledBookingListener)listener);
        }
    }

    public static void unsubscribe(IHotelEventListener listener){

        if(listener instanceof IHotelRoomCreatedListener){
            hotelRoomCreatedListener.remove(listener);
        }

        if(listener instanceof IRoomBookedListener){
            roomBookedListener.remove(listener);
        }
        if(listener instanceof ICancledBookingListener){
            cancledBookingListener.remove(listener);
        }
    }


}
