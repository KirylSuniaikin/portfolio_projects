<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Java Web Site</title>
</head>
<body>
<h1> Форма добавлениня </h1>
<form action="chek" method="post"><!-- форма для ввода значений -->
  <input type="text" placeholder="Введите имя" name="item_name"><br>
  <input type="number" placeholder="Введите цену" name="price"><br>
  <input type="text" placeholder="Введите текст" name="info"><br>
  <button type="submit">Добавить</button><!-- странаица после нажатия на кнопку будет перезапускаться-->
</form>
</body>
</html>
