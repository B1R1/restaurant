<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New/Edit Ingredient</title>
</head>
<body>
<div align="center">
    <h3>New/Edit Dish</h3>

    <form:form action="saveIngredient" method="post" modelAttribute="ingredient">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="dishName" /></td>
            </tr>
            <tr>
                <td>Category:</td>
                <td><form:input path="category" /></td>
            </tr>
            <tr>
                <td>Weight:</td>
                <td><form:input path="weight" /></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><form:input path="price" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
    <form><input type="button" value="Cancel" onclick="history.go(-1);return true;"></form>
</div>
</body>
</html>