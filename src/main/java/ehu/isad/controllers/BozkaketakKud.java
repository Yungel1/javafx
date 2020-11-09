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

        int i=0;
        int puntuak=0;
        while(i<bozTaula.getItems().size()&&puntuak<5){
            Partaidea partaidea=bozTaula.getItems().get(i);
            puntuak=puntuak+partaidea.getPuntuak();
            i++;
        }
        if(puntuak==5) {
            sartuDB();
            mainApp.top3Erakutsi();
        }
    }

    private void sartuDB(){
        int i=0;
        while(i<bozTaula.getItems().size()) {
            Partaidea partaidea=bozTaula.getItems().get(i);
            if(partaidea.getPuntuak()!=0) {
                OrdezkatuDBKud.getInstance().puntuakEguneratu(partaidea.getPuntuak(), partaidea.getIzenaH());
                BozkatuDBKud.getInstance().bozkatu(mainApp.getHerrialdea().getIzena(), partaidea.getIzenaH()
                        , partaidea.getPuntuak());
            }
            i++;
        }
    }

    private void taulaInitialize(){
        List<Partaidea> partaideakList=OrdezkatuDBKud.getInstance().partaideInfoLortu();
        partaideak = FXCollections.observableArrayList(partaideakList);

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


        Callback<TableColumn<Partaidea, Integer>, TableCell<Partaidea, Integer>> defaultTextFieldCellFactory
                = TextFieldTableCell.forTableColumn(new IntegerStringConverter());

        puntuakT.setCellFactory(col -> {
            TableCell<Partaidea, Integer> cell = defaultTextFieldCellFactory.call(col);

            cell.setOnMouseClicked(event -> {
                if (!cell.isEmpty()) {
                    if (cell.getTableView().getSelectionModel().getSelectedItem().getIzenaH().equals(mainApp.getHerrialdea().getIzena())) {
                        cell.setEditable(false);
                    } else {
                        cell.setEditable(true);
                    }
                }
            });
            return cell;
        });

        puntuakT.setOnEditCommit(
                t -> {
                    t.getTableView().getItems().get(t.getTablePosition().getRow())
                            .setPuntuak(t.getNewValue());
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
