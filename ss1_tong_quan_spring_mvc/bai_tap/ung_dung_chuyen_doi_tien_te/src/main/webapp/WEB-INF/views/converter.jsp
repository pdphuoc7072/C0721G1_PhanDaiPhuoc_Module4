<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/22/2021
  Time: 7:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert Money</title>
</head>
<body>
<h2>Currency Converter</h2>
<form method="post" action="/converter">

    <label>USD:</label><br>
    <input type="text" name="usd" placeholder="Enter USD" required><br>

    <label>VND:</label><br>
    <select name="vnd" id="vnd">
        <option value="23000" selected>VND</option>
    </select>
    <br>
    <input type="submit" id="submit" value="Converter">
    <br>
    <h2>${result}</h2>
</form>
</body>
</body>
</html>
