package ro.ase.csie.licenta.domain;

import javax.persistence.Entity;
import java.util.Date;

public class Jucator {
    private String nume;
    private String prenume;
    private float inaltime;
    private float greutate;
    private Date dataNasterii;
    private String eMail;

    public Jucator(){

    }

    public Jucator(String nume, String prenume, float inaltime, float greutate, Date dataNasterii, String eMail) {
        this.nume = nume;
        this.prenume = prenume;
        this.inaltime = inaltime;
        this.greutate = greutate;
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

    public float getInaltime() {
        return inaltime;
    }

    public void setInaltime(float inaltime) {
        this.inaltime = inaltime;
    }

    public float getGreutate() {
        return greutate;
    }

    public void setGreutate(float greutate) {
        this.greutate = greutate;
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

    @Override
    public String toString() {
        return "Jucator{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", inaltime=" + inaltime +
                ", greutate=" + greutate +
                ", dataNasterii=" + dataNasterii +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
