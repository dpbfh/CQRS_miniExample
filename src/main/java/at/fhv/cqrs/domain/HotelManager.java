package at.fhv.cqrs.domain;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class HotelManager {

    private  HashMap<Integer,Booking> bookings = new HashMap<>();
    private static HotelManager instance;

    public static HotelManager getHotelManager(){
        instance = (HotelManager.instance == null) ? new HotelManager() : instance;
        return instance;
    }

    /**
     * This method enables you to book a room
     * @param roomNumber roomNumber
     * @param guests The guests for this room
     * @param bookedFrom starting date of the booking
     * @param bookedUntil ending date of the booking
     * @return The Bookingnumber of this specific booking, will be needed to cancel booking
     */
    public  int BookRoom(int roomNumber, List<Person> guests, LocalDate bookedFrom, LocalDate bookedUntil){
        var booking = new Booking(Hotel.getHotel().getHotelRooms().get(roomNumber), guests, bookedFrom, bookedUntil);
        bookings.put(booking.getId(),booking);
        return booking.getId();
    }

    public  void CancelRoom(int bookingNumber){
        bookings.remove(bookingNumber);
    }

    public Collection<Booking> getBookings() {
        return bookings.values();
    }


    public static HotelManager getInstance() {
        return instance;
    }

    public static void setInstance(HotelManager instance) {
        HotelManager.instance = instance;
    }
}
