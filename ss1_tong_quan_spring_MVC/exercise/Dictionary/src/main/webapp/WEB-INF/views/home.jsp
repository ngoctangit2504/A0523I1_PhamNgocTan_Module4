<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 1/10/2024
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tu Dien</title>
</head>
<body>
<h2>Google translate</h2>
<hr>
<form action="translate" method="post">
    <p><label for="english">English:</label>
        <input type="text" placeholder="Type some text..." name="english" id="english"></p>

    <p>Vietnamese: ${vietnamese}</p>
    <input type="submit" value="Translate">
</form>
</body>
</html>
