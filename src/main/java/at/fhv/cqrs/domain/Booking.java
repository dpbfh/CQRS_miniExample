package at.fhv.cqrs.domain;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;
public class Booking {

    private HotelRoom room;
    private List<Person> guests;
    private LocalDate bookedFrom;
    private LocalDate bookedUntil;
    private static int lastID = 0;
    private int id;

    public Booking(HotelRoom room, List<Person> guests, LocalDate bookedFrom, LocalDate bookedUntil){
        id = ++Booking.lastID;
        this.room = room;
        this.guests = guests;
        this.bookedFrom = bookedFrom;
        this.bookedUntil = bookedUntil;
    }

    public HotelRoom getRoom() {
        return room;
    }

    public void setRoom(HotelRoom room) {
        this.room = room;
    }

    public List<Person> getGuests() {
        return guests;
    }

    public void setGuests(List<Person> guests) {
        this.guests = guests;
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

    public int getId() {
        return id;
    }


}
