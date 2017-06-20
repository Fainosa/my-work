package ro.ase.csie.licenta.domain;

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

    @OneToMany(mappedBy = "echipa")
    private List<Jucator> jucatori;

    @OneToMany(mappedBy = "echipa")
    private List<Antrenor> antrenori;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_meci")
    private Meci meci;

    public Echipa() {

    }

    public Echipa(String numeEchipa, String locatie, Date dataInfiintare, List<Jucator> jucatori, List<Antrenor> antrenori, Meci meci) {
        this.numeEchipa = numeEchipa;
        this.locatie = locatie;
        this.dataInfiintare = dataInfiintare;
        this.jucatori = jucatori;
        this.antrenori = antrenori;
        this.meci = meci;
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

    public Meci getMeci() {
        return meci;
    }

    public void setMeci(Meci meci) {
        this.meci = meci;
    }
}
