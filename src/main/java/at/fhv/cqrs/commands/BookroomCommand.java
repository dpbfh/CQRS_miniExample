package at.fhv.cqrs.commands;

import at.fhv.cqrs.domain.Person;

import java.util.List;

public class BookroomCommand {
    private int roomNumber; 
    private List<Person> guests;
    private long bookedFrom; 
    private long bookedUntil; 
    
    public int getRoomNumber(){
        return roomNumber;
    }

    public List<Person> getGuests(){
        return guests;
    }

    public long getBookedFrom(){
        return bookedFrom;
    }

    public long getBookedUntil(){
        return bookedUntil;
    }


    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }

    public void setGuests(List<Person>  guests){
        this.guests = guests;
    }

    public  void setBookedFrom(long bookedFrom){
        this.bookedFrom = bookedFrom;
    }

    public void setBookedUntil(long bookedUntil){
        this.bookedUntil = bookedUntil;
    }
}
