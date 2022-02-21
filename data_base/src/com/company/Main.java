package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
	DB db = new DB();
        try {
            //db.isConnection();// проверили контакт
            //db.createTable("users");//вызвали метод создания таблицы
            //db.insertArticle("Новая статься", "Текст статьи", "12.11.2025", "Admin1");
            //db.insertArticle("New post", "Some new post", "21.8.2025", "Admin2");
            //db.insertArticle("New post 2", "Some new post 2", "13.12.2025", "Admin3");
            //db.insertArticle("Google рулит", "Пост про гугл", "23.1.2025", "Moderator");
            //db.updateArticles();
            db.deleteSomething();
            //db.getArticles("articles");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
