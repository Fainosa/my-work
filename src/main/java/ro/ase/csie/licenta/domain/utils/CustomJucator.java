package ro.ase.csie.licenta.domain.utils;

import java.util.Date;

/**
 * Created by valkr on 7/13/2017.
 */
public class CustomJucator {

    private int loc;
    private String nume;
    private String prenume;
    private Date dataNasterii;
    private String eMail;

    public CustomJucator(){

    }

    public CustomJucator(String nume, String prenume, Date dataNasterii, String eMail) {
        this.nume = nume;
        this.prenume = prenume;
        this.dataNasterii = dataNasterii;
        this.eMail = eMail;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Date getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(Date dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }
}
