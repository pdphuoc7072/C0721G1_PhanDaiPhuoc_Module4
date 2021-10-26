<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/25/2021
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Settings info</h3>
<table>
    <tr>
        <td>Languages: </td>
        <td>${emailSettings.languages}</td>
    </tr>
    <tr>
        <td>Page Size: </td>
        <td>${emailSettings.pageSize}</td>
    </tr>
    <tr>
        <td>Spam Filter: </td>
        <c:if test="${emailSettings.spamFilter == true}">
            <td>Enable spam filter</td>
        </c:if>
        <c:if test="${emailSettings.spamFilter == false}">
            <td></td>
        </c:if>
    </tr>
    <tr>
        <td>Signature: </td>
        <td>${emailSettings.signature}</td>
    </tr>
</table>
</body>
</html>
