<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Customers</title>
    <style>
        table {
            border: 1px solid #000;
        }
        th, td {
            border: 1px dotted #555;
        }
    </style>
</head>
<body>
<p>There are <c:out value="${requestScope['customers'].size()}"/> customer(s) in list.</p>
<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${requestScope['customers']}">
        <tr>
            <td>
                <c:out value="${c.getId()}"/>
            </td>
            <td>
                <a href="<c:url value='/customers/${c.getId()}'/>">${c.getName()}</a>
            </td>
            <td>
                <c:out value="${c.getEmail()}"/>
            </td>
            <td>
                <c:out value="${c.getAddress()}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>