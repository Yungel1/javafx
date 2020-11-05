package ehu.isad.controllers;

import ehu.isad.Herrialdea;
import ehu.isad.Main;
import ehu.isad.Partaidea;
import ehu.isad.dbcontroller.OrdezkatuDBKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BozkaketakKud implements Initializable {

    private Main mainApp;

    @FXML
    private TableView<?> bozTaula;

    @FXML
    private Label banatuLabel;

    @FXML
    private ImageView euroIMG;

    @FXML
    private Button bozBTN;

    @FXML
    void onClick(ActionEvent event) {
        mainApp.top3Erakutsi();
    }

    private void taulaInitialize(){
        List<Partaidea> partaideakList=OrdezkatuDBKud.getInstance().partaideInfoLortu();
        ObservableList<Partaidea> partaideak = FXCollections.observableArrayList(partaideakList);
        //TODO
    }

    public void setMainApp(Main main) {
        this.mainApp=main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taulaInitialize();
    }
}
