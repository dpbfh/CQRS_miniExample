package at.fhv.cqrs.events;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class HotelRoomCreated extends Eventroot{
    private float price;
    private int maxGuestcount;
    private int id;
    public HotelRoomCreated(int id){
        this.id = id;
    }
    public int getMaxGuestCount(){
        return maxGuestcount;
    }

    public void setMaxGuestCount(int maxGuestcount){
        this.maxGuestcount =  maxGuestcount;
    }

    public float getPrice(){
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public int getId(){
        return id;
    }
    
    @Override
    public String toString(){
        OffsetDateTime odt = OffsetDateTime.now ( ZoneId.systemDefault () );
        	ZoneOffset zoneOffset = odt.getOffset ();
        return "RoomCreateComand:  Id: "+ id + "Maximum "+maxGuestcount + " Guests" + " Costs: " + price +"€" + "Created at: " +  LocalDateTime.ofEpochSecond(this.getUnixTimestamp(), 0, zoneOffset);
    }
}