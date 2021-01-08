package at.fhv.cqrs.commands;

public class RoomCreateComand {
    private float price;
    private int maxGuestcount;

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

}