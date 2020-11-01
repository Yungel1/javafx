package ehu.isad.controllers;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ErroreaKud implements Initializable {

    private Main mainApp;

    @FXML
    private Label testuaLabel;

    @FXML
    private Button OkBTN;

    @FXML
    private ImageView euroIMG;

    @FXML
    private ImageView bandera;

    @FXML
    void onClick(ActionEvent event) {

    }

    public void setMainApp(Main main) {
        mainApp=main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

