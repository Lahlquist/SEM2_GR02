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
                int gæid = rs.getInt("GAEST_ID");
                int boid = rs.getInt("BOOKING_ID");
                String fnavn = rs.getString("FORNAVN_E");
                String enavn = rs.getString("EFTERNAVN");
                String land = rs.getString("LAND");
                int telnu = rs.getInt("TELEFONNUMMER");
                String email = rs.getString("E_MAIL");
                String rbu = rs.getString("REJSEBUREAU");
                String checkind = rs.getString("CHECK_IN_DATO");
                String checkud = rs.getString("CHECK_OUT_DATO");
                int antnæ = rs.getInt("ANTAL_NAETTER");
                gæsteListe.add(new Gæst(gæid, boid, fnavn, enavn, land, telnu, email, rbu, checkind, checkud, antnæ));
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
            statement.setInt(1, 213322);
            statement.setInt(2, 202020);
            statement.setString(3, g.getFornavn());
            statement.setString(4, g.getEfternavn());
            statement.setString(5, g.getLand());
            statement.setInt(6, g.getTelefonnummer());
            statement.setString(7, g.getEmail());
            statement.setString(8, "wer");
            statement.setDate(9, null);
            statement.setDate(10, null);
            statement.setInt(11, g.getNætter());
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
}
