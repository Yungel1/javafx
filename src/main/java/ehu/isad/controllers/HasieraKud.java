package ehu.isad.controllers;

import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HasieraKud implements Initializable {

    private Main mainApp;

    @FXML
    private Button bozkatuBTN;

    @FXML
    private ImageView euroIMG;

    @FXML
    void onClick(ActionEvent event) {
        mainApp.hhErakutsi();
    }

    public void setMainApp(Main main) {
        mainApp=main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

