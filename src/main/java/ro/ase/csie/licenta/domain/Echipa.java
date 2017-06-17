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

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_jucator")
    private Jucator jucator;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_antrenor")
    private Antrenor antrenor;

    public Echipa() {

    }

    public Echipa(String numeEchipa, String locatie, Date dataInfiintare, Jucator jucator, Antrenor antrenor) {
        this.numeEchipa = numeEchipa;
        this.locatie = locatie;
        this.dataInfiintare = dataInfiintare;
        this.jucator = jucator;
        this.antrenor = antrenor;
    }

    public long getIdEchipa() {
        return idEchipa;
    }

    public void setIdEchipa(long idEchipa) {
        this.idEchipa = idEchipa;
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

    public Jucator getJucator() {
        return jucator;
    }

    public void setJucator(Jucator jucator) {
        this.jucator = jucator;
    }

    public Antrenor getAntrenor() {
        return antrenor;
    }

    public void setAntrenor(Antrenor antrenor) {
        this.antrenor = antrenor;
    }
}
