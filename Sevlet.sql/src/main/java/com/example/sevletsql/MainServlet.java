package com.example.sevletsql;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")//значит что данный класс является сервлетом и в скобках указываем то что мы отслеживаем(здесь главная страница)
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {// метод будет срабатывать каждый раз, когда мы будем пероходить по главному адрессу
        resp.setContentType("text/html");//значит что пользователю в ответ покажешь либо текст либо html страницу
        PrintWriter printWriter = resp.getWriter();//с помощью этого объекта сможем сказать какой именно текст показывать пользователю
        printWriter.write("<h3>Hello user</h3>");
        printWriter.close();
    }


}
