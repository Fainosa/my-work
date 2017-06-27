package ro.ase.csie.licenta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "jucator")
public class Jucator {

    @Id
    @Column(name = "id_jucator")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nume;
    private String prenume;
    private float inaltime;
    private float greutate;
    private Date dataNasterii;
    private String eMail;
    private int numarJucator;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_echipa")
    private Echipa echipa;

    public Jucator(){

    }

    public Jucator(String nume, String prenume, float inaltime, float greutate, Date dataNasterii, String eMail, int numarJucator, Echipa echipa) {
        this.nume = nume;
        this.prenume = prenume;
        this.inaltime = inaltime;
        this.greutate = greutate;
        this.dataNasterii = dataNasterii;
        this.eMail = eMail;
        this.numarJucator = numarJucator;
        this.echipa = echipa;
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

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public float getInaltime() {
        return inaltime;
    }

    public void setInaltime(float inaltime) {
        this.inaltime = inaltime;
    }

    public float getGreutate() {
        return greutate;
    }

    public void setGreutate(float greutate) {
        this.greutate = greutate;
    }

    public Date getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(Date dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getNumarJucator() {
        return numarJucator;
    }

    public void setNumarJucator(int numarJucator) {
        this.numarJucator = numarJucator;
    }

    @JsonIgnore
    public Echipa getEchipa() {
        return echipa;
    }

    public void setEchipa(Echipa echipa) {
        this.echipa = echipa;
    }
}
