package at.fhv.cqrs.events.listener;

import at.fhv.cqrs.events.Eventroot;

public interface IRoomBookedListener extends IHotelEventListener {

	void inform(Eventroot event);

}
