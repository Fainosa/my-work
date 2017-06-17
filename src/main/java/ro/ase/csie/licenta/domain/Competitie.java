package ro.ase.csie.licenta.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "competitie")
public class Competitie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nume;
    private Date dataIncepere;
    private Date dataTerminare;
    private String locatie;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_echipa")
    private Echipa echipa;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_meci")
    private Meci meci;


    public Competitie() {

    }

    public Competitie(String nume, Date dataIncepere, Date dataTerminare, String locatie, Echipa echipa, Meci meci) {
        this.nume = nume;
        this.dataIncepere = dataIncepere;
        this.dataTerminare = dataTerminare;
        this.locatie = locatie;
        this.echipa = echipa;
        this.meci = meci;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Echipa getEchipa() {
        return echipa;
    }

    public void setEchipa(Echipa echipa) {
        this.echipa = echipa;
    }

    public Meci getMeci() {
        return meci;
    }

    public void setMeci(Meci meci) {
        this.meci = meci;
    }

    @Override
    public String toString() {
        return "Competitie{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", dataIncepere=" + dataIncepere +
                ", dataTerminare=" + dataTerminare +
                ", locatie='" + locatie + '\'' +
                ", echipa=" + echipa +
                ", meci=" + meci +
                '}';
    }
}
