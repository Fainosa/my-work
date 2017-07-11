package ro.ase.csie.licenta.domain.utils;

public class CustomEchipa {

    int loc;
   String nume;
   int cosuriMarcate;
   int cosuriPrimite;
   int victorii;
   int infrangeri;
   int punctaj;

    public CustomEchipa( int loc, String nume, int cosuriMarcate, int cosuriPrimite, int victorii, int infrangeri, int punctaj ) {
        this.loc = loc;
        this.nume = nume;
        this.cosuriMarcate = cosuriMarcate;
        this.cosuriPrimite = cosuriPrimite;
        this.victorii = victorii;
        this.infrangeri = infrangeri;
        this.punctaj = punctaj;
    }

    public CustomEchipa(String nume, int cosuriMarcate, int cosuriPrimite, int victorii, int infrangeri, int punctaj ) {
        this.nume = nume;
        this.cosuriMarcate = cosuriMarcate;
        this.cosuriPrimite = cosuriPrimite;
        this.victorii = victorii;
        this.infrangeri = infrangeri;
        this.punctaj = punctaj;
    }


    public CustomEchipa() {

    }

    public int getLoc() {
        return loc;
    }

    public void setLoc( int loc ) {
        this.loc = loc;
    }

    public String getNume() {
        return nume;
    }

    public void setNume( String nume ) {
        this.nume = nume;
    }

    public int getCosuriMarcate() {
        return cosuriMarcate;
    }

    public void setCosuriMarcate( int cosuriMarcate ) {
        this.cosuriMarcate = cosuriMarcate;
    }

    public int getCosuriPrimite() {
        return cosuriPrimite;
    }

    public void setCosuriPrimite( int cosuriPrimite ) {
        this.cosuriPrimite = cosuriPrimite;
    }

    public int getVictorii() {
        return victorii;
    }

    public void setVictorii( int victorii ) {
        this.victorii = victorii;
    }

    public int getInfrangeri() {
        return infrangeri;
    }

    public void setInfrangeri( int infrangeri ) {
        this.infrangeri = infrangeri;
    }

    public int getPunctaj() {
        return punctaj;
    }

    public void setPunctaj( int punctaj ) {
        this.punctaj = punctaj;
    }
}
