package at.fhv.cqrs.events.listener;

import at.fhv.cqrs.domain.HotelRoom;
import at.fhv.cqrs.domain.read.BookingRead;
import at.fhv.cqrs.domain.read.HotelReadRepository;
import at.fhv.cqrs.domain.read.HotelReadRoom;
import at.fhv.cqrs.events.CancledBooking;
import at.fhv.cqrs.events.Eventroot;
import at.fhv.cqrs.events.HotelRoomCreated;
import at.fhv.cqrs.events.RoomBooked;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.LinkedList;
import java.util.List;

public class Listener implements IRoomBookedListener,IHotelRoomCreatedListener,ICancledBookingListener{

    @Override
    public void informCancledBookingListener(CancledBooking event) {
        var room = HotelReadRepository.getInstance().getRoombyID(event.getRoomnumber());
        if(room != null) {
            room.cancelBooking(event.getBookedFrom(),event.getBookeduntil());
        }
        HotelReadRepository.getInstance().cancleBooking(event.getBookingnumber());
        System.out.println(event);
    }

    @Override
    public void informHotelRoomCreated(HotelRoomCreated event) {

        HotelReadRoom readRoom = new HotelReadRoom();
        readRoom.setMaxGuestCount(event.getMaxGuestCount());
        readRoom.setPrice(event.getPrice());
        readRoom.setId(event.getId());
        HotelReadRepository.getInstance().addHotelReadRoom(readRoom);
        System.out.println(event);
    }

    @Override
    public void inform(Eventroot event) {

    }

    @Override
    public void informRoomBooked(RoomBooked event) {
        var room = HotelReadRepository.getInstance().getRoombyID(event.getRoomNumber());
        if(room != null){
            OffsetDateTime odt = OffsetDateTime.now ( ZoneId.systemDefault () );
            ZoneOffset zoneOffset = odt.getOffset ();
            room.addBooking(LocalDateTime.ofEpochSecond(event.getBookedFrom(), 0, zoneOffset).toLocalDate(),LocalDateTime.ofEpochSecond(event.getBookedUntil(), 0, zoneOffset).toLocalDate());
            System.out.println(event);
        }
        List<String> stringList = new LinkedList<>();
        for (var g : event.getGuests()) {
            stringList.add( g.toString());
        }
        BookingRead bookingRead = new BookingRead(event.getId(),event.getRoomNumber(),event.getRoomPrice(), event.getBookedFrom(),event.getBookedUntil(),stringList);
        HotelReadRepository.getInstance().addBookingRead(bookingRead);
    }

}
