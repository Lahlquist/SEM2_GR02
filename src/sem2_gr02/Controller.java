
package sem2_gr02;

import Datasource.*;
import java.util.ArrayList;
import java.util.List;

public class Controller
{

    DBFacade facade = new DBFacade();
    private List<Gaest> currentgListe;
    private List<Lejlighed> currentlListe;
    private Gaest gæst;
    //TEST
    private ArrayList<Booking> currentARListe;

    public Controller()
    {
        currentgListe = null;
        currentlListe = null;
        gæst = null;
       
        //TEST
        currentARListe = null;
        
    }

    public List<Gaest> getGaesteListe()
    {
        currentgListe = facade.getGæsteListe();
        return currentgListe;
    }

    public Gaest createNewBooking(String gaeid, String fnavn, String enavn, int telnu, String mail, String vnavn, int vno, int pno, String bnavn, String land, String rbu)
    {
        gæst = new Gaest(gaeid, fnavn, enavn, telnu, mail, vnavn, vno, pno, bnavn, land, rbu);
        boolean status = facade.createNewBooking(gæst);
        if (!status);
        {
            gæst = null;
        }
        return gæst;
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
