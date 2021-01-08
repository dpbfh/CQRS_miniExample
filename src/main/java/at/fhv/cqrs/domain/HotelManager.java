package at.fhv.cqrs.domain;

import java.time.LocalDate;
import java.util.List;

public class HotelManager {

    private static List<Booking> bookings;
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
    private static int BookRoom(int roomNumber, List<Person> guests, LocalDate bookedFrom, LocalDate bookedUntil){
        var booking = new Booking(Hotel.getHotel().getHotelRooms().get(roomNumber), guests, bookedFrom, bookedUntil);
        bookings.add(booking);
        return bookings.indexOf(booking);
    }

    private static void CancelRoom(int bookingNumber){
        bookings.remove(bookingNumber);
    }
}
