package ehu.isad.controllers;

import ehu.isad.Book;
import ehu.isad.Herrialdea;
import ehu.isad.Main;
import ehu.isad.dbcontroller.HerrialdeDBKud;
import ehu.isad.dbcontroller.ZerbitzuKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HerrHautatuKud implements Initializable {

    private Main mainApp;

    @FXML
    private ComboBox<Herrialdea> herrialdeCB;

    @FXML
    private ImageView euroIMG;

    @FXML
    private Button OkBTN;

    @FXML
    void onClick(ActionEvent event) {
        mainApp.erroreaErakutsi();
    }

    public void setMainApp(Main main) {
        mainApp=main;
    }

    private void cbInitialize(){
        List<Herrialdea> herrialdeakList = HerrialdeDBKud.getInstance().herrialdeakLortu();
        ObservableList<Herrialdea> herrialdeak = FXCollections.observableArrayList(herrialdeakList);

        herrialdeCB.setItems(herrialdeak);
        herrialdeCB.getSelectionModel().selectFirst();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbInitialize();
    }
}

