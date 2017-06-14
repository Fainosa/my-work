package ro.ase.csie.licenta.domain;

public class Punctaj {

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

    @Override
    public String toString() {
        return "Punctaj{" +
                "unPunct=" + unPunct +
                ", douaPuncte=" + douaPuncte +
                '}';
    }
}
