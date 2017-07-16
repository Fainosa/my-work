package ro.ase.csie.licenta.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

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

    private Date data;

    @OneToMany(mappedBy = "meci")
    private List<Echipa> echipe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_competitie")
    private Competitie competitie;

    public Meci() {

    }

    public Meci( Date data, List<Echipa> echipe, Competitie competitie) {
        this.id = id;
        this.data = data;
        this.echipe = echipe;
        this.competitie = competitie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Echipa> getEchipe() {
        return echipe;
    }

    public void setEchipe(List<Echipa> echipe) {
        this.echipe = echipe;
    }

    @Override
    public String toString() {
        return "Meci{" +
                "id=" + id +
                ", data=" + data +
                ", echipe=" + echipe +
                ", competitie=" + competitie +
                '}';
    }

    @JsonIgnore
    public Competitie getCompetitie() {
        return competitie;
    }

    public void setCompetitie(Competitie competitie) {
        this.competitie = competitie;
    }
}
