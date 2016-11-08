<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Admin</title>
</head>
<div align="center">
    <h3>See pages below</h3>
        <p><a href="/menus">Menus</a></p>
        <p><a href="/dishes">Dishes</a></p>
        <p><a href="/employees">Employees</a></p>
        <p><a href="/ingredients">Storage</a></p>
        <p><a href="/orders">Orders</a></p>
        <p></p>

        <form><input type="button" value="Back" onclick="history.go(-1);return true;"></form>
</div>
</html>
