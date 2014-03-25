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
    
    public Mapper (Connection con) 
    {
        this.con = con; 
    }
    
    //public List<Gæst> getGæster()
    
   public List<Gæst> getGæster(){
       Gæst gl = null; 
       String SQLString =
               " select * from GAEST";
       PreparedStatement statement = null; 
       List<Gæst> gæsteListe = new ArrayList<>();
       try {
           statement = con.prepareStatement(SQLString);
           ResultSet rs = statement.executeQuery();
           
           while (rs.next())
          {
              int gæid =rs.getInt("GAEST_ID");
              int boid = rs.getInt("BOOKING_ID");
              String fnavn = rs.getString("FORNAVN_E");
              String enavn = rs.getString("EFTERNAVN");
              String land = rs.getString("LAND");
              int telnu = rs.getInt("TELEFONNUMMER");
              String email = rs.getString("E_MAIL");
              String rbu = rs.getString("REJSEBUREAU");
              String checkda = rs.getString("CHECK_IN_DATO");
              int antnæ = rs.getInt("ANTAL_NAETTER");
              gæsteListe.add(new Gæst(gæid,boid,fnavn,enavn,land,telnu,email,rbu,checkda,antnæ));
//          Gæsteliste.addRow(new Object[]{t1,t2,t3,t4,t5,t6,t7,t8,t9,t10});
          
          }
           
       }catch (SQLException e) {
      System.out.println("Fail in Mapper - getGæster");
      System.out.println(e.getMessage());
    } finally // must close statement
    {
      try {
        if (statement != null) {
          statement.close();
        }
      } catch (SQLException e) {
        System.out.println("Fail in Mapper - getGæster");
        System.out.println(e.getMessage());
      }
    }
       return gæsteListe;
   }

}