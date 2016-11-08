<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Dishes Manager</title>
</head>
<div align="center">
    <h3>Dishes List</h3>

    <h4><a href="/newDish">New Dish</a></h4>

    <table border="1">
        <th width="40">No</th>
        <th width="100">Name</th>
        <th width="80">Category</th>
        <th width="80">Price</th>
        <th width="80">Weight</th>
        <th width="100" >Action</th>

        <c:forEach var="dish" items="${listDishes}" varStatus="status">
            <tr>
                <td align="center">${status.index + 1}</td>
                <td align="center">${dish.dishName}</td>
                <td align="center">${dish.category}</td>
                <td align="center">${dish.price}</td>
                <td align="center">${dish.weight}</td>
                <td align="center">
                    <a href="/editDish?id=${dish.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/deleteDish?id=${dish.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br><br>
    <form><input type="button" value="Back" onclick="history.go(-1);return true;"></form>
</div>
</html>
