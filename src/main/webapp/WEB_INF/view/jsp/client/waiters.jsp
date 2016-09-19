<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Waiters</title>
</head>
<body>
<h2>Our Waiters</h2>

<table style="align-items: center">
    <tr>
        <th>Name</th>
    </tr>
    <c:forEach items="${waiters}" var="waiter">
        <c:if test="${waiter.position == 'WAITER'}">
            <tr>
                <td>${waiter.name}</td>
                <td><img src="/WEB_INF/images/waiters/lebovski.jpg" width="100" height="100" align: right></td>
            </tr>
        </c:if>
    </c:forEach>
</table>
<p></p>
<input action="action" type="button" onclick="history.go(-1);"/>

<%--КНОПКА ВІБОР --%>

<%--<form:form method="post" commandName="selectedEmployees">--%>
    <%--<form:select path="id">--%>
        <%--<form:options items="${employeeList}" itemValue="id" itemLabel="name" />--%>
    <%--</form:select>--%>
    <%--<button class="btn btn-reg">SUBMIT</button>--%>
<%--</form:form>--%>
</body>
</html>
