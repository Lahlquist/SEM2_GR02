
package domain;

import datasource.DBFacade;
import java.util.ArrayList;
import java.util.List;

public class Controller
{

    DBFacade facade = new DBFacade();
    private List<Gaest> currentgListe;
    private List<Lejlighed> currentlListe;
    private Gaest gaest;
    //TEST
    private ArrayList<Booking> currentARListe;

    public Controller()
    {
        currentgListe = null;
        currentlListe = null;
        gaest = null;
       
        //TEST
        currentARListe = null;
        
    }

    public List<Gaest> getGaesteListe()
    {
        currentgListe = facade.getGaesteListe();
        return currentgListe;
    }

    public Gaest createNewBooking(String gaeid, String fnavn, String enavn, int telnu, String mail, String vnavn, int vno, int pno, String bnavn, String land, String rbu)
    {
        gaest = new Gaest(gaeid, fnavn, enavn, telnu, mail, vnavn, vno, pno, bnavn, land, rbu);
        boolean status = facade.createNewBooking(gaest);
        if (!status);
        {
            gaest = null;
        }
        return gaest;
    }
    
    public List<Lejlighed> getLejlighedliste()
    {
        currentlListe = facade.getLejlighedsliste();
        return currentlListe;
    }

    // ANDERS - NYT
    
    
    // antal lejligheder ledige i given periode.
    public int getRoomsList(String x, String y) {
        currentARListe = facade.getRoomsList(x,y);
        int rooms = currentARListe.size();
        
        return rooms;
    }
    
    
    
}
