package at.fhv.cqrs.domain;

import at.fhv.cqrs.commands.controller.Pair;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelManager {

    private  HashMap<Integer,Booking> bookings = new HashMap<>();
    private  HashMap<Integer,Booking> canceledBookings = new HashMap<>();
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
     * @return The Bookingnumber of this specific booking, will be needed to cancel booking -1 ungültige eingabe -2 raum leider nicht verfügbar
     */
    public int BookRoom(int roomNumber, List<Person> guests, LocalDate bookedFrom, LocalDate bookedUntil){
        if(bookedFrom.isBefore(LocalDate.now()) || bookedFrom.isAfter(bookedUntil) || roomNumber < 1 || guests.isEmpty() ){
            return -1;
        }

        var booking = new Booking(Hotel.getHotel().getHotelRooms().get(roomNumber), guests, bookedFrom, bookedUntil);
        boolean isRoomAvailable = true;

        for(Booking openBooking : bookings.values()){
            if(openBooking.getRoom().getId() == roomNumber){
                if(openBooking.getBookedFrom().isBefore(bookedUntil) && openBooking.getBookedUntil().isAfter(bookedFrom)){
                    isRoomAvailable = false;
                }
            }
        }

        if(isRoomAvailable) {
            bookings.put(booking.getId(), booking);
            return booking.getId();
        } else {
            return -2;
        }
    }

    public Booking CancelRoom(int bookingNumber){
        canceledBookings.put(bookingNumber, bookings.get(bookingNumber));
        return bookings.remove(bookingNumber);
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
