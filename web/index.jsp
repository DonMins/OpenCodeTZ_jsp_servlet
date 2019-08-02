<%@ page import="Task.Task" %>
<%@ page import="java.util.ArrayList" %><%--
<%--
  Created by IntelliJ IDEA.
  User: DonMin
  Date: 30.07.2019
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="font.css" type="text/css">
    <title> Игра быки и коровы </title>

    <script src="http://code.jquery.com/jquery-2.2.4.js"
            type="text/javascript"></script>
    <script src="js/app-ajax.js" type="text/javascript"></script>

</head>
<body>
<h1> Игра быки и коровы </h1>
<h2> Я загадал число, попробуй угадать его... </h2>


<table >
    <tr>
        <th style="width: 800px"> <textarea  readonly id="textarea"></textarea></th>
        <th style="width: 800px"> <textarea  readonly id="textareaHistory"></textarea></th>
    </tr>
    <tr>
        <th><div class="text">Поле для ввода числа:</div>
          <input class="input" type="text" name="str" id = "inputNumber" maxlength='4' minlength="4"
                      placeholder="Введите 4-х значное число" pattern="^[0-9]+$"  onkeyup="return proverka(this);"
                 onchange="return proverka(this);" require value="${param.str}"/> </th>
        <th><button  class="button" type="submit" id="history">Посмотреть историю</button></th>

    </tr>
    <tr>
        <th><button  class="button" type="submit"  id="toSend">Отправить</button></th>
        <th> <button  class="button" type="submit" id="clearHistory">Очистить историю</button></th>
    </tr>


</table>

</body>
</html>
