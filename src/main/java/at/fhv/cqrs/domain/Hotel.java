package at.fhv.cqrs.domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Hotel {

	private HashMap<Integer,HotelRoom>  _hotelRooms  = new HashMap<Integer,HotelRoom>();;
	private static Hotel instance;

	public static Hotel getHotel(){
		instance = (Hotel.instance == null) ? new Hotel() : instance; 
		return instance;
	}
	

	public void addBaseRoom(HotelRoom room) {
		_hotelRooms.put(room.getId(),room);
    }


	public HashMap<Integer, HotelRoom> getHotelRooms() {
		return _hotelRooms;
	}

	public void setHotelRooms(HashMap<Integer, HotelRoom> hotelRooms) {
		_hotelRooms = hotelRooms;
	}

	public static Hotel getInstance() {
		return instance;
	}

	public static void setInstance(Hotel instance) {
		Hotel.instance = instance;
	}
}