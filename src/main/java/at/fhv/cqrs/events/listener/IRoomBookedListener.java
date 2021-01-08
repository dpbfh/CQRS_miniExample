package at.fhv.cqrs.events.listener;

import at.fhv.cqrs.events.Eventroot;
import at.fhv.cqrs.events.RoomBooked;

public interface IRoomBookedListener extends IHotelEventListener {

	void informRoomBooked(RoomBooked event);

}
