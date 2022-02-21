package com.example.projektfx.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import com.example.projektfx.DB;
import com.example.projektfx.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ArticlesPanelController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exit_btn, add_article_btn;

    @FXML
    private VBox panelVBox;



    @FXML
    void initialize() throws SQLException, IOException {

            DB db = new DB();
            ResultSet resultSet = db.getArticles(); // возвращает все статьи из базы данных
            while(resultSet.next()){


           // Button button = new Button("Button ");
           // button.setId("new_btn");
           // HBox hbox = new HBox();//объкт помогает расположить объекты по горизонтали
           // hbox.getChildren().add(button);
            // hbox.setAlignment(Pos.BASELINE_CENTER);//объекты распологаются четко по центру
            //Node node= null; // Oбъект node является родительским для всех наших объектов

               Node node = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("article.fxml")));//подгружаем файл с дизайном.

                Label title= (Label) node.lookup("#title"); //предназначен для создания не редактируемых текстовых полей(позволяет совершать такие методы как setText())
                // lookup-- поиск элемента по id
                Label intro= (Label) node.lookup("#intro");
                title.setText(resultSet.getString("title"));//подставляем значение из бд под названием title
                intro.setText(resultSet.getString("intro"));

                node.setOnMouseEntered(event -> {
                    node.setStyle("-fx-background-color: #707173");
                });//при наведении на графический элемент
                node.setOnMouseExited(event -> {
                    node.setStyle("-fx-background-color: #343434");
                });//при уберании мыши с объекта


            panelVBox.getChildren().add(node);// добавление нового объекта (кнопки, которая расположена четко по центру) в VBox
            panelVBox.setSpacing(10);//доп отступы между объектами
        }



        exit_btn.setOnAction(event -> {
            try {
                exitUser(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

add_article_btn.setOnAction(event -> {
    //переводим пользователя на новую страницу
    Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();// получаем открытую сцену, открытое окно. После преобразуем к классу Stage
    try {
        HelloApplication.setScene("add_article.fxml", stage);
    } catch (IOException e) {
        e.printStackTrace();
    }
});

    }

    private void exitUser(ActionEvent event) throws IOException {
        File file = new File("user.settings");
        file.delete();//удаляем файл перед выходом


        //переводим пользователя на новую страницу
        Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();// получаем открытую сцену, открытое окно. После преобразуем к классу Stage
        HelloApplication.setScene("main.fxml", stage);

    }

}
