package at.fhv.cqrs.commands;

import at.fhv.cqrs.domain.Person;

import java.util.List;

public class CancleBookingCommand {
    private int bookingNumber;

    public int getBookingNumber(){
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber){
        this.bookingNumber = bookingNumber;
    }

}
