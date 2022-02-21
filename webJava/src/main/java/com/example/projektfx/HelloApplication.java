package com.example.projektfx;

import com.example.projektfx.models.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {

        DB db =new DB();


        File file = new  File("user.settings");
        if(file.exists()){
            // дисерелизация
            FileInputStream fis = new FileInputStream("user.settings");
            ObjectInputStream ois = new ObjectInputStream(fis);
            User user = (User) ois.readObject();
            ois.close();

            if(db.isExistUser(user.getLogin())){
                setScene("articles-panel.fxml", stage);
            }else {
                setScene("main.fxml", stage);
            }
        }else setScene("main.fxml", stage);

    }

    public static void main(String[] args) {
        launch();
    }

    public static void setScene(String sceneName, Stage stage) throws IOException{
        //переводим пользователя на новую страницу
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(sceneName));//подгружаем файл с дизайном
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);//создали сцену
        stage.setTitle("Program");
        stage.setScene(scene);
        stage.show();
    }
}