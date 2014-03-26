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
    private Booking booking;

    public Controller()
    {
        currentgListe = null;
        booking = null;
    }

    public List<Gæst> getGæsteListe()
    {
        currentgListe = facade.getGæsteListe();
        return currentgListe;
    }

    public Booking createNewBooking(String fnavn, String enavn, String land, String email, int tlfno, int nætter)
    {
        booking = new Booking(0, fnavn, enavn, land, email, tlfno, nætter);
        boolean status = facade.createNewBooking(booking);
        if (!status);
        {
            booking = null;
        }
        return booking;
    }
//    public String getGæsteListeToString() {
//    if (currentgListe != null) {
//      return "";//currentgListe.detailsToString();
//    } else {
//      return null;
//    }
//  }
}
