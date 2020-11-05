package ehu.isad;

import ehu.isad.controllers.*;
import ehu.isad.dbcontroller.BozkatuDBKud;
//import ehu.isad.utils.Sarea;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {

    private Parent UI1;
    private Parent UI2;
    private Parent UI3;
    private Parent UI4;
    private Parent UI5;

    private Stage stage;

    private HasieraKud hasieraKud;
    private HerrHautatuKud hhKud;
    private ErroreaKud errorKud;
    private BozkaketakKud bozkKud;
    private TOP3Kud top3Kud;

//    private Sarea sarea=new Sarea();

    private Scene sceneHasiera;
    private Scene sceneHH;
    private Scene sceneErrorea;
    private Scene sceneBozk;
    private Scene sceneTOP3;

    private Herrialdea herrialdea;


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        pantailakKargatu();

        stage.setTitle("Eurovision");
        stage.setScene(sceneHasiera);
        stage.show();
    }

    private void pantailakKargatu() throws IOException {

        this.pantailaHasiera();
        this.pantailaHerrHautatu();
        this.pantailaErrorea();
        this.pantailaBozkaketak();
        this.pantailaTOP3();
    }

    private void pantailaHasiera(){
        FXMLLoader loaderHasiera = new FXMLLoader(getClass().getResource("/Hasiera.fxml"));
        try {
            UI1 = (Parent) loaderHasiera.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sceneHasiera=new Scene(UI1);
        hasieraKud = loaderHasiera.getController();
        hasieraKud.setMainApp(this);
    }

    private void pantailaHerrHautatu(){
        FXMLLoader loaderHH = new FXMLLoader(getClass().getResource("/HerrHautatu.fxml"));
        try {
            UI2 = (Parent) loaderHH.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sceneHH=new Scene(UI2);
        hhKud = loaderHH.getController();
        hhKud.setMainApp(this);
    }

    private void pantailaErrorea(){
        FXMLLoader loaderErrorea = new FXMLLoader(getClass().getResource("/Errorea.fxml"));
        try {
            UI3 = (Parent) loaderErrorea.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sceneErrorea=new Scene(UI3);
        errorKud = loaderErrorea.getController();
        errorKud.setMainApp(this);
    }

    private void pantailaBozkaketak(){
        FXMLLoader loaderBozk = new FXMLLoader(getClass().getResource("/Bozkaketak.fxml"));
        try {
            UI4 = (Parent) loaderBozk.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sceneBozk=new Scene(UI4);
        bozkKud = loaderBozk.getController();
        bozkKud.setMainApp(this);
    }

    private void pantailaTOP3(){
        FXMLLoader loaderTOP3 = new FXMLLoader(getClass().getResource("/TOP3.fxml"));
        try {
            UI5 = (Parent) loaderTOP3.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sceneTOP3=new Scene(UI5);
        top3Kud = loaderTOP3.getController();
        top3Kud.setMainApp(this);
    }

//    public void hasieraErakutsi(){
//        stage.setTitle("Eurovision");
//        stage.setScene(sceneHasiera);
//        stage.show();
//    }
    public void hhErakutsi(){
        stage.setTitle("Informazioaren eguneraketa");
        stage.setScene(sceneHH);
        stage.show();
    }
    public void erroreaErakutsi(){
        stage.setTitle(herrialdea.getIzena()+"-(r)en inguruko informazioa");
        errorKud.herrialdeaSartu();
        stage.setScene(sceneErrorea);
        stage.show();
    }
    public void bozkaketakErakutsi(){
        stage.setTitle("Bozkaketa Panela");
        stage.setScene(sceneBozk);
        stage.show();
    }
    public void top3Erakutsi(){
        stage.setTitle("Datuak sartu");
        stage.setScene(sceneTOP3);
        stage.show();
    }

    public void setHerrialdea(Herrialdea herrialdea) {
        this.herrialdea = herrialdea;
    }

    public Herrialdea getHerrialdea(){
        return this.herrialdea;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

