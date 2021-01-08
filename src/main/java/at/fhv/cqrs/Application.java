package at.fhv.cqrs;

import at.fhv.cqrs.commands.RoomCreateComand;
import at.fhv.cqrs.commands.controller.RoomService;
import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
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


        Micronaut.run(Application.class, args);

    }
}
