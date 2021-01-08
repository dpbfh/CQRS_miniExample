package at.fhv.cqrs.events.listener;

import at.fhv.cqrs.events.Eventroot;
import at.fhv.cqrs.events.HotelRoomCreated;

public interface IHotelRoomCreatedListener extends IHotelEventListener {

	void informHotelRoomCreated(HotelRoomCreated event);

}
