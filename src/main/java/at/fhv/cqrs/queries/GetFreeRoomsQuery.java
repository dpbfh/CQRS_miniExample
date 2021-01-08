package at.fhv.cqrs.queries;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class GetFreeRoomsQuery {
    private long from;
    private long to;
    private int guestcount;

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
        this.to = to;
    }

    public int getGuestcount() {
        return guestcount;
    }

    public void setGuestcount(int guestcount) {
        this.guestcount = guestcount;
    }
}
