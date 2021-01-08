package at.fhv.cqrs.queries.controller;

import at.fhv.cqrs.domain.read.BookingRead;
import at.fhv.cqrs.domain.read.HotelReadRepository;
import at.fhv.cqrs.domain.read.HotelReadRoom;
import at.fhv.cqrs.queries.GetBookingQuery;
import at.fhv.cqrs.queries.GetFreeRoomsQuery;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Collection;
import java.util.List;

public class Queryservice {
    public static List<BookingRead> getBookingReads(GetBookingQuery bookingQuery){
        OffsetDateTime odt = OffsetDateTime.now ( ZoneId.systemDefault () );
        ZoneOffset zoneOffset = odt.getOffset();
        return HotelReadRepository.getInstance().getBookings(LocalDateTime.ofEpochSecond(bookingQuery.getFrom(), 0, zoneOffset).toLocalDate(),LocalDateTime.ofEpochSecond(bookingQuery.getTo(), 0, zoneOffset).toLocalDate());
    }

    public static Collection<HotelReadRoom> getFreeRooms(GetFreeRoomsQuery freeRoomsQuery){
        OffsetDateTime odt = OffsetDateTime.now ( ZoneId.systemDefault () );
        ZoneOffset zoneOffset = odt.getOffset();
        return HotelReadRepository.getInstance().getFreeRooms(LocalDateTime.ofEpochSecond(freeRoomsQuery.getFrom(), 0, zoneOffset).toLocalDate(),LocalDateTime.ofEpochSecond(freeRoomsQuery.getTo(), 0, zoneOffset).toLocalDate(), freeRoomsQuery.getGuestcount());
    }

}
