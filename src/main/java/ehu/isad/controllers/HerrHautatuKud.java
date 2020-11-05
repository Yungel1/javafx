package ehu.isad.controllers;

import ehu.isad.Herrialdea;
import ehu.isad.Main;
import ehu.isad.dbcontroller.BozkatuDBKud;
import ehu.isad.dbcontroller.HerrialdeDBKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.util.StringConverter;

import java.net.URL;
import java.sql.SQLException;
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
    void onClick(ActionEvent event) throws SQLException {
        Herrialdea herrialde=herrialdeCB.getValue();
        if(BozkatuDBKud.getInstance().bozkatuDu(herrialde)){
            mainApp.setHerrialdea(herrialde);
            mainApp.erroreaErakutsi();
        }
        else {
            mainApp.bozkaketakErakutsi();
        }
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

    private void setConverterComboBox(){
        herrialdeCB.setConverter(new StringConverter<Herrialdea>(){
            @Override
            public String toString(Herrialdea herrialde){
                if(herrialde==null){
                    return "";
                }
                return herrialde.getIzena();
            }

            @Override
            public Herrialdea fromString(String string){
                return null;
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setConverterComboBox();
        cbInitialize();
    }
}

