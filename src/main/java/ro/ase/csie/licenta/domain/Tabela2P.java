package ro.ase.csie.licenta.domain;

import javax.persistence.*;

@Entity
@Table(name = "tabela2p")
public class Tabela2P {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String tipPunct;
    private int valoare;

    public Tabela2P() {
    }

    public Tabela2P(String tipPunct, int valoare) {
        this.tipPunct = tipPunct;
        this.valoare = valoare;
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

}
