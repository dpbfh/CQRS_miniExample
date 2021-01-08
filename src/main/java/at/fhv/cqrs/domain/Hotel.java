package at.fhv.cqrs.domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Hotel {

	private HashMap<Integer,HotelRoom>  hotelRooms  = new HashMap<Integer,HotelRoom>();;
	private static Hotel instance;
	public static Hotel getHotel(){
		instance = (Hotel.instance == null) ? new Hotel() : instance; 
		return instance;
	} 

  
	

	public void addBaseRoom(HotelRoom room) {
		hotelRooms.put(room.getId(),room);
    }
    
	

}