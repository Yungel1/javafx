package ehu.isad.controllers;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TOP3Kud implements Initializable {

    private Main mainApp;

    @FXML
    private ImageView euroIMG;

    @FXML
    private Label top1Label;

    @FXML
    private Label top2Label;

    @FXML
    private Label top3Label;

    @FXML
    private ImageView top1IMG;

    @FXML
    private ImageView top3IMG;

    @FXML
    private ImageView top2IMG;

    @FXML
    private Button okBTN;

    @FXML
    void onClick(ActionEvent event) {
        System.exit(0);
    }

    public void labelInitialize() {
        List<Partaidea> partaideakList= OrdezkatuDBKud.getInstance().top3Lortu();
        ObservableList<Partaidea> partaideak = FXCollections.observableArrayList(partaideakList);
        Partaidea partaidea;

        //Suposatuko da gutxienez 3 partaide egongo direla.
        partaidea=partaideak.get(0);
        top1Label.setText(partaidea.getIzenaH()+" - "+partaidea.getPuntuak());
        top1IMG.setImage(partaidea.getBanderaArg());

        partaidea=partaideak.get(1);
        top2Label.setText(partaidea.getIzenaH()+" - "+partaidea.getPuntuak());
        top2IMG.setImage(partaidea.getBanderaArg());

        partaidea=partaideak.get(2);
        top3Label.setText(partaidea.getIzenaH()+" - "+partaidea.getPuntuak());
        top3IMG.setImage(partaidea.getBanderaArg());
    }

    public void setMainApp(Main main) {
        mainApp=main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        euroIMG.setImage(new Image("images/eurobisioa.png"));
        labelInitialize();
    }
}
