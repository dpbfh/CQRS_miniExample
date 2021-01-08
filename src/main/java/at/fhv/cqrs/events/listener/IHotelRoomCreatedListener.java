package at.fhv.cqrs.events.listener;

import at.fhv.cqrs.events.Eventroot;

public interface IHotelRoomCreatedListener extends IHotelEventListener {

	void inform(Eventroot event);

}
