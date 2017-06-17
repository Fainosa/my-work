package ro.ase.csie.licenta.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

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

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "echipa")
   @JoinColumn(name = "id_echipa")
   private ArrayList<Echipa> listaEchipe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meci")
    @JoinColumn(name = "id_meci")
   private ArrayList<Meci> listaMeciuri;



    public  Competitie(){

    }



    public Competitie(String nume, Date dataIncepere, Date dataTerminare, String locatie, ArrayList<Echipa> listaEchipe, ArrayList<Meci> listaMeciuri) {
        this.id = id;
        this.nume = nume;
        this.dataIncepere = dataIncepere;
        this.dataTerminare = dataTerminare;
        this.locatie = locatie;
        this.listaEchipe = listaEchipe;
        this.listaMeciuri = listaMeciuri;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Echipa> getListaEchipe() {
        return listaEchipe;
    }

    public void setListaEchipe(Echipa echipa) {
        this.listaEchipe.add(echipa);
    }

    public ArrayList<Meci> getListaMeciuri() {
        return listaMeciuri;
    }

    public void setListaMeciuri(Meci meci) {
        this.listaMeciuri.add(meci);
    }


    @Override
    public String toString() {
        return "Competitie{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", dataIncepere=" + dataIncepere +
                ", dataTerminare=" + dataTerminare +
                ", locatie='" + locatie + '\'' +
                ", listaEchipe=" + listaEchipe +
                ", listaMeciuri=" + listaMeciuri +
                '}';
    }
}
