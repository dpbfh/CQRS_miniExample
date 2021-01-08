package at.fhv.cqrs.domain.read;

import at.fhv.cqrs.domain.Booking;
import at.fhv.cqrs.domain.Hotel;
import at.fhv.cqrs.domain.HotelManager;
import at.fhv.cqrs.domain.HotelRoom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class HotelReadRepository {

    private List<HotelReadRoom> hotelReadRooms;

    public HotelReadRepository(List<HotelReadRoom> hotelReadRooms){
        this.hotelReadRooms = hotelReadRooms;

    }

    public List<HotelReadRoom> getFreeRooms(LocalDate bookedFrom, LocalDate bookedUntil, int numberOfGuests){
        List<HotelReadRoom> freeRooms = hotelReadRooms;
        for (HotelReadRoom room : hotelReadRooms) {
            if(room.isRoomFree(bookedFrom, bookedUntil, numberOfGuests)){
                freeRooms.add(room);
            }
        }
        return freeRooms;
    }

    public List<Booking> getBookings(LocalDate bookedFrom, LocalDate bookedUntil){
        List<Booking> bookingsInThatTimeSpan = new LinkedList<>();
        for(Booking booking : HotelManager.getHotelManager().getBookings()){
            if(booking.getBookedFrom().isAfter(bookedFrom) ||booking.getBookedFrom().isEqual(bookedFrom)){
                if(booking.getBookedFrom().isBefore(bookedUntil) || booking.getBookedFrom().isEqual(bookedUntil)){
                    bookingsInThatTimeSpan.add(booking);
                }
            }
        }
        return bookingsInThatTimeSpan;
    }
}
