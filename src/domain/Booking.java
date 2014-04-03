package domain;

/**
 * Semesterprojekt - "Casablanca Holiday Center"
 * 2. semester 2014
 * 
 * Udarbejdet af:
 * Emil, Anders, Søren og Laura
 * 
 * Torsdag den 1. maj 2014 #Part 1
 */

public class Booking
{
    String booking_id;
    int lejlighed_id;
    String checkIn;
    String checkUd;
    
    public Booking(String booking_id, int lejlighed_id, String checkIn, String checkUd)
    {
    this.booking_id    = booking_id;
    this.lejlighed_id  = lejlighed_id;
    this.checkIn       = checkIn;
    this.checkUd       = checkUd;    
    }

    public String getBooking_id() {
        return booking_id;
    }

    public int getLejlighed_id() {
        return lejlighed_id;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckUd() {
        return checkUd;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }

    public void setLejlighed_id(int lejlighed_id) {
        this.lejlighed_id = lejlighed_id;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckUd(String checkUd) {
        this.checkUd = checkUd;
    }
    
    
    
}
