package com.example.projektfx.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.projektfx.DB;
import com.example.projektfx.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddArticleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea full_text_field;

    @FXML
    private TextArea intro_field;

    @FXML
    private TextField title_field;

    @FXML
    void addArticle(ActionEvent event) {
        String title = title_field.getCharacters().toString();//получаем все символы из поля
        String text = full_text_field.getText();
        String intro =  intro_field.getText();

        title_field.setStyle("-fx-border-color: #fafafa" );
        intro_field.setStyle("-fx-border-color: #fafafa" );
        full_text_field.setStyle("-fx-border-color: #fafafa" );

        if (title.length() <= 5)
            title_field.setStyle( "-fx-border-color: #e06249");
        else if (intro.length() <= 10)
            intro_field.setStyle( "-fx-border-color: #e06249");
        else if (text.length() <= 15)
            full_text_field.setStyle( "-fx-border-color: #e06249");
        else {
            DB db = new DB();
            db.addArticle(title, intro,text);

            //переводим пользователя на новую страницу
            Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();// получаем открытую сцену, открытое окно. После преобразуем к классу Stage
            try {
                HelloApplication.setScene("articles-panel.fxml", stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void initialize() {


    }

}
