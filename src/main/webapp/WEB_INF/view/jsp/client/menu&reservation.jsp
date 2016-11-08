<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Main</title>
</head>
<div align="center">
        <h3>Current Menu</h3>

        <table border="1">
            <th width="80">Dish</th>
            <th width="80">Weight</th>
            <th width="80">Price</th>

            <c:forEach items="${listDishes}" var="dish">
                <tr>
                    <%--<td><a href="/employee?employeeName=${employee.name}"> ${employee.name}</a></td>--%>
                        <td align="center">${dish.dishName}</td>
                        <td align="center">${dish.weight}</td>
                        <td align="center">${dish.price}</td>
                </tr>
            </c:forEach>
        </table>
        <br><br>

            <h4>Reservation information:</h4>
            <p><b>${name}</b></p>
            <p><b>${address}</b></p>
            <p><b>${phone}</b></p>
            <p><b>${email}</b></p>

        <form><input type="button" value="Back" onclick="history.go(-1);return true;"></form>
</div>
</html>
