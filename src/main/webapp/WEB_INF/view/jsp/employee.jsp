<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
<h2>Employee details</h2>
    <table style="align-items: center">
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Position</th>
            <th>Phone Number</th>
            <th>Salary</th>
        </tr>
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.position}</td>
            <td>${employee.phoneNumber}</td>
            <td>${employee.salary}</td>
        </tr>
    </table>
</body>
</html>
