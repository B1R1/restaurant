<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contacts</title>
</head>
<div align="center">
    <h3>${name}</h3>
    <h3>${address}</h3>
    <h3>${phone}</h3>
    <h3>${email}</h3>
    <h3>${map}</h3>
    <img src="/WEB_INF/images/map.gif" />
    <p></p>
    <form><input type="button" value="Back" onclick="history.go(-1);return true;"></form>
</div>
</html>
