package ehu.isad.controllers;

import ehu.isad.Book;
import ehu.isad.Liburuak;
import ehu.isad.dbcontroller.ZerbitzuKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class LiburuKud implements Initializable {

    private Liburuak liburuakApp;

    @FXML
    private Button ikusiBotoia;

    @FXML
    private ComboBox<Book> liburuakComboB;

    public void initializeComboBox(){

        List<Book> liburuakList = ZerbitzuKud.getInstance().lortuZerbitzuak();
        ObservableList<Book> liburuak = FXCollections.observableArrayList(liburuakList);

        liburuakComboB.setItems(liburuak);
        this.setConverterComboBox();
        liburuakComboB.getSelectionModel().selectFirst();

    }

    private void setConverterComboBox(){
        liburuakComboB.setConverter(new StringConverter<Book>(){
            @Override
            public String toString(Book book){
                if(book==null){
                    return "";
                }
                return book.getTitle();
            }

            @Override
            public Book fromString(String string){
            return null;
            }
        });
    }

    public void setLiburuakApp(Liburuak liburuak) {
        this.liburuakApp = liburuak;
    }

    @FXML
    void onClick(ActionEvent event) throws IOException {
        Book book = liburuakComboB.getValue();
        try {
            liburuakApp.isbnKudeatu(book);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        liburuakApp.xehetasunakErakutsi();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.initializeComboBox();
    }
}

