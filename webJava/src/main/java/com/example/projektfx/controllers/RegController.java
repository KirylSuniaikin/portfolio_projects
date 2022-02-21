package com.example.projektfx.controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import com.example.projektfx.DB;
import com.example.projektfx.HelloApplication;
import com.example.projektfx.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static com.example.projektfx.HelloApplication.setScene;

public class RegController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button auth_btn;

    @FXML
    private TextField auth_log;

    @FXML
    private PasswordField auth_pass;

    @FXML
    private Button reg_btn;

    @FXML
    private TextField reg_email;

    @FXML
    private TextField reg_log;

    @FXML
    private PasswordField reg_pass;

    @FXML
    private CheckBox reg_right;

    private DB db= new DB();

    @FXML
    void initialize() {
        reg_btn.setOnAction(event -> {
            registrationUser();
        });
        auth_btn.setOnAction(event -> {
            try {
                authUser(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    private void  authUser(ActionEvent event) throws IOException {
        String login = auth_log .getCharacters().toString();//получаем все символы из поля
        String password = auth_pass.getCharacters().toString();


        auth_log.setStyle("-fx-border-color: #fafafa" );
        auth_pass.setStyle("-fx-border-color: #fafafa" );

        if (login.length() <= 1)
            auth_log.setStyle( "-fx-border-color: #e06249");
        else if (password.length() <= 3)
            auth_pass.setStyle("-fx-border-color: #e06249");
        else if(!db.authUser(login, password) ){
            auth_btn.setText("User not exist");
        }
        else { 
            auth_log.setText("");
            auth_pass.setText("");
            auth_btn.setText("Successfully :)");

            //серилизация
            FileOutputStream fos = new FileOutputStream("user.settings");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new User(login));
            oos.close();



            //переводим пользователя на новую страницу
            Stage stage= (Stage) ((Node)event.getSource()).getScene().getWindow();// получаем открытую сцену, открытое окно. После преобразуем к классу Stage
            HelloApplication.setScene("articles-panel.fxml", stage);


        }
    }

    private void registrationUser() {
        String login = reg_log.getCharacters().toString();//получаем все символы из поля
        String email = reg_email.getCharacters().toString();
        String password =  reg_pass.getCharacters().toString();

        reg_log.setStyle("-fx-border-color: #fafafa" );
        reg_email.setStyle("-fx-border-color: #fafafa" );
        reg_pass.setStyle("-fx-border-color: #fafafa" );

        if (login.length() <= 1)
            reg_log.setStyle( "-fx-border-color: #e06249");
        else if (email.length() <= 5 || !email.contains("@") || !email.contains("."))
            reg_email.setStyle("-fx-border-color: #e06249");
        else if (password.length() <= 3)
            reg_pass.setStyle("-fx-border-color: #e06249");
        else if (!reg_right.isSelected())
            reg_btn.setText("Select checkbox");
        else if(db.isExistUser(login))
            reg_btn.setText("User exist");

        else {
            db.regUser(login, email, password);


            reg_log.setText("");
            reg_email.setText("");
            reg_pass.setText("");
            reg_btn.setText("Successfully :)");
        }
    }


    //кэширование данных(из пароль сделать точки зашифрованные )
     public static String md5String(String pass){
         MessageDigest messageDigest =null;// позволяет из обычной строки формировать кэш
         byte[] digest= new byte[0]; //будет хранить строку в байткоде

         try {
             messageDigest = MessageDigest.getInstance("MD5");// указываем метод кэширования
             messageDigest.reset();//очищаяем обект до пустого
             messageDigest.update(pass.getBytes());//преобразоввываем ее в байтовый формат
             digest = messageDigest.digest();// байты вложили в массив
         } catch (NoSuchAlgorithmException e) {
             e.printStackTrace();
         }
         BigInteger bigInteger = new BigInteger(1,digest);//преобразуем массив к одному общему числу
         String md5Hex = bigInteger.toString(16);// а здесь к строке

         while(md5Hex.length()<32)   //сам процесс переобрахования строки
             md5Hex = "0" + md5Hex;

         return md5Hex;
     }
}
