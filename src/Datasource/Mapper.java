package Datasource;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sem2_gr02.Gaest;
import sem2_gr02.Lejlighed;
import sem2_gr02.Booking;


public class Mapper
{
    
    ArrayList<Booking> ledig_id = new ArrayList<>();
    private final Connection con;

    
    
    public Mapper(Connection con)
    {
        this.con = con;
    }

    
    
    public List<Gaest> getGaester()
    {
        Gaest gl = null;
        String SQLString =
                " select * from GAEST_TBL";
        PreparedStatement statement = null;
        List<Gaest> gaesteListe = new ArrayList<>();
        try
        {
            statement = con.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                String gaeid = rs.getString("GAEST_ID");
                String fnavn = rs.getString("FORNAVN_E");
                String enavn = rs.getString("EFTERNAVN");
                int telnu    = rs.getInt("TELEFONNUMMER");
                String mail  = rs.getString("E_MAIL");
                String vnavn = rs.getString("VEJNAVN");
                int vno      = rs.getInt("VEJNUMMER");
                int pno      = rs.getInt("POSTNUMMER");
                String bnavn = rs.getString("BYNAVN");
                String land  = rs.getString("LAND");
                String rbu   = rs.getString("REJSEBUREAU");
                
                gaesteListe.add(new Gaest(gaeid,fnavn,enavn,telnu,mail,vnavn,vno,pno,bnavn,land,rbu));
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
        return gaesteListe;
    }
    
    
        public boolean createNewBooking(Gaest g)
    {
        int rowsInserted = 0;
        String SQLStringGæst = "insert into GAEST_TBL "
                + "values (?,?,?,?,?,?,?,?,?,?,?)";
        
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
    
    
    
    
// ANDERS - NYT -
    
    
    // plus alle de lejligheder som ikke er booket i fremtiden eller nu.
    public ArrayList getRooms(String x, String y) {
        System.out.println(x);
        System.out.println(y);
        ledig_id.clear();
        
        String SQLString =
                " SELECT BOOKING_ID, LEJLIGHED_ID, to_char(CHECK_IN_DATO, 'DD-MM-YYYY'), to_char(CHECK_OUT_DATO, 'DD-MM-YYYY') from BOOKEDE_LEJLIGHED_TBL "
                + "WHERE BOOKING_ID NOT IN("
                + "  SELECT BOOKING_ID FROM BOOKEDE_LEJLIGHED_TBL"
                + "  WHERE CHECK_IN_DATO < to_date('" + x + "','DD-MM-YYYY') AND "
                + "  CHECK_OUT_DATO      > to_date('" + x + "','DD-MM-YYYY') OR "
                + "  CHECK_IN_DATO       < to_date('" + y + "','DD-MM-YYYY') AND "
                + "  CHECK_OUT_DATO      > to_date('" + y + "','DD-MM-YYYY') OR "
                + "  CHECK_IN_DATO       > to_date('" + x + "','DD-MM-YYYY') AND "
                + "  CHECK_OUT_DATO      < to_date('" + y + "','DD-MM-YYYY') OR "
                + "  CHECK_IN_DATO       < to_date('" + x + "','DD-MM-YYYY') AND "
                + "  CHECK_OUT_DATO      > to_date('" + y + "','DD-MM-YYYY'))";
        
        
        
        PreparedStatement statement = null;
        
        try {
            statement = con.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                String BOOK_ID   = rs.getString("BOOKING_ID");
                int LEJ_ID       = rs.getInt("LEJLIGHED_ID");
                String CHECK_IND = rs.getString("CHECK_IN_DATO");
                String CHECK_UD  = rs.getString("CHECK_OUT_DATO");
                
                ledig_id.add(new Booking(BOOK_ID, LEJ_ID, CHECK_IND, CHECK_UD));               
            }
            
        }
        catch(Exception e) {
            System.out.println("Fail in Mapper - getRooms");
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                if (statement != null)
                {
                    statement.close();
                }
            } catch (SQLException e)
            {
                System.out.println("Fail in Mapper - getRooms");
                System.out.println(e.getMessage());
            }
        
        
        return ledig_id;
    }
}
    // INSRET INTO BOOKEDE_LEJLIGHED_TBL. - (skal måske 'merges' med createNewBooking).
    public boolean roomBooking(Booking a) { 
        int rowsInserted = 0;
        String SQLStringBooking = "insert into BOOKEDE_LEJLIGHED_TBL "
                + "values (?,?,?,?)";
        
         PreparedStatement statement = null;
  
         try {
         statement = con.prepareStatement(SQLStringBooking);   
         statement.setString(1, null);
         statement.setInt   (2, a.getLejlighed_id());
         statement.setString(3, a.getCheckIn());
         statement.setString(4, a.getCheckUd());
         
         rowsInserted = statement.executeUpdate();
         }
         catch(Exception e) {             
             System.out.println(e.getMessage());
         }
         finally
        {
            try
            {
                statement.close();
            } catch (SQLException e)
            {
                System.out.println("Fejler i mapper - roomBooking");
            }
        }
        return rowsInserted == 1;
    }
  
   // skal hente max booking id + 1 (3-4 cifre).
    public int idGenerator() {
        int newID = 0;
        
        String SQLString =
                " select (MAX)BOOKING_ID from BOOKEDE_LEJLIGHED_TBL";
        PreparedStatement statement = null;
        try{ 
            statement    = con.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();
            newID        = rs.getInt("BOOKING_ID") + 1;
            
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return newID;
    }
    
    //skal udvælge en lejlighed til currentGæst.
    public int tildelLejlighed() {
        
        int lejlighedsNR = ledig_id.get(0).getLejlighed_id();
        String SQLString = "select * from lejlighed where id = " + lejlighedsNR + "";
        
        String SQLInsert = ""; // Insert " 'booked' i lejlighed_tbl hvis ikke allerede.
                               // Burde måske ikke være booked status men null i datoer istedet?
                               // Måske flytte booking id fra lejlighed til gæst? 
        try{
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return lejlighedsNR;
    }
    
    
}
