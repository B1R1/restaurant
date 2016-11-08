<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <title>Ingredients Manager</title>
</head>
<body>
<div align="center">
    <h3>Storage Ingredients List</h3>

    <h4><a href="/newIngredient">New Ingredient</a></h4>

    <h4><a href="/endingIngredient">Ending ingredients</a></h4>

    <table border="1">
        <th width="40">No</th>
        <th width="100">Name</th>
        <th width="80">Amount</th>
        <th width="100" >Action</th>

        <c:forEach var="ingredient" items="${listIngredient}" varStatus="status">
            <tr>
                <td align="center">${status.index + 1}</td>
                <td align="center">${ingredient.name}</td>
                <td align="center">${ingredient.quantity}</td>
                <td align="center">
                    <a href="/editIngredient?id=${ingredient.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/deleteIngredient?id=${ingredient.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>

        <c:forEach var="ingredient" items="${endingIngredient}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${ingredient.name}</td>
                <td>${ingredient.quantity}</td>
                <td>
                    <a href="/editIngredient?id=${ingredient.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/deleteIngredient?id=${ingredient.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
    <p></p>
    <form><input type="button" value="Back" onclick="history.go(-1);return true;"></form>
</div>
</body>
</html>
