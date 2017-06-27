package ro.ase.csie.licenta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "victorii")
public class Victorii {

    @Id
    @Column(name = "id_victorii")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int numarVictorii;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_echipa")
    private Echipa echipa;

    public Victorii() {
    }

    public Victorii(int numarVictorii, Echipa echipa) {
        this.numarVictorii = numarVictorii;
        this.echipa = echipa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumarVictorii() {
        return numarVictorii;
    }

    public void setNumarVictorii(int numarVictorii) {
        this.numarVictorii = numarVictorii;
    }

    @JsonIgnore
    public Echipa getEchipa() {
        return echipa;
    }

    public void setEchipa(Echipa echipa) {
        this.echipa = echipa;
    }
}
