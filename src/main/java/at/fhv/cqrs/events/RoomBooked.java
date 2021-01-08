package at.fhv.cqrs.events;

import at.fhv.cqrs.domain.Person;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

public class RoomBooked extends Eventroot{
    private int id;
    public RoomBooked(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

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

    @Override
    public String toString(){
        OffsetDateTime odt = OffsetDateTime.now ( ZoneId.systemDefault () );
        ZoneOffset zoneOffset = odt.getOffset ();
        return "BookedRoomEvent:  BookingNumber: "+ id + " RoomNr." + roomNumber +
                "\n Guests:  " +  guests +
                "\n Booked from: "+ LocalDateTime.ofEpochSecond(bookedFrom, 0, zoneOffset) +
                "\n Booked until: " +LocalDateTime.ofEpochSecond(bookedUntil, 0, zoneOffset) ;
    }
}
