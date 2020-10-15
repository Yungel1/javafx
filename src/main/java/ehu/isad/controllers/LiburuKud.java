package ehu.isad.controllers;

import ehu.isad.Liburuak;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class LiburuKud implements Initializable {

    private Liburuak liburuakApp;

    @FXML
    private Button ikusiBotoia;

    @FXML
    private ComboBox<?> liburuakComboB;

    public void setLiburuakApp(Liburuak liburuak) {
        this.liburuakApp = liburuak;
    }

    @FXML
    void onClick(ActionEvent event) {
        liburuakApp.xehetasunakErakutsi();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

