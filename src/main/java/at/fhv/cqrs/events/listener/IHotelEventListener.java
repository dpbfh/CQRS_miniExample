package at.fhv.cqrs.events.listener;

import at.fhv.cqrs.events.Eventroot;

public interface IHotelEventListener {
	void inform(Eventroot event);

}
