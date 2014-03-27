/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sem2_gr02;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emilos
 */
public class Lejlighed
{
    private int Lejlighed_id;
    private String Lejlighed_type;
    private String Status;
    private int Booking_id;
    private String check_in_date;
    private String check_out_date;
    private List<Lejlighed> lejlighedliste;
    
    
    public Lejlighed(int Lid,String Let,String status,int Booid, String cid, String cod)
    {
        Lejlighed_id = Lid;
        Lejlighed_type= Let;
        Status = status;
        Booking_id = Booid;
        check_in_date = cid;
        check_out_date = cod;
        lejlighedliste = new ArrayList<Lejlighed>();
    }

    public int getLejlighed_id()
    {
        return Lejlighed_id;
    }

    public void setLejlighed_id(int Lejlighed_id)
    {
        this.Lejlighed_id = Lejlighed_id;
    }

    public String getLejlighed_type()
    {
        return Lejlighed_type;
    }

    public void setLejlighed_type(String Lejlighed_type)
    {
        this.Lejlighed_type = Lejlighed_type;
    }

    public String getStatus()
    {
        return Status;
    }

    public void setStatus(String Status)
    {
        this.Status = Status;
    }

    public int getBooking_id()
    {
        return Booking_id;
    }

    public void setBooking_id(int Booking_id)
    {
        this.Booking_id = Booking_id;
    }

    public String getCheck_in_date()
    {
        return check_in_date;
    }

    public void setCheck_in_date(String check_in_date)
    {
        this.check_in_date = check_in_date;
    }

    public String getCheck_out_date()
    {
        return check_out_date;
    }

    public void setCheck_out_date(String check_out_date)
    {
        this.check_out_date = check_out_date;
    }

    public void addLejlighed(Lejlighed l1)
    {
        lejlighedliste.add(l1);
    }


}
