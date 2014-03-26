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
    private Gæst gæst;

    public Controller()
    {
        currentgListe = null;
        gæst = null;
    }

    public List<Gæst> getGæsteListe()
    {
        currentgListe = facade.getGæsteListe();
        return currentgListe;
    }

    public Gæst createNewBooking(int gæid, int boid, String fnavn, String enavn, String land, int telnu, String eail, String rbu, String checkda, int antnæ)
    {
        gæst = new Gæst (gæid,boid,fnavn, enavn,land,telnu,eail,rbu,checkda, antnæ);
        boolean status = facade.createNewBooking(gæst);
        if (!status);
        {
            gæst = null;
        }
        return gæst;
    }
//    public String getGæsteListeToString() {
//    if (currentgListe != null) {
//      return "";//currentgListe.detailsToString();
//    } else {
//      return null;
//    }
//  }
}
