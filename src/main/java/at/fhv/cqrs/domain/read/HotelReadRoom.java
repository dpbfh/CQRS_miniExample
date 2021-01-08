package at.fhv.cqrs.domain.read;

import at.fhv.cqrs.domain.Booking;
import at.fhv.cqrs.domain.Hotel;
import at.fhv.cqrs.domain.HotelManager;
import at.fhv.cqrs.domain.HotelRoom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class HotelReadRoom {
    private HotelRoom room;
    private List<TimeSpan> timeSpans;


    public HotelReadRoom(HotelRoom room){
        this.room = room;
    }

    public void cancelBooking(LocalDate start, LocalDate end){
        timeSpans.removeIf(timeSpan -> timeSpan.start == start && timeSpan.end == end);
    }


    private class TimeSpan {
        final LocalDate start;
        final LocalDate end;
        TimeSpan(LocalDate start, LocalDate end) throws Exception {
            if(start.isBefore(end)) {
                this.start = start;
                this.end = end;
            } else throw new Exception("Start date is after end date");
        }
    }

    public boolean isRoomFree(LocalDate bookedFrom, LocalDate bookedUntil, int numberOfGuests){
        if(bookedFrom.isAfter(bookedUntil)){
            return false;
        }
        if(numberOfGuests <= room.getMaxGuestCount()){
            for (TimeSpan timeSpan : timeSpans){
                if(bookedUntil.isAfter(timeSpan.start) && bookedUntil.isBefore(timeSpan.end)){
                    if(bookedFrom.isAfter(timeSpan.start) && bookedFrom.isBefore(timeSpan.end)){
                        return false;
                    }
                }
            }
        }
        return true;
    }


    /*

    /**
     * Gets the bookings if the starting date of the booking is on or inbeetween the timespan
     * @param bookedFrom start of the timespan
     * @param bookedUntil end of the timespan
     * @return the list of bookings in this specific timespan.
     */
    /*
    public List<Booking> getBookings(LocalDate bookedFrom, LocalDate bookedUntil){
        List<Booking> bookingsInThatTimeSpan = new LinkedList<>();
        for(Booking booking : HotelManager.getHotelManager().getBookings()){
            if(booking.getBookedFrom().isAfter(bookedFrom) ||booking.getBookedFrom().isEqual(bookedFrom)){
                if(booking.getBookedFrom().isBefore(bookedUntil) || booking.getBookedFrom().isEqual(bookedUntil)){
                    bookingsInThatTimeSpan.add(booking);
                }
            }
        }
        return bookingsInThatTimeSpan;
    }

    public List<HotelRoom> getFreeRoomsWithGuests(LocalDate bookedFrom, LocalDate bookedUntil, int numberOfGuests){
        List<HotelRoom> freeRooms = getFreeRooms(bookedFrom, bookedUntil);
        List<HotelRoom> fittingRooms = new LinkedList<>();

        for(HotelRoom room : freeRooms){
            if(numberOfGuests <= room.getMaxGuestCount()){
                fittingRooms.add(room);
            }
        }
        return fittingRooms;
    }


    private List<HotelRoom> getFreeRooms(LocalDate bookedFrom, LocalDate bookedUntil){
        HashMap roomsAsHashTable = Hotel.getHotel().getHotelRooms();
        List<HotelRoom> freeRooms = new ArrayList<HotelRoom>(roomsAsHashTable.values());

        for(Booking booking : HotelManager.getHotelManager().getBookings()){
            if(booking.getBookedFrom().isAfter(bookedFrom) ||booking.getBookedFrom().isEqual(bookedFrom)){
                if(booking.getBookedFrom().isBefore(bookedUntil) || booking.getBookedFrom().isEqual(bookedUntil)){
                    freeRooms.remove(booking.getRoom());
                }
            }
        }
        return freeRooms;
    }
    */
}
