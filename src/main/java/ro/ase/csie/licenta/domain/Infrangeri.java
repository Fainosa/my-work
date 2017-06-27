package ro.ase.csie.licenta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "infrangeri")
public class Infrangeri {

    @Id
    @Column(name = "id_infrangeri")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int numarInfrangeri;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_echipa")
    private Echipa echipa;

    public Infrangeri() {
    }

    public Infrangeri(int numarInfrangeri, Echipa echipa) {
        this.numarInfrangeri = numarInfrangeri;
        this.echipa = echipa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumarInfrangeri() {
        return numarInfrangeri;
    }

    public void setNumarInfrangeri(int numarInfrangeri) {
        this.numarInfrangeri = numarInfrangeri;
    }

    @JsonIgnore
    public Echipa getEchipa() {
        return echipa;
    }

    public void setEchipa(Echipa  echipa) {
        this.echipa = echipa;
    }
}
