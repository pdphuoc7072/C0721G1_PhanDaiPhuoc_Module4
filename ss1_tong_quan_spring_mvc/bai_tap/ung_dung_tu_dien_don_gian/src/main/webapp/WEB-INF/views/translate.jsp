<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/22/2021
  Time: 9:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<html>
<head>
    <title>Title</title>
    <style>
        form input {
            height: 30px;
        }
        #inputWord {
            width: 200px;
        }
        #submit {
            background-color: cornflowerblue;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form method="post" action="/translate">
    <input  id="inputWord" type="text" name="wordSearch" placeholder="Enter your word: "><br>
    <input type="submit" id="submit" value="Search"><br>
    <h2>${result}</h2>
</form>
</body>
</html>
