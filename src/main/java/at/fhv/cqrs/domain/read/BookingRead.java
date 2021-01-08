package at.fhv.cqrs.domain.read;

import at.fhv.cqrs.domain.Booking;

import java.time.Duration;
import java.time.LocalDate;

public class BookingRead {

    private Booking booking;
    private float priceTotal;

    public BookingRead(Booking booking, float priceTotal) {
        this.booking = booking;
        this.priceTotal = priceTotal;
    }

    public BookingRead getFreeBooking(LocalDate start, LocalDate end){
        if(isBookingFree(start,end)){
            float priceTotal = (int)booking.getRoom().getPrice() * Duration.between(start, end).toDays();
            return new BookingRead(booking, priceTotal);
        }
        return null;
    }

    public boolean isBookingFree(LocalDate start, LocalDate end) {
        if (booking.getBookedFrom().isAfter(start) || booking.getBookedFrom().isEqual(start)) {
            return booking.getBookedFrom().isBefore(end) || booking.getBookedFrom().isEqual(end);
        }
        return false;
    }


}
