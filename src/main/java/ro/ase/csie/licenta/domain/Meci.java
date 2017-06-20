package ro.ase.csie.licenta.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "meci")
public class Meci {

    @Id
    @Column(name = "id_meci")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String echipaGazda;
    private String echipaOaspete;
    private Date data;

    @OneToMany(mappedBy = "meci")
    private List<Tabela1P> tabela1P;

    @OneToMany(mappedBy = "meci")
    private List<Tabela2P> tabela2P;

    @OneToMany(mappedBy = "meci")
    private List<Echipa> echipe;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_competitie")
    private Competitie competitie;

    public Meci(){

    }

    public Meci(String echipaGazda, String echipaOaspete, Date data, List<Tabela1P> tabela1P, List<Tabela2P> tabela2P, List<Echipa> echipe, Competitie competitie) {
        this.echipaGazda = echipaGazda;
        this.echipaOaspete = echipaOaspete;
        this.data = data;
        this.tabela1P = tabela1P;
        this.tabela2P = tabela2P;
        this.echipe = echipe;
        this.competitie = competitie;
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

    public List<Tabela1P> getTabela1P() {
        return tabela1P;
    }

    public void setTabela1P(List<Tabela1P> tabela1P) {
        this.tabela1P = tabela1P;
    }

    public List<Tabela2P> getTabela2P() {
        return tabela2P;
    }

    public void setTabela2P(List<Tabela2P> tabela2P) {
        this.tabela2P = tabela2P;
    }

    public List<Echipa> getEchipe() {
        return echipe;
    }

    public void setEchipe(List<Echipa> echipe) {
        this.echipe = echipe;
    }

    public Competitie getCompetitie() {
        return competitie;
    }

    public void setCompetitie(Competitie competitie) {
        this.competitie = competitie;
    }
}
