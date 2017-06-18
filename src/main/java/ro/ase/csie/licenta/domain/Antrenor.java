package ro.ase.csie.licenta.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "antrenor")
public class Antrenor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nume;
    private String prenume;
    private Date dataNasterii;
    private String eMail;
    private String telefon;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="is_echipa")
    private Echipa echipa;

    public Antrenor(){

    }

    public Antrenor(String nume, String prenume, Date dataNasterii, String eMail, String telefon, Echipa echipa) {
        this.nume = nume;
        this.prenume = prenume;
        this.dataNasterii = dataNasterii;
        this.eMail = eMail;
        this.telefon = telefon;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Echipa getEchipa() {
        return echipa;
    }

    public void setEchipa(Echipa echipa) {
        this.echipa = echipa;
    }
}
