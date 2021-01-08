package at.fhv.cqrs.commands.controller;

import at.fhv.cqrs.commands.BookroomCommand;
import at.fhv.cqrs.domain.HotelManager;
import at.fhv.cqrs.events.Eventhandler;
import at.fhv.cqrs.events.RoomBooked;

import java.time.*;
import java.util.Collections;
import java.util.UUID;

public class BookingService{

    public int bookRoom(BookroomCommand cmd){
        var manager = HotelManager.getHotelManager();
        OffsetDateTime odt = OffsetDateTime.now ( ZoneId.systemDefault () );
        ZoneOffset zoneOffset = odt.getOffset ();

        int id =  manager.BookRoom(cmd.getRoomNumber(), cmd.getGuests(), LocalDateTime.ofEpochSecond(cmd.getBookedFrom(), 0, zoneOffset).toLocalDate(),LocalDateTime.ofEpochSecond(cmd.getBookedUntil(), 0, zoneOffset).toLocalDate());

        if (id > 0) {
            RoomBooked event = new RoomBooked(id);
            event.setBookedFrom(cmd.getBookedFrom());
            event.setBookedUntil(cmd.getBookedUntil());
            event.setGuests(Collections.unmodifiableList(cmd.getGuests()));
            event.setUnixTimestamp(Instant.now().getEpochSecond());
            event.setTransactionId(UUID.randomUUID());

            //Eventhandler
            Eventhandler.addEvent(event);
        }


        return id;
    }
}
