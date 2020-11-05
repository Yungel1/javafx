package ehu.isad.controllers;

import ehu.isad.Herrialdea;
import ehu.isad.Main;
import ehu.isad.Partaidea;
import ehu.isad.dbcontroller.BozkatuDBKud;
import ehu.isad.dbcontroller.OrdezkatuDBKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BozkaketakKud implements Initializable {

    private Main mainApp;

    @FXML
    private TableView<Partaidea> bozTaula;

    @FXML
    private TableColumn<Partaidea, Image> banderaT;

    @FXML
    private TableColumn<Partaidea, String> herrialdeaT;

    @FXML
    private TableColumn<Partaidea, String> artistaT;

    @FXML
    private TableColumn<Partaidea, String> abestiaT;

    @FXML
    private TableColumn<Partaidea, Integer> puntuakT;

    @FXML
    private Label banatuLabel;

    @FXML
    private ImageView euroIMG;

    @FXML
    private Button bozBTN;

    private ObservableList<Partaidea> partaideak;

    @FXML
    void onClick(ActionEvent event) {
        mainApp.top3Erakutsi();
    }

    private void taulaInitialize(){
        List<Partaidea> partaideakList=OrdezkatuDBKud.getInstance().partaideInfoLortu();
        partaideak = FXCollections.observableArrayList(partaideakList);


        //TODO
    }

    public void setMainApp(Main main) {
        this.mainApp=main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        euroIMG.setImage(new Image("images/eurobisioa.png"));
        taulaInitialize();

        bozTaula.setEditable(true);
        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        herrialdeaT.setCellValueFactory(new PropertyValueFactory<>("izenaH"));
        artistaT.setCellValueFactory(new PropertyValueFactory<>("izenArtistikoa"));
        abestiaT.setCellValueFactory(new PropertyValueFactory<>("izenaAbes"));
        puntuakT.setCellValueFactory(new PropertyValueFactory<>("puntuak"));


        puntuakT.setCellFactory(
                TextFieldTableCell.forTableColumn(new IntegerStringConverter()));


        puntuakT.setOnEditCommit(
                t -> {
                    Partaidea partaidea=t.getTableView().getItems().get(t.getTablePosition().getRow());
                    if(!partaidea.getIzenaH().equals(mainApp.getHerrialdea().getIzena())) {
                        OrdezkatuDBKud.getInstance().puntuakEguneratu(t.getNewValue(), partaidea.getIzenaH());
                        BozkatuDBKud.getInstance().bozkatu(mainApp.getHerrialdea().getIzena(),partaidea.getIzenaH()
                                , t.getNewValue());
                    }
                }
        );

        banderaT.setCellValueFactory(new PropertyValueFactory<>("banderaArg"));

        banderaT.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty){
                    final ImageView imageview = new ImageView();
                    imageview.setFitHeight(25);
                    imageview.setFitWidth(40);
                    imageview.setImage(image);
                    setGraphic(imageview);
                    setAlignment(Pos.CENTER);
                    // tbData.refresh();
                }else{
                    setGraphic(null);
                    setText(null);
                }
            };
        });

        //add your data to the table here.
        bozTaula.setItems(partaideak);
    }
}
