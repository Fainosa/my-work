package ro.ase.csie.licenta.domain;

import javax.persistence.*;
import java.util.ArrayList;
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
    private Date ora;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_punctaj")
    private ArrayList<Punctaj> listaPuncte;

    public Meci(){

    }


    public Meci( String echipaGazda, String echipaOaspete, Date data, Date ora, ArrayList<Punctaj> listaPuncte) {

        this.echipaGazda = echipaGazda;
        this.echipaOaspete = echipaOaspete;
        this.data = data;
        this.ora = ora;
        this.listaPuncte = listaPuncte;
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

    public Date getOra() {
        return ora;
    }

    public void setOra(Date ora) {
        this.ora = ora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Punctaj> getListaPuncte() {
        return listaPuncte;
    }

    public void setListaPuncte(Punctaj punctaj) {
        this.listaPuncte.add(punctaj);
    }

    @Override
    public String toString() {
        return "Meci{" +
                "id=" + id +
                ", echipaGazda='" + echipaGazda + '\'' +
                ", echipaOaspete='" + echipaOaspete + '\'' +
                ", data=" + data +
                ", ora=" + ora +
                ", listaPuncte=" + listaPuncte +
                '}';
    }
}
