package ro.ase.csie.licenta;

import java.util.Date;

public class Meci {
    private String echipaGazda;
    private String echipaOaspete;
    private Date data;
    private Date ora;

    public Meci(){

    }
    public Meci(String echipaGazda, String echipaOaspete, Date data, Date ora) {
        this.echipaGazda = echipaGazda;
        this.echipaOaspete = echipaOaspete;
        this.data = data;
        this.ora = ora;
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

    @Override
    public String toString() {
        return "Meci{" +
                "echipaGazda='" + echipaGazda + '\'' +
                ", echipaOaspete='" + echipaOaspete + '\'' +
                ", data=" + data +
                ", ora=" + ora +
                '}';
    }
}
