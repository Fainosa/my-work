package ro.ase.csie.licenta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "echipa")

public class Echipa {

    @Id
    @Column(name = "id_echipa")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String numeEchipa;
    private String locatie;
    private Date dataInfiintare;
    private int cosuriMarcate;
    private int cosuriPrimite;

    @OneToMany(mappedBy = "echipa")
    private List<Jucator> jucatori;

    @OneToMany(mappedBy = "echipa")
    private List<Antrenor> antrenori;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_meci")
    private Meci meci;

    @OneToMany(mappedBy = "echipa")
    private List<Infrangeri> infrangeri;

    @OneToMany(mappedBy = "echipa")
    private List<Victorii> victorii;

    public Echipa() {

    }

    public Echipa(String numeEchipa, String locatie, Date dataInfiintare, int cosuriMarcate, int cosuriPrimite, List<Jucator> jucatori, List<Antrenor> antrenori, Meci meci, List<Infrangeri> infrangeri, List<Victorii> victorii) {
        this.numeEchipa = numeEchipa;
        this.locatie = locatie;
        this.dataInfiintare = dataInfiintare;
        this.cosuriMarcate = cosuriMarcate;
        this.cosuriPrimite = cosuriPrimite;
        this.jucatori = jucatori;
        this.antrenori = antrenori;
        this.meci = meci;
        this.infrangeri = infrangeri;
        this.victorii = victorii;
    }

    public long getId() {
        return id;
    }

    public void setIdEchipa(long idEchipa) {
        this.id = idEchipa;
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

    public List<Jucator> getJucatori() {
        return jucatori;
    }

    public void setJucatori(List<Jucator> jucatori) {
        this.jucatori = jucatori;
    }

    public List<Antrenor> getAntrenori() {
        return antrenori;
    }

    public void setAntrenori(List<Antrenor> antrenori) {
        this.antrenori = antrenori;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Infrangeri> getInfrangeri() {
        return infrangeri;
    }

    public void setInfrangeri(List<Infrangeri> infrangeri) {
        this.infrangeri = infrangeri;
    }

    public List<Victorii> getVictorii() {
        return victorii;
    }

    public void setVictorii(List<Victorii> victorii) {
        this.victorii = victorii;
    }

    public int getCosuriMarcate() {
        return cosuriMarcate;
    }

    public void setCosuriMarcate(int cosuriMarcate) {
        this.cosuriMarcate = cosuriMarcate;
    }

    public int getCosuriPrimite() {
        return cosuriPrimite;
    }

    public void setCosuriPrimite(int cosuriPrimite) {
        this.cosuriPrimite = cosuriPrimite;
    }

    @JsonIgnore
    public Meci getMeci() {
        return meci;
    }

    public void setMeci(Meci meci) {
        this.meci = meci;
    }
}
