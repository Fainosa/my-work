package ro.ase.csie.licenta.domain;

import javax.persistence.*;

@Entity
@Table(name = "tabela1p")
public class Tabela1P {

    @Id
    @Column(name = "id_tabela1p")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String tipPunct;
    private int valoare;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_meci")
    private Meci meci;

    public Tabela1P() {
    }

    public Tabela1P(String tipPunct, int valoare, Meci meci) {
        this.tipPunct = tipPunct;
        this.valoare = valoare;
        this.meci = meci;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipPunct() {
        return tipPunct;
    }

    public void setTipPunct(String tipPunct) {
        this.tipPunct = tipPunct;
    }

    public int getValoare() {
        return valoare;
    }

    public void setValoare(int valoare) {
        this.valoare = valoare;
    }

    public Meci getMeci() {
        return meci;
    }

    public void setMeci(Meci meci) {
        this.meci = meci;
    }
}
