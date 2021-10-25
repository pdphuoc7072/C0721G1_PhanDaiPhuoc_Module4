<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/24/2021
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator" method="post">
    <div>
        <label for="firstNumber">First Number:</label>
        <input type="text" name="firstNumber" id="firstNumber">
    </div>
    <div>
        <label for="secondNumber">Second Number:</label>
        <input type="text" name="secondNumber" id="secondNumber">
    </div>
    <div>
        <button type="submit" name="calculate" value="+">Addition (+)</button>
        <button type="submit" name="calculate" value="-">Subtraction (-)</button>
        <button type="submit" name="calculate" value="*">Multiplication (*)</button>
        <button type="submit" name="calculate" value="/">Division (/)</button>
    </div>
    <c:if test="${requestScope['result'] != null}">
        <p>Result Division: <c:out value="${requestScope['result']}"/></p>
    </c:if>
</form>
</body>
</html>
