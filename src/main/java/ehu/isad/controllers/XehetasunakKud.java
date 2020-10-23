package ehu.isad.controllers;

import ehu.isad.Book;
import ehu.isad.Liburuak;
import ehu.isad.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.ResourceBundle;
import java.awt.image.BufferedImage;

public class XehetasunakKud implements Initializable {

    private Liburuak liburuakApp;

    @FXML
    private Label izenburuaLabel;

    @FXML
    private Label argitaletxeaLabel;

    @FXML
    private Label orrikopLabel;

    @FXML
    private ImageView irudiaIV;

    @FXML
    private Button atzeraBotoia;

    public void setLiburuakApp(Liburuak liburuak) {
        this.liburuakApp = liburuak;
    }

    public void datuakSartu() throws IOException {
        Book liburua = liburuakApp.getLiburua();
        if(liburua!=null) {
            this.izenburuaLabel.setText(liburua.getDetails().getTitle());
            this.argitaletxeaLabel.setText(String.valueOf(liburua.getDetails().getArgitaletxe()));
            this.orrikopLabel.setText(String.valueOf(liburua.getDetails().getOrriKop()));
            Image irudia;
            if(liburua.getThumbnail_url()!=null) {
                String url = liburua.getThumbnail_url();
                url = url.replace("-S", "-M");
                irudia = this.createImage(url);
                this.irudiaIV.setImage(irudia);
                this.gordeIrudia(url);
            }
            else{
                String path = this.lortuIrudiPath();
                irudia = new Image("file:///"+path);
                this.irudiaIV.setImage(irudia);
            }
        }
    }

    private void gordeIrudia(String url) throws IOException {
        String izena=liburuakApp.urlZatitu(url);
        Properties properties= Utils.lortuEzarpenak();
        String path=properties.getProperty("imagePath")+izena;
        try(InputStream in = new URL(url).openStream()){
            Files.copy(in, Paths.get(path));}

    }

    private String lortuIrudiPath(){
        String path= liburuakApp.getLiburua().getDetails().getIrudia();
        return path;
    }


    private Image createImage(String url) throws IOException {
        URLConnection conn = new URL(url).openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36");
        try (InputStream stream = conn.getInputStream()) {
            return new Image(stream);
        }
    }


    @FXML
    void onClick(ActionEvent event) {
        liburuakApp.liburuakErakutsi();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

