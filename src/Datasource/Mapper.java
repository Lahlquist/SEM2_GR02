/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datasource;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import sem2_gr02.Gæst;
import sem2_gr02.Lejlighed;

/**
 *
 * @author Emilos
 */
public class Mapper
{

    private final Connection con;

    public Mapper(Connection con)
    {
        this.con = con;
    }

    //public List<Gæst> getGæster()
    public List<Gæst> getGæster()
    {
        Gæst gl = null;
        String SQLString =
                " select * from GAEST_TBL";
        PreparedStatement statement = null;
        List<Gæst> gæsteListe = new ArrayList<>();
        try
        {
            statement = con.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                String gaeid = rs.getString("GAEST_ID");
                String fnavn = rs.getString("FORNAVN_E");
                String enavn = rs.getString("EFTERNAVN");
                int telnu = rs.getInt("TELEFONNUMMER");
                String mail = rs.getString("E_MAIL");
                String vnavn = rs.getString("VEJNAVN");
                int vno = rs.getInt("VEJNUMMER");
                int pno = rs.getInt("POSTNUMMER");
                String bnavn = rs.getString("BYNAVN");
                String land = rs.getString("LAND");
                String rbu = rs.getString("REJSEBUREAU");
                gæsteListe.add(new Gæst(gaeid,fnavn,enavn,telnu,mail,vnavn,vno,pno,bnavn,land,rbu));
//          Gæsteliste.addRow(new Object[]{t1,t2,t3,t4,t5,t6,t7,t8,t9,t10});

            }

        } catch (SQLException e)
        {
            System.out.println("Fail in Mapper - getGæster");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try
            {
                if (statement != null)
                {
                    statement.close();
                }
            } catch (SQLException e)
            {
                System.out.println("Fail in Mapper - getGæster");
                System.out.println(e.getMessage());
            }
        }
        return gæsteListe;
    }
    
    
        public boolean createNewBooking(Gæst g)
    {
        int rowsInserted = 0;
        String SQLStringGæst = "insert into GAEST_TBL "
                + " values (?,?,?,?,?,?,?,?,?,?,?)";
//        String SQLStringLejlighed = "insert into LEJLIGHED_TBL "
//                + " values (?,?,?)";
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(SQLStringGæst);
            statement.setInt(1, 1413212);
            statement.setString(2,g.getFornavn() );
            statement.setString(3, g.getEfternavn());
            statement.setInt(4, g.getTelefonnummer());
            statement.setString(5, g.getEmail());
            statement.setString(6, g.getVejnavn());
            statement.setInt(7, g.getVejnummer());
            statement.setInt(8, g.getPostnummer());
            statement.setString(9, g.getBynavn());
            statement.setString(10, g.getLand());
            statement.setString(11, g.getRejsebureau());
            rowsInserted = statement.executeUpdate();

//            statement = con.prepareStatement(SQLStringLejlighed);
//            statement.set

        } catch (SQLException e)
        {
            System.out.println("Fejler i mapper - Create New Booking før close");
            System.out.println(e.getMessage());
        } finally
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fejler i mapper - Create New booking");
            }
        }
        return rowsInserted == 1;
    }

    public List<Lejlighed> getLejlighedsliste()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
