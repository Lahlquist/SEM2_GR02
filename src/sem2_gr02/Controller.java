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
    

    public Controller()
    {
        currentgListe = null;
    }
    
    public List<Gæst> getGæsteListe()
    {
        currentgListe = facade.getGæsteListe();
        return currentgListe;
    }
    
//    public String getGæsteListeToString() {
//    if (currentgListe != null) {
//      return "";//currentgListe.detailsToString();
//    } else {
//      return null;
//    }
//  }


}
