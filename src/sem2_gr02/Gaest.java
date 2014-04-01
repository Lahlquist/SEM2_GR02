
package sem2_gr02;

import java.util.ArrayList;
import java.util.List;



public class Gaest
{
    private String gaestid;
    private String fornavn;
    private String efternavn;
    private int telefonnummer;
    private String email;
    private String vejnavn;
    private int vejnummer;
    private int postnummer;
    private String bynavn;
    private String Land;
    private String rejsebureau;
    private List<Gaest> gæsteListe;


    
    public Gaest(String gaeid, String fnavn, String enavn, int telnu, String mail, String vnavn, int vno, int pno, String bnavn, String land, String rbu)
    { 
        gaestid = gaeid;
        fornavn = fnavn;
        efternavn = enavn;
        telefonnummer = telnu;
        email = mail;
        vejnavn = vnavn;
        vejnummer = vno;
        postnummer = pno;
        bynavn = bnavn;
        Land = land;
        rejsebureau = rbu;
        
        gæsteListe = new ArrayList<Gaest>();

        
        
    }


    public String getGaestid()
    {
        return gaestid;
    }

    public void setGaestid(String gaestid)
    {
        this.gaestid = gaestid;
    }

    public String getVejnavn()
    {
        return vejnavn;
    }

    public void setVejnavn(String vejnavn)
    {
        this.vejnavn = vejnavn;
    }

    public int getVejnummer()
    {
        return vejnummer;
    }

    public void setVejnummer(int vejnummer)
    {
        this.vejnummer = vejnummer;
    }

    public int getPostnummer()
    {
        return postnummer;
    }

    public void setPostnummer(int postnummer)
    {
        this.postnummer = postnummer;
    }

    public String getBynavn()
    {
        return bynavn;
    }

    public void setBynavn(String bynavn)
    {
        this.bynavn = bynavn;
    }

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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }


    public void addGæst(Gaest gl)
    {
        gæsteListe.add(gl);
    }
    public String tostring()
    {
        return gaestid + "" + fornavn + "" + efternavn + "" + telefonnummer + "" + email + "" + vejnavn + "" + vejnummer + "" + postnummer + "" + bynavn + "" + Land + "" + rejsebureau;
       // return fornavn + "" + efternavn+ "" +  + "" + Land + "" +  telefonnummer + "" + rejsebureau+ "" + bookingid + "" + gæstid + "" +nætter + "" + email+ "" +checkin;
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