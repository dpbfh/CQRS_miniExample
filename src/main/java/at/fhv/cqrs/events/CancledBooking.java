package at.fhv.cqrs.events;

import java.time.LocalDate;

public class CancledBooking extends Eventroot {
    private LocalDate bookedFrom;
    private LocalDate bookeduntil;
    private int roomnumber;
    private int bookingnumber;
    public CancledBooking(LocalDate bookedFrom, LocalDate bookeduntil,
             int roomnumber,
             int bookingnumber){
        this.bookedFrom= bookedFrom;
        this.bookeduntil=bookeduntil;
        this.roomnumber=roomnumber;
        this.bookingnumber=bookingnumber;

    }
    public LocalDate getBookedFrom() {
        return bookedFrom;
    }

    public LocalDate getBookeduntil() {
        return bookeduntil;
    }

    public int getRoomnumber() {
        return roomnumber;
    }

    public int getBookingnumber() {
        return bookingnumber;
    }
}
