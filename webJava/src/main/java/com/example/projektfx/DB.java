package com.example.projektfx;

import javafx.scene.control.TextArea;

import java.sql.*;

public class DB {
    private final String HOST= "localhost";
    private final String PORT= "8889";
    private final String BD_NAME= "9.lesson ";
    private final String LOGIN= "root";
    private final String PASS= "root";

    private Connection dbConn=null;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException { //оформляем подключение
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + BD_NAME;//строка для подключения к серверу, к определенному порту с определенным именем
        Class.forName("com.mysql.cj.jdbc.Driver");//какую технологию используем

        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);//типа регистрация соединения
        return dbConn;
    }

        public void isConnection() throws SQLException, ClassNotFoundException {
            dbConn= getDbConnection();
            System.out.println(dbConn.isValid(1000));//выводит подключились ли мы к базе данных за секунду или нет
        }

        public boolean isExistUser(String login) {
            String sql = "SELECT `id` FROM `users` WHERE `login`=?";

            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql);
                preparedStatement.setString(1, login);
                ResultSet resultSet = preparedStatement.executeQuery(); //производит выборку данных
                return resultSet.next(); //возвращает первую запись
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return false;//на случай, если не прошла операция с базой данных
        }

        public void regUser(String login, String email, String password ){
        String sql = "INSERT  INTO `users` (`login`, `email`, `password`) VALUES(? , ?, ?)";

            try {
                PreparedStatement preparedStatement= getDbConnection().prepareStatement(sql);
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, password);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    public  boolean authUser(String login, String password) {
        String sql = "SELECT `id` FROM `users` WHERE `login`=? AND `password`=?";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery(); //производит выборку данных
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ResultSet getArticles(){
        String sql = "SELECT `intro`, `title` FROM `articles`";
        Statement statement = null;
        try {
            statement = getDbConnection().createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addArticle(String title, String intro, String full_text_field) {
        String sql = "INSERT  INTO `articles` (`title`, `intro`, `text`) VALUES(? , ?, ?)";

        try {
            PreparedStatement preparedStatement= getDbConnection().prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, intro);
            preparedStatement.setString(3, full_text_field);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
