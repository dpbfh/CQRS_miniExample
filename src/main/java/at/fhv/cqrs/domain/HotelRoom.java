package at.fhv.cqrs.domain;

public class HotelRoom{
    private static int lastID = 0;
    private int id;
    private float price;
    private int maxGuestcount;
    
    public HotelRoom(){
        id = ++HotelRoom.lastID;
    }

    public HotelRoom(float price, int maxGuestcount){
            super();
            this.price = price;
            this.maxGuestcount = maxGuestcount;
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
}