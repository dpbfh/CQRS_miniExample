package at.fhv.cqrs.events.listener;

import at.fhv.cqrs.events.CancledBooking;
import at.fhv.cqrs.events.Eventroot;

public interface ICancledBookingListener extends IHotelEventListener {

	void informCancledBookingListener(CancledBooking event);

}
