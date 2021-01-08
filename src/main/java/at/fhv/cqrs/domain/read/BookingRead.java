package at.fhv.cqrs.domain.read;

import at.fhv.cqrs.domain.Booking;

import java.time.Duration;
import java.time.LocalDate;

public class BookingRead {

    private Booking booking;
    private float priceTotal;

    public BookingRead(Booking booking) {
        this.booking = booking;
        this.priceTotal = (int)booking.getRoom().getPrice() * Duration.between(booking.getBookedFrom(), booking.getBookedUntil()).toDays();;
    }


    public boolean isBookingFree(LocalDate start, LocalDate end) {
        if (booking.getBookedFrom().isAfter(start) || booking.getBookedFrom().isEqual(start)) {
            return booking.getBookedFrom().isBefore(end) || booking.getBookedFrom().isEqual(end);
        }
        return false;
    }


}
