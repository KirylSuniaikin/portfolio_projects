package com.company;
import java.sql.*;

public class DB {
    private final String HOST= "localhost";
    private final String PORT= "8889";
    private final String BD_NAME= "java.bd";
    private final String LOGIN= "root";
    private final String PASS= "root";

    private Connection dbConn=null;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException { //оформляем подключение
        String connStr="jdbc:mysql://" + HOST + ":" + PORT + "/" + BD_NAME;//строка для подключения к серверу, к определенному порту с определенным именем
       Class.forName("com.mysql.cj.jdbc.Driver");//какую технологию используем

        dbConn= DriverManager.getConnection(connStr, LOGIN, PASS );//типа регистрация соединения
        return  dbConn;
    }

    public void isConnection() throws SQLException, ClassNotFoundException {
        dbConn= getDbConnection();
        System.out.println(dbConn.isValid(1000));//выводит подключились ли мы к базе данных за секунду или нет
    }


    //создание таблицы в коде
public void createTable(String tableName) throws SQLException, ClassNotFoundException{
  String sql=" CREATE TABLE IF NOT EXISTS " + tableName                                          // создаем таблицу, если такая не сущесвует
             + " (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), password VARCHAR(100))" // AUTO_INCREMENT значит при каждом дальнейшем добавлении, это поле будет увеличиваться на 1
             + " ENGINE=MYISAM;";
  Statement statement = getDbConnection().createStatement();// функция создает объект на основе класса statement+ объект содержит подключение кбазе данных
  statement.executeUpdate(sql);// таким образом и будет выполнена sql команда
  }

  //добавлений данных в таблицу
  public void insertArticle( String ttile, String text, String date, String avtor) throws SQLException, ClassNotFoundException{
        String sql= "INSERT INTO `articles` (title, text, date, avtor) VALUES(?,?,?,?)";
      PreparedStatement prSt= getDbConnection().prepareStatement(sql);// PreparedStatement тоже что и Statement, только еще и для добавления данных
      prSt.setString(1, ttile );//вписываем данные(позиция данного, само данное)
      prSt.setString(2, text );
      prSt.setString(3, date );
      prSt.setString(4, avtor );
      prSt.executeUpdate();
    }


    //Выборка данных
    public void getArticles(String table) throws SQLException, ClassNotFoundException{
    //String sql= " SELECT *  FROM " + table + " WHERE `id` <> 2 ";//WHERE - условие, <> - значит не равно(!=)
        String sql= " SELECT *  FROM " + table + " WHERE `title` LIKE 'New%'  ORDER BY `id` DESC LIMIT 2 OFFSET 1";//DESC - сортировка в обратном порядке, ASC - сортировка по возрастанию, LIMIT- создает лимит, OFFSET- сколько первых записей пропускаем
       // String sql= " SELECT *  FROM " + table + " WHERE `title` LIKE 'New%' AND `id`<4 ";// LIKE-имеет подобие
        Statement statement = getDbConnection().createStatement();// функция создает объект на основе класса statement+ объект содержит подключение кбазе данных
    ResultSet res= statement.executeQuery(sql);// запрос позволит выполнить запрос и вернуть данные, которые сохраним в переменную
        while (res.next()){
            System.out.println(res.getString("title"));
           // System.out.println(res.getString("text" ));
        }
    }


    //обновление данных
    public void updateArticles() throws SQLException, ClassNotFoundException{
        String sql= "UPDATE `articles` SET `title`= ? WHERE `id`=2 ";
        PreparedStatement prSt= getDbConnection().prepareStatement(sql);// PreparedStatement тоже что и Statement, только еще и для добавления данных
        prSt.setString(1, "Новая обнавленная статья" );//вписываем данные(позиция данного на вводе, само данное)
        prSt.executeUpdate();// обновляет данные
    }

    //удаление данных
    public void  deleteSomething()throws SQLException, ClassNotFoundException{
        //String sql= " DELETE FROM `articles` WHERE `id`=4 ";//удаляет элемент с id =4
        String sql= " DROP TABLE `articles`";//удаляет таблицу
        Statement statement = getDbConnection().createStatement();// функция создает объект на основе класса statement+ объект содержит подключение кбазе данных
        statement.executeUpdate(sql);// таким образом и будет выполнена sql команда
    }

}
