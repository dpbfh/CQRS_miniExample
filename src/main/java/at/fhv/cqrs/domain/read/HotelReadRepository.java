package at.fhv.cqrs.domain.read;

import at.fhv.cqrs.domain.Booking;
import at.fhv.cqrs.domain.Hotel;
import at.fhv.cqrs.domain.HotelManager;
import at.fhv.cqrs.domain.HotelRoom;

import java.time.LocalDate;
import java.util.*;

public class HotelReadRepository {

    private HashMap<Integer, HotelReadRoom> hotelReadRooms;
    private List<BookingRead> readBookings;

    public HotelReadRepository(){
        this.hotelReadRooms = new HashMap<>();
    }

    public Collection<HotelReadRoom> getFreeRooms(LocalDate bookedFrom, LocalDate bookedUntil, int numberOfGuests){
        Collection<HotelReadRoom> freeRooms = new LinkedList<>();
        for (HotelReadRoom room : hotelReadRooms.values()) {
            if(room.isRoomFree(bookedFrom, bookedUntil, numberOfGuests)){
                freeRooms.add(room);
            }
        }
        return freeRooms;
    }

    public List<BookingRead> getBookings(LocalDate bookedFrom, LocalDate bookedUntil){
        for(BookingRead bookingRead: readBookings){
            if(bookingRead.getFreeBooking(bookedFrom, bookedUntil) != null){
                readBookings.add(bookingRead);
            }
        }
        return readBookings;
    }
}
