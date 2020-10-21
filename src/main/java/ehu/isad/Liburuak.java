package ehu.isad;

import ehu.isad.controllers.LiburuKud;
import ehu.isad.controllers.XehetasunakKud;
import ehu.isad.utils.Sarea;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Liburuak extends Application {

    private Parent xehetasunakUI;
    private Parent liburuUI;

    private Stage stage;

    private XehetasunakKud xehetasunakKud;
    private LiburuKud liburuKud;

    private Sarea sarea=new Sarea();
    private Book liburua;

    private Scene sceneLiburuak;
    private Scene sceneXehetasunak;


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        pantailakKargatu();

        stage.setTitle("OpenLibrary APIa aztertzen");
        stage.setScene(sceneLiburuak);
        stage.show();
    }

    private void pantailakKargatu() throws IOException {

        FXMLLoader loaderLiburu = new FXMLLoader(getClass().getResource("/Liburuak.fxml"));
        liburuUI = (Parent) loaderLiburu.load();
        this.sceneLiburuak=new Scene(liburuUI);
        liburuKud = loaderLiburu.getController();
        liburuKud.setLiburuakApp(this);

        FXMLLoader loaderXehetasuna = new FXMLLoader(getClass().getResource("/Xehetasunak.fxml"));
        xehetasunakUI = (Parent) loaderXehetasuna.load();
        this.sceneXehetasunak=new Scene(xehetasunakUI);
        xehetasunakKud = loaderXehetasuna.getController();
        xehetasunakKud.setLiburuakApp(this);
    }

    public void xehetasunakErakutsi() throws IOException {
        xehetasunakKud.datuakSartu();
        stage.setScene(sceneXehetasunak);
        stage.show();
    }

    public void liburuakErakutsi(){
        stage.setScene(sceneLiburuak);
        stage.show();
    }

    public void isbnKudeatu(Book book){
        try {
            liburua = sarea.readFromUrl(book.getIsbn());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public Book getLiburua(){
        return this.liburua;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
