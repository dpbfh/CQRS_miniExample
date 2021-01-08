package at.fhv.cqrs.commands.controller;

import java.time.Instant;
import java.util.UUID;

import at.fhv.cqrs.commands.RoomCreateComand;
import at.fhv.cqrs.domain.Hotel;
import at.fhv.cqrs.domain.HotelRoom;
import at.fhv.cqrs.events.*;

public class RoomService{
    public void createRoom( RoomCreateComand cmd){
        var room = new HotelRoom();
        room.setMaxGuestCount(cmd.getMaxGuestCount());
        room.setPrice(cmd.getPrice());
        Hotel.getHotel().addBaseRoom(room);

        HotelRoomCreated event = new HotelRoomCreated(room.getId());
        event.setMaxGuestCount(room.getMaxGuestCount());
        event.setUnixTimestamp(Instant.now().getEpochSecond());
        event.setPrice(room.getPrice());
        event.setTransactionId(UUID.randomUUID());

        //Eventhandler
        Eventhandler.addEvent(event);
    }
}