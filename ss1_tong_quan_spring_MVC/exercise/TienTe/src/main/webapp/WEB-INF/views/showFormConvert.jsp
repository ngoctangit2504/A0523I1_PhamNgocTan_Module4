<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 1/10/2024
  Time: 7:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Convert USD to VND:</h2>
<hr>
<form action="convert" method="post">

    <p><label for="usdId">USD:</label>
        <input type="number" placeholder="USD" name="usd" id="usdId"></p>

    <p> <label for="rateId">Rate:</label>
        <input type="number" placeholder="RATE..." name="rate" id="rateId"></p>
    <input type="submit" value="Convert">
</form>
</body>
</html>
