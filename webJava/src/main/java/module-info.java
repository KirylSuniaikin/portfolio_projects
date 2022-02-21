 module com.example.projektfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;//подключение sql
     requires mysql.connector.java;//подключение sql

    opens com.example.projektfx to javafx.fxml;
    exports com.example.projektfx;
     exports com.example.projektfx.controllers;
     opens com.example.projektfx.controllers to javafx.fxml;
     exports com.example.projektfx.models;
     opens com.example.projektfx.models to javafx.fxml;
 }