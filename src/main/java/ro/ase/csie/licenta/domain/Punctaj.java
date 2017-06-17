package ro.ase.csie.licenta.domain;

import javax.persistence.*;

@Entity
@Table(name = "punctaj")
public class Punctaj {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private int unPunct;
private int douaPuncte;

public Punctaj(){

}

    public Punctaj(int unPunct, int douaPuncte) {
        this.unPunct = unPunct;
        this.douaPuncte = douaPuncte;
    }

    public int getUnPunct() {
        return unPunct;
    }

    public void setUnPunct(int unPunct) {
        this.unPunct = unPunct;
    }

    public int getDouaPuncte() {
        return douaPuncte;
    }

    public void setDouaPuncte(int douaPuncte) {
        this.douaPuncte = douaPuncte;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Punctaj{" +
                "id=" + id +
                ", unPunct=" + unPunct +
                ", douaPuncte=" + douaPuncte +
                '}';
    }
}
