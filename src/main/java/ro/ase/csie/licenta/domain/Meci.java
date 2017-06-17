package ro.ase.csie.licenta.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "meci")
public class Meci {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String echipaGazda;
    private String echipaOaspete;
    private Date data;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_1p")
    private Tabela1P tabela1P;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_2p")
    private Tabela2P tabela2P;

    public Meci(){

    }

    public Meci(String echipaGazda, String echipaOaspete, Date data, Tabela1P tabela1P, Tabela2P tabela2P) {
        this.echipaGazda = echipaGazda;
        this.echipaOaspete = echipaOaspete;
        this.data = data;
        this.tabela1P = tabela1P;
        this.tabela2P = tabela2P;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEchipaGazda() {
        return echipaGazda;
    }

    public void setEchipaGazda(String echipaGazda) {
        this.echipaGazda = echipaGazda;
    }

    public String getEchipaOaspete() {
        return echipaOaspete;
    }

    public void setEchipaOaspete(String echipaOaspete) {
        this.echipaOaspete = echipaOaspete;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Tabela1P getTabela1P() {
        return tabela1P;
    }

    public void setTabela1P(Tabela1P tabela1P) {
        this.tabela1P = tabela1P;
    }

    public Tabela2P getTabela2P() {
        return tabela2P;
    }

    public void setTabela2P(Tabela2P tabela2P) {
        this.tabela2P = tabela2P;
    }
}
