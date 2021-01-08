package at.fhv.cqrs.domain.read;

import at.fhv.cqrs.domain.Booking;
import at.fhv.cqrs.domain.HotelRoom;
import at.fhv.cqrs.domain.Person;

import java.time.*;
import java.util.List;

public class BookingRead {

    private Booking booking;
    private float priceTotal;
    private int roomNumber;
    private float roomPrice;
    private LocalDate bookedFrom;
    private LocalDate bookedUntil;
    private List<String> guests;
    private int id;

    public BookingRead(int bookingId, int roomNumber, float roomPrice, long bookedFrom, long bookedUntil, List<String> guests) {
        OffsetDateTime odt = OffsetDateTime.now ( ZoneId.systemDefault () );
        ZoneOffset zoneOffset = odt.getOffset ();
        this.bookedFrom = LocalDateTime.ofEpochSecond(bookedFrom, 0, zoneOffset).toLocalDate();
        this.bookedUntil = LocalDateTime.ofEpochSecond(bookedUntil, 0, zoneOffset).toLocalDate();
        this.id = bookingId;
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.priceTotal = roomPrice * Duration.between(this.bookedFrom.atStartOfDay(), this.bookedUntil.atStartOfDay()).toDays();;

    }

    public BookingRead(int bookingId, int roomNumber, float roomPrice, LocalDate bookedFrom, LocalDate bookedUntil, List<String> guests) {
        this.id = bookingId;
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.bookedFrom = bookedFrom;
        this.bookedUntil = bookedUntil;
        this.priceTotal = roomPrice * Duration.between(bookedFrom, bookedUntil).toDays();;
        this.guests = guests;
    }


    public boolean isBookingFree(LocalDate start, LocalDate end) {
        if (getBookedFrom().isAfter(start) || getBookedFrom().isEqual(start)) {
            return getBookedFrom().isBefore(end) || getBookedFrom().isEqual(end);
        }
        return false;
    }


    public int getId(){
        return id;
    }



    public float getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(float priceTotal) {
        this.priceTotal = priceTotal;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public float getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(float roomPrice) {
        this.roomPrice = roomPrice;
    }

    public LocalDate getBookedFrom() {
        return bookedFrom;
    }

    public void setBookedFrom(LocalDate bookedFrom) {
        this.bookedFrom = bookedFrom;
    }

    public LocalDate getBookedUntil() {
        return bookedUntil;
    }

    public void setBookedUntil(LocalDate bookedUntil) {
        this.bookedUntil = bookedUntil;
    }

    public List<String> getGuests() {
        return guests;
    }

    public void setGuests(List<String> guests) {
        this.guests = guests;
    }
}
