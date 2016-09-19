<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>

<h2>Employees list</h2>

    <%--<table style="align-items: center">--%>
        <%--<tr>--%>
            <%--<th>Name</th>--%>
            <%--<th>Surname</th>--%>
            <%--<th>Position</th>--%>
            <%--<th>Phone Number</th>--%>
            <%--<th>Salary</th>--%>
        <%--</tr>--%>

        <%--<c:forEach items="${employees}" var="employee">--%>
            <%--<tr>--%>
                <%--<td>${employee.name}</td>--%>
                <%--<td>${employee.surname}</td>--%>
                <%--<td>${employee.position}</td>--%>
                <%--<td>${employee.phoneNumber}</td>--%>
                <%--<td>${employee.salary}</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
    <%--</table>--%>

    <table style="align-items: center">
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Position</th>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td><a href="/employee?employeeName=${employee.name}"> ${employee.name}</a></td>
                <td>${employee.name}</td>
                <td>${employee.surname}</td>
                <td>${employee.position}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
