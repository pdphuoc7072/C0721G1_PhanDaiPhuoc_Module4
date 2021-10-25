
<%@ page import="com.codegym.service.CustomerService" %>
<%@ page import="com.codegym.service.CustomerServiceFactory" %>
<%@ page import="com.codegym.model.Customer" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Information</title>
</head>
<body>
<form action="<c:url value="/customers"/>" method="post">
    <fieldset>
        <legend>Customer Information</legend>
        <input type="hidden" name="id" value="<c:out value='${customer.getId()}'/>">
        <table>
            <tr>
                <td>Id</td>
                <td>
                    ${customer.getId()}
                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" name="name" value="<c:out value='${customer.getName()}'/>">
                </td>
            </tr>
            <tr>
                <td>Email</td>
                <td>
                    <input type="text" name="email" value="<c:out value='${customer.getEmail()}'/>">
                </td>
            </tr>
            <tr>
                <td>Address</td>
                <td>
                    <input type="text" name="address" value="<c:out value='${customer.getAddress()}'/>">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<a href="/customers">Back to list</a>.
</body>
</html>
