package ehu.isad.controllers;

import ehu.isad.Book;
import ehu.isad.Liburuak;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class XehetasunakKud implements Initializable {

    private Liburuak liburuakApp;

    @FXML
    private Label izenburuaLabel;

    @FXML
    private Label argitaletxeaLabel;

    @FXML
    private Label orrikopLabel;

    @FXML
    private Button atzeraBotoia;

    public void setLiburuakApp(Liburuak liburuak) {
        this.liburuakApp = liburuak;
    }

    public void datuakSartu(){
        Book liburua = liburuakApp.getLiburua();
        if(liburua!=null) {
            this.izenburuaLabel.setText(liburua.getDetails().getTitle());
            this.argitaletxeaLabel.setText(String.valueOf(liburua.getDetails().getArgitaletxe()));
            this.orrikopLabel.setText(String.valueOf(liburua.getDetails().getOrriKop()));
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

