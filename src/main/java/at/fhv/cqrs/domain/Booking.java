package at.fhv.cqrs.domain;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;

public class Booking {

    private HotelRoom room;
    private List<Person> guests;
    private LocalDate bookedFrom;
    private LocalDate bookedUntil;

    public Booking(HotelRoom room, List<Person> guests, LocalDate bookedFrom, LocalDate bookedUntil){
        this.room = room;
        this.guests = guests;
        this.bookedFrom = bookedFrom;
        this.bookedUntil = bookedUntil;
    }
}
