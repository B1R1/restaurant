<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contacts</title>
</head>
<body>
<h2>${name}</h2>
<h2>${address}</h2>
<h2>${phone}</h2>
<h2>${email}</h2>
<h2>${map}</h2>
<img src="/WEB_INF/images/map.gif" />
<p></p>
<input action="action" type="button" onclick="history.go(-1);"/>
</body>
</html>
