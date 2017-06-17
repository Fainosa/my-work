package ro.ase.csie.licenta.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
@Entity
@Table(name = "echipa")

public class Echipa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEchipa;

    private String numeEchipa;
    private String locatie;
    private Date dataInfiintare;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_jucator")
    private ArrayList<Jucator> listaJucatori;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_antrenor")
    private ArrayList<Antrenor> listaAntrenori;

    public Echipa(){

    }


    public Echipa( String numeEchipa, String locatie, Date dataInfiintare, ArrayList<Jucator> listaJucatori, ArrayList<Antrenor> listaAntrenori) {

        this.numeEchipa = numeEchipa;
        this.locatie = locatie;
        this.dataInfiintare = dataInfiintare;
        this.listaJucatori = listaJucatori;
        this.listaAntrenori = listaAntrenori;
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

    public Date getDataInfiintare() {
        return dataInfiintare;
    }

    public void setDataInfiintare(Date dataInfiintare) {
        this.dataInfiintare = dataInfiintare;
    }

    public long getIdEchipa() {
        return idEchipa;
    }

    public void setIdEchipa(long idEchipa) {
        this.idEchipa = idEchipa;
    }

    public ArrayList<Jucator> getListaJucatori() {
        return listaJucatori;
    }

    public void setListaJucatori(Jucator jucator) {
        this.listaJucatori.add(jucator);
    }

    public ArrayList<Antrenor> getListaAntrenori() {
        return listaAntrenori;
    }

    public void setListaAntrenori(Antrenor antrenor) {
        this.listaAntrenori.add(antrenor);
    }

    @Override
    public String toString() {
        return "Echipa{" +
                "idEchipa=" + idEchipa +
                ", numeEchipa='" + numeEchipa + '\'' +
                ", locatie='" + locatie + '\'' +
                ", dataInfiintare=" + dataInfiintare +
                ", listaJucatori=" + listaJucatori +
                ", listaAntrenori=" + listaAntrenori +
                '}';
    }
}
