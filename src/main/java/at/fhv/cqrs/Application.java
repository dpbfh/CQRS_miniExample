package at.fhv.cqrs;

import at.fhv.cqrs.commands.BookroomCommand;
import at.fhv.cqrs.commands.CancleBookingCommand;
import at.fhv.cqrs.commands.RoomCreateComand;
import at.fhv.cqrs.commands.controller.BookingService;
import at.fhv.cqrs.commands.controller.RoomService;
import at.fhv.cqrs.domain.Person;
import at.fhv.cqrs.events.Eventhandler;
import at.fhv.cqrs.events.listener.Listener;
import at.fhv.cqrs.queries.GetBookingQuery;
import at.fhv.cqrs.queries.GetFreeRoomsQuery;
import at.fhv.cqrs.queries.controller.Queryservice;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "CQRS",
                version = "0.0",
                description = "CQRS"
        )
)
public class Application {

    public static void main(String[] args) {
        Eventhandler.subscribe(new Listener());
        RoomService rs = new RoomService();
        RoomCreateComand cmd1 = new RoomCreateComand();
        cmd1.setMaxGuestCount(2);
        cmd1.setPrice(15);
        rs.createRoom(cmd1);

        RoomCreateComand cmd2 = new RoomCreateComand();
        cmd2.setMaxGuestCount(2);
        cmd2.setPrice(55);
        rs.createRoom(cmd2);

        RoomCreateComand cmd3 = new RoomCreateComand();
        cmd3.setMaxGuestCount(4);
        cmd3.setPrice(85);
        rs.createRoom(cmd3);

        RoomCreateComand cmd4 = new RoomCreateComand();
        cmd4.setMaxGuestCount(1);
        cmd4.setPrice(35);
        rs.createRoom(cmd4);

        RoomCreateComand cmd5 = new RoomCreateComand();
        cmd5.setMaxGuestCount(6);
        cmd5.setPrice(250);
        rs.createRoom(cmd5);

//        BookingService bookingService = new BookingService();
//        BookroomCommand bcmd = new BookroomCommand();
//
//        bcmd.setBookedFrom(LocalDate.of(2021,4,20).atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond());
//        bcmd.setBookedUntil(LocalDate.of(2021,5,20).atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond());
//        bcmd.setRoomNumber(1);
//        bcmd.setGuests(List.of(new Person("Dezpot","PITCHNOW", LocalDate.of(2020,4,20))));
//        System.out.println(bookingService.bookRoom(bcmd));
//
//        BookroomCommand bcmd1 = new BookroomCommand();
//        bcmd1.setBookedFrom(LocalDate.of(2021,4,2).atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond());
//        bcmd1.setBookedUntil(LocalDate.of(2021,6,20).atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond());
//        bcmd1.setRoomNumber(1);
//        bcmd1.setGuests(List.of(new Person("Dominik","Pöckle>", LocalDate.of(2020,4,20))));
//        System.out.println(bookingService.bookRoom(bcmd1));
//
//
//        CancleBookingCommand cmd = new CancleBookingCommand();
//        cmd.setBookingNumber(1);
//        bookingService.canclebooking(cmd);
//        System.out.println(bookingService.bookRoom(bcmd1));
//
//
//        System.out.println("==============================================================");
//        var query1 = new GetBookingQuery();
//        query1.setFrom(LocalDate.of(2000,4,2).atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond());
//        query1.setTo(          LocalDate.of(2090,4,2).atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond());
//        System.out.println(Queryservice.getBookingReads(query1));
//        System.out.println("==============================================================");
//
//        System.out.println("==============================================================");
//        var query2 = new GetFreeRoomsQuery();
//        query2.setFrom(LocalDate.of(2000,4,2).atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond());
//        query2.setTo(LocalDate.of(2090,4,2).atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond());
//        query2.setGuestcount(6);
//        System.out.println(Queryservice.getFreeRooms(query2).size());
//        System.out.println("==============================================================");

        Micronaut.run(Application.class, args);

    }
}
