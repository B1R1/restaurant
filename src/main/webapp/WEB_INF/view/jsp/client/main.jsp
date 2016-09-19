<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<h1>Main information</h1>
<p><b>${name}</b></p>
<p><b>${address}</b></p>
<p><b>${phone}</b></p>
<p><b>${email}</b></p>
<p></p>
<h1>Menu</h1>

<table style="align-items: center">
    <tr>
        <th>Dish</th>
        <th>Surname</th>
        <th>Position</th>
    </tr>
    <c:forEach items="${currentMenu}" var="employee">
        <tr>
            <td><a href="/employee?employeeName=${employee.name}"> ${employee.name}</a></td>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.position}</td>
        </tr>
    </c:forEach>
</table>

<p></p>
<input action="action" type="button" onclick="history.go(-1);"/>
</body>
</html>
