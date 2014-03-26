/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sem2_gr02;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Emilos
 */
public class Gæst
{
    private String fornavn;
    private String efternavn;
    private String adresse;
    private String Land;
    private int telefonnummer;
    private String rejsebureau;
    private int bookingid;
    private int gæstid;
    private int nætter;
    private String email;
    private String checkin;
    private List<Gæst> gæsteListe;
    private String Checkud;

    
    public Gæst(int gæid, int boid, String fnavn, String enavn, String land, int telnu, String eail, String rbu, String checkind,String checkud, int antnæ)
    { 
        
        gæstid = gæid;
        bookingid = boid;
        fornavn = fnavn;
        efternavn = enavn;
//        adresse = addr;
        Land = land;
        telefonnummer = telnu;
        rejsebureau = rbu;
        nætter = antnæ;
        email = eail;
        checkin = checkind;
        gæsteListe = new ArrayList<Gæst>();
        Checkud = checkud;
        
        
    }

    public String getCheckud()
    {
        return Checkud;
    }

    public void setCheckud(String Checkud)
    {
        this.Checkud = Checkud;
    }






//    GæsteListe()
//    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public String getFornavn()
    {
        return fornavn;
    }

    public void setFornavn(String fornavn)
    {
        this.fornavn = fornavn;
    }

    public String getEfternavn()
    {
        return efternavn;
    }

    public void setEfternavn(String efternavn)
    {
        this.efternavn = efternavn;
    }

//    public String getAdresse()
//    {
//        return adresse;
//    }
//
//    public void setAdresse(String adresse)
//    {
//        this.adresse = adresse;
//    }

    public String getLand()
    {
        return Land;
    }

    public void setLand(String land)
    {
        this.Land = land;
    }

    public int getTelefonnummer()
    {
        return telefonnummer;
    }

    public void setTelefonnummer(int telefonnummer)
    {
        this.telefonnummer = telefonnummer;
    }

    public String getRejsebureau()
    {
        return rejsebureau;
    }

    public void setRejsebureau(String rejsebureau)
    {
        this.rejsebureau = rejsebureau;
    }

    public int getBookingid()
    {
        return bookingid;
    }

    public void setBookingid(int bookingid)
    {
        this.bookingid = bookingid;
    }

    public int getGæstid()
    {
        return gæstid;
    }

    public void setGæstid(int gæstid)
    {
        this.gæstid = gæstid;
    }

    public int getNætter()
    {
        return nætter;
    }

    public void setNætter(int nætter)
    {
        this.nætter = nætter;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getCheckin()
    {
        return checkin;
    }

    public void setCheckin(String checkin)
    {
        this.checkin = checkin;
    }

    public void addGæst(Gæst gl)
    {
        gæsteListe.add(gl);
    }
    public String tostring()
    {
        return fornavn + "" + efternavn+ "" + adresse + "" + Land + "" +  telefonnummer + "" + rejsebureau+ "" + bookingid + "" + gæstid + "" +nætter + "" + email+ "" +checkin;
    }

//        String detailsToString()
//	  {
//	    String res = "";
//	    for (int i = 0; i < gæsteListe.size(); i++) 
//	    {
//	      res += gæsteListe.get(i).toString() + "\n";
//	    }
//	    return res;
//	  } 




    
    
}
////gæst_id NUMBER(6),
////booking_id NUMBER(6),
////fornavn(e) VARCHAR2(60),
////efternavn VARCHAR2(30),
////adresse
////land
////telefonnummer
////e-mail
////rejsebureau
////check_in_dato
////antal_nætter
////);