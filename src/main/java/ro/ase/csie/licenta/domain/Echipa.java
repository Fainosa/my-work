package ro.ase.csie.licenta.domain;

import javax.persistence.Entity;
import java.util.Date;

public class Echipa {

    private String numeEchipa;
    private String locatie;
    private Date dataInceperii;


    public Echipa(){

    }
    public Echipa(String numeEchipa, String locatie, Date dataInceperii) {
        this.numeEchipa = numeEchipa;
        this.locatie = locatie;
        this.dataInceperii = dataInceperii;

    }

    public String getNumeEchipa() {
        return numeEchipa;
    }

    public void setNumeEchipa(String numeEchipa) {
        this.numeEchipa = numeEchipa;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public Date getDataInceperii() {
        return dataInceperii;
    }

    public void setDataInceperii(Date dataInceperii) {
        this.dataInceperii = dataInceperii;
    }



    @Override
    public String toString() {
        return "Echipa{" +
                "numeEchipa='" + numeEchipa + '\'' +
                ", locatie='" + locatie + '\'' +
                ", dataInceperii=" + dataInceperii +
                '}';
    }
}
