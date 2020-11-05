package ehu.isad;

import javafx.scene.image.Image;

public class Partaidea {

    private String izenaH;
    private String izenArtistikoa;
    private String izenaAbes;
    private String bandera;
    private int puntuak;
    private Image banderaArg;

    public Partaidea(String izenaH, String bandera, int puntuak) {
        this.izenaH = izenaH;
        this.bandera = bandera;
        this.puntuak = puntuak;
        banderaArg=new Image("images/"+bandera+".png");
    }

    public Partaidea(String izenaH, String izenArtistikoa, String izenaAbes, String bandera) {
        this.izenaH = izenaH;
        this.izenArtistikoa = izenArtistikoa;
        this.izenaAbes = izenaAbes;
        this.bandera = bandera;
        banderaArg=new Image("images/"+bandera+".png");
    }

    public void setPuntuak(int pPuntuak){
        puntuak=pPuntuak;
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

    public Image getBanderaArg() {
        return banderaArg;
    }

    public int getPuntuak(){
        return puntuak;
    }
}
