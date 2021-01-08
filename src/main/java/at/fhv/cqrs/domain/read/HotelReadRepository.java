package at.fhv.cqrs.domain.read;

import at.fhv.cqrs.domain.Booking;
import at.fhv.cqrs.domain.Hotel;
import at.fhv.cqrs.domain.HotelManager;
import at.fhv.cqrs.domain.HotelRoom;

import java.time.LocalDate;
import java.util.*;

public class HotelReadRepository {


    private Map<Integer,HotelReadRoom> hotelReadRooms;
    private Map<Integer,BookingRead> bookings = new HashMap<>();;
    private static HotelReadRepository instance;

    public static HotelReadRepository getInstance(){
        instance = (HotelReadRepository.instance == null) ? new HotelReadRepository() : instance;
        return instance;
    }

    private HotelReadRepository() {
        this.hotelReadRooms = new HashMap<>();
    }

    public void addHotelReadRoom(HotelReadRoom hotelReadRooms){
         this.hotelReadRooms.put(hotelReadRooms.getId(),hotelReadRooms);
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

    public Map<Integer, BookingRead> getBookings(LocalDate bookedFrom, LocalDate bookedUntil){
        for(BookingRead bookingRead: bookings.values()){
            if(bookingRead.isBookingFree(bookedFrom, bookedUntil)){
                bookings.put(bookingRead.getBooking().getId(), bookingRead);
            }
        }
        return bookings;
    }



    public HotelReadRoom getRoombyID(int roomNumber) {
        return hotelReadRooms.get(roomNumber);
    }
}
