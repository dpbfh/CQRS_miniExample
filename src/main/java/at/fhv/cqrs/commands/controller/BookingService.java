package at.fhv.cqrs.commands.controller;

import at.fhv.cqrs.commands.BookroomCommand;
import at.fhv.cqrs.commands.CancleBookingCommand;
import at.fhv.cqrs.domain.HotelManager;
import at.fhv.cqrs.domain.read.HotelReadRepository;
import at.fhv.cqrs.events.CancledBooking;
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
            event.setRoomPrice(HotelReadRepository.getInstance().getRoombyID(cmd.getRoomNumber()).getPrice());
            event.setRoomNumber(cmd.getRoomNumber());
            event.setUnixTimestamp(Instant.now().getEpochSecond());
            event.setTransactionId(UUID.randomUUID());

            //Eventhandler
            Eventhandler.addEvent(event);
        }


        return id;
    }

    public void canclebooking(CancleBookingCommand cmd) throws Exception {
        var manager = HotelManager.getHotelManager();
        var booking = manager.CancelRoom(cmd.getBookingNumber());
        if (booking != null) {
            CancledBooking event = new CancledBooking(booking.getBookedFrom(),booking.getBookedUntil(),booking.getRoom().getId(),booking.getId());
            event.setUnixTimestamp(Instant.now().getEpochSecond());
            event.setTransactionId(UUID.randomUUID());

            //Eventhandler
            Eventhandler.addEvent(event);
        }else{
            throw new Exception();
        }

    }
}
