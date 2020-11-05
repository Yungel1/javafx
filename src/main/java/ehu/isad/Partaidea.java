package ehu.isad;

public class Partaidea {

    private String izenaH;
    private String izenArtistikoa;
    private String izenaAbes;
    private String bandera;
    private int puntuak;

    public Partaidea(String izenaH, String bandera, int puntuak) {
        this.izenaH = izenaH;
        this.bandera = bandera;
        this.puntuak = puntuak;
    }

    public Partaidea(String izenaH, String izenArtistikoa, String izenaAbes, String bandera) {
        this.izenaH = izenaH;
        this.izenArtistikoa = izenArtistikoa;
        this.izenaAbes = izenaAbes;
        this.bandera = bandera;
    }

    public String getIzenaH() {
        return izenaH;
    }

    public String getIzenArtistikoa() {
        return izenArtistikoa;
    }

    public String getIzenaAbes() {
        return izenaAbes;
    }

    public String getBandera() {
        return bandera;
    }

    public int getPuntuak(){
        return puntuak;
    }
}
