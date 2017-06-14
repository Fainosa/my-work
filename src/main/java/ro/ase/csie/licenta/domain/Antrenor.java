package ro.ase.csie.licenta.domain;

import javax.persistence.Entity;
import java.util.Date;

public class Antrenor {
    private String nume;
    private String prenume;
    private Date dataNasterii;
    private String eMail;
    private String telefon;

    public Antrenor(){

    }

    public Antrenor(String nume, String prenume, Date dataNasterii, String eMail, String telefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.dataNasterii = dataNasterii;
        this.eMail = eMail;
        this.telefon = telefon;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Antrenor{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", dataNasterii=" + dataNasterii +
                ", eMail='" + eMail + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
