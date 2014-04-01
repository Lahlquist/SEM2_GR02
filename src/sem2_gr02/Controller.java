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
    private List<Gaest> currentgListe;
    private List<Lejlighed> currentlListe;
    private Gaest gaest;

    public Controller()
    {
        currentgListe = null;
        currentlListe = null;
        gaest = null;
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
