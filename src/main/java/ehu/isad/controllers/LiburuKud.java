package ehu.isad.controllers;

import ehu.isad.Book;
import ehu.isad.Liburuak;
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
import java.util.ResourceBundle;

public class LiburuKud implements Initializable {

    private Liburuak liburuakApp;

    @FXML
    private Button ikusiBotoia;

    @FXML
    private ComboBox<Book> liburuakComboB;

    public void initializeComboBox(){
        this.setConverterComboBox();
        ObservableList<Book> books = FXCollections.observableArrayList();
        books.addAll(
                new Book("1491910399", "R for Data Science"),
                new Book("1491946008", "Fluent Python"),
                new Book("9781491906187", "Data Algorithms")
        );
        liburuakComboB.setItems(books);
        liburuakComboB.setEditable(false);
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
    void onClick(ActionEvent event) {
        Book book = liburuakComboB.getValue();
        liburuakApp.isbnKudeatu(book);
        liburuakApp.xehetasunakErakutsi();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.initializeComboBox();
    }
}

