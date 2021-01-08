package at.fhv.cqrs.domain.read;

import at.fhv.cqrs.domain.Booking;

import java.time.LocalDate;
import java.util.HashMap;


public class BookingRead {

    private final HashMap<Integer, Booking> bookings;
    private double priceTotal;

    public BookingRead(HashMap<Integer, Booking> bookings){
        this.bookings = bookings;
    }

    public HashMap<Integer, Booking> getBookings(LocalDate start, LocalDate end){
        HashMap<Integer, Booking> bookingsInThatTimeSpan = new HashMap<>();
        for(Booking booking : bookings.values()){
            if(booking.getBookedFrom().isAfter(start) ||booking.getBookedFrom().isEqual(start)){
                if(booking.getBookedFrom().isBefore(end) || booking.getBookedFrom().isEqual(end)){
                    bookingsInThatTimeSpan.put(booking.getId(),booking);
                }
            }
        }
        return bookingsInThatTimeSpan;
    }

}
