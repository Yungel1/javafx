package ehu.isad;

import ehu.isad.controllers.*;
import ehu.isad.utils.Sarea;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Parent UI1;
    private Parent UI2;
    private Parent UI3;

    private Stage stage;

    private HasieraKud hasieraKud;
    private HerrHautatuKud hhKud;
    private ErroreaKud errorKud;

    private Sarea sarea=new Sarea();

    private Scene sceneHasiera;
    private Scene sceneHH;
    private Scene sceneErrorea;


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        pantailakKargatu();

        stage.setTitle("Eurovision");
        stage.setScene(sceneHasiera);
        stage.show();
    }

    private void pantailakKargatu(){

        this.pantailaHasiera();
        this.pantailaHerrHautatu();
        this.pantailaErrorea();
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
        stage.setTitle("inguruko informazioa");
        stage.setScene(sceneErrorea);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

