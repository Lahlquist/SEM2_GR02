/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datasource;
import java.util.List;
import sem2_gr02.*;
/**
 *
 * @author Emilos
 */
public class DBFacade
{
    private final Mapper mapp;
    public DBFacade()
    {
        mapp = new Mapper(DBConnector.getConnection());
    }
    
    public List<Gæst> getGæsteListe()
    {
        return mapp.getGæster();
    }
//    
//    public Gæst getGæst()
//    {
//        return mapp.getGæste();
//    }


}
