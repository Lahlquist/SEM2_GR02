/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sem2_gr02;

import Datasource.*;
import java.util.List;

/**
 *
 * @author Emilos
 */
public class Controller
{

    DBFacade facade = new DBFacade();
    private List<Gæst> currentgListe;
    private List<Lejlighed> currentlListe;
    private Gæst gæst;

    public Controller()
    {
        currentgListe = null;
        currentlListe = null;
        gæst = null;
    }

    public List<Gæst> getGæsteListe()
    {
        currentgListe = facade.getGæsteListe();
        return currentgListe;
    }

    public Gæst createNewBooking(String gaeid, String fnavn, String enavn, int telnu, String mail, String vnavn, int vno, int pno, String bnavn, String land, String rbu)
    {
        gæst = new Gæst(gaeid, fnavn, enavn, telnu, mail, vnavn, vno, pno, bnavn, land, rbu);
        boolean status = facade.createNewBooking(gæst);
        if (!status);
        {
            gæst = null;
        }
        return gæst;
    }
    
    public List<Lejlighed> getLejlighedliste()
    {
        currentlListe= facade.getLejlighedsliste();
        return currentlListe;
    }
//    public String getGæsteListeToString() {
//    if (currentgListe != null) {
//      return "";//currentgListe.detailsToString();
//    } else {
//      return null;
//    }
//  }
}
