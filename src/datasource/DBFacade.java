
package datasource;
import domain.Lejlighed;
import domain.Booking;
import domain.Gaest;
import java.util.ArrayList;
import java.util.List;


public class DBFacade
{
    private final Mapper mapp;
    public DBFacade()
    {
        mapp = new Mapper(DBConnector.getConnection());
    }
    
    public List<Gaest> getGaesteListe()
    {
        return mapp.getGaester();
    }
    
    public boolean createNewBooking(Gaest g)
    {
        return mapp.createNewBooking(g);
    }
    
    public List<Lejlighed> getLejlighedliste()
    {
        return mapp.getLejlighedsliste();
    }
    

    public List<Lejlighed> getLejlighedsliste()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // ANDERS - NYT 
    
    public ArrayList<Booking> getRoomsList(String x, String y) {
        return mapp.getRooms(x, y);
    }
}
