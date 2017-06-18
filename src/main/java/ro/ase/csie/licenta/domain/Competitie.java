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

    @OneToMany(mappedBy = "competitie")
    private List<Meci> meciuri;


    public Competitie() {

    }

    public Competitie(String nume, Date dataIncepere, Date dataTerminare, String locatie, List<Meci> meciuri) {
        this.nume = nume;
        this.dataIncepere = dataIncepere;
        this.dataTerminare = dataTerminare;
        this.locatie = locatie;
        this.meciuri = meciuri;
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

    public List<Meci> getMeciuri() {
        return meciuri;
    }

    public void setMeciuri(List<Meci> meciuri) {
        this.meciuri = meciuri;
    }

    @Override
    public String toString() {
        return "Competitie{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", dataIncepere=" + dataIncepere +
                ", dataTerminare=" + dataTerminare +
                ", locatie='" + locatie + '\'' +
                ", meciuri=" + meciuri +
                '}';
    }
}
