package ro.ase.csie.licenta.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "echipa")

public class Echipa {

    @Id
    @Column(name = "id_echipa")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEchipa;

    private String numeEchipa;
    private String locatie;
    private Date dataInfiintare;

    @OneToMany(mappedBy = "echipa")
    private List<Jucator> jucatori;

    @OneToMany(mappedBy = "echipa")
    private List<Antrenor> antrenori;

    public Echipa() {

    }

    public Echipa(String numeEchipa, String locatie, Date dataInfiintare, List<Jucator> jucatori, List<Antrenor> antrenori) {
        this.numeEchipa = numeEchipa;
        this.locatie = locatie;
        this.dataInfiintare = dataInfiintare;
        this.jucatori = jucatori;
        this.antrenori = antrenori;
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

    public List<Jucator> getJucatoir() {
        return jucatori;
    }

    public void setJucatori(List<Jucator> jucator) {
        this.jucatori = jucatori;
    }

    public List<Antrenor> getAntrenor() {
        return antrenori;
    }

    public void setAntrenori(List<Antrenor> antrenori) {
        this.antrenori = antrenori;
    }
}
