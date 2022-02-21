<%--
  Created by IntelliJ IDEA.
  User: kirillsunajkin
  Date: 09.11.2021
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
    <title>Check page</title>
</head>
<body>
    <h2>Данные из формы</h2>
<ul>
    <li>Название: ${itemName}</li><!-- вывод названия по имени переменной-->
    <li>Цена: ${price}</li>
    <li>Информация : ${info}</li>
</ul>
</body>
</html>
