package ro.ase.csie.licenta;

import java.util.Date;

/**
 * Created by valkr on 6/14/2017.
 */
public class Competitie {
    private String nume;
    private Date dataIncepere;
    private Date dataTerminare;
    private String locatie;

    public  Competitie(){

    }
    public Competitie(String nume, Date dataIncepere, Date dataTerminare, String locatie) {
        this.nume = nume;
        this.dataIncepere = dataIncepere;
        this.dataTerminare = dataTerminare;
        this.locatie = locatie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Date getDataIncepere() {
        return dataIncepere;
    }

    public void setDataIncepere(Date dataIncepere) {
        this.dataIncepere = dataIncepere;
    }

    public Date getDataTerminare() {
        return dataTerminare;
    }

    public void setDataTerminare(Date dataTerminare) {
        this.dataTerminare = dataTerminare;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    @Override
    public String toString() {
        return "Competitie{" +
                "nume='" + nume + '\'' +
                ", dataIncepere=" + dataIncepere +
                ", dataTerminare=" + dataTerminare +
                ", locatie='" + locatie + '\'' +
                '}';
    }
}
