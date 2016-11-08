<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <title>Orders</title>
</head>
<div align="center">
    <h3>Orders List</h3>

    <table border="1">
        <th width="40">No</th>
        <th width="100">Waiter</th>
        <th width="80">Table</th>
        <th width="140">Date</th>

        <c:forEach var="order" items="${listOrders}" varStatus="status">
            <tr>
                <td align="center">${status.index + 1}</td>
                <td align="center">${order.waiter.getName()}</td>
                <td align="center">${order.tableNumber}</td>
                <td align="center">${order.getDate()}</td>

            </tr>
        </c:forEach>
    </table>
    <br><br>
    <form><input type="button" value="Back" onclick="history.go(-1);return true;"></form>
</div>
</html>
