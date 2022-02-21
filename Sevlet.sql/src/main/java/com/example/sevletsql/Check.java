package com.example.sevletsql;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/chek")// указываем какой url адресс мы отслеживаем
public class Check extends HttpServlet  {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {//будет срабадывать каждый раз, когда будут передаваться данные на url адрес /chek
        String url= "/check.jsp";//файл который будет открываться при заходе на такую страницу как /chek

        String itemName= req.getParameter("item_name");//получаем значение, которое ввел пользователь в поле с именем item_name
        int price= Integer.parseInt(req.getParameter("price"));
        String info= req.getParameter("info");

        req.setAttribute("itemName", itemName );//передача полученных данных на страничку check.jsp
        req.setAttribute("price", price );//передача полученных данных на страничку check.jsp
        req.setAttribute("info", info );//передача полученных данных на страничку check.jsp

        //item item = new item(itemName,price,info);
        ItemService.add(new item(itemName,price,info));//добавление данного в базу данных

        getServletContext().getRequestDispatcher(url).forward(req, resp);//открываем сам по себе шаблон и передаем параметры
    }
}
