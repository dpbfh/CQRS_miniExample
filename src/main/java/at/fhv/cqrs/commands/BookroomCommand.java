package at.fhv.cqrs.commands;

import at.fhv.cqrs.domain.Person;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema
public class BookroomCommand {
    private int roomNumber;

    @Schema
    private List<Person> guests;

    private long bookedFrom; 
    private long bookedUntil;

    @Schema
    public int getRoomNumber(){
        return roomNumber;
    }

    @Schema
    public List<Person> getGuests(){
        return guests;
    }

    @Schema
    public long getBookedFrom(){
        return bookedFrom;
    }

    @Schema
    public long getBookedUntil(){
        return bookedUntil;
    }

    @Schema
    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }

    @Schema
    public void setGuests(List<Person>  guests){
        this.guests = guests;
    }

    @Schema
    public  void setBookedFrom(long bookedFrom){
        this.bookedFrom = bookedFrom;
    }

    @Schema
    public void setBookedUntil(long bookedUntil){
        this.bookedUntil = bookedUntil;
    }
}
