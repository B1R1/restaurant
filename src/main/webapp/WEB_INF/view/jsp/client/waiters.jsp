<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Waiters</title>
</head>
<div align="center">
    <h3>Our Waiters</h3>

    <table style="align-items: center">
        <tr>
            <th>Name</th>
        </tr>
        <c:forEach items="${waiters}" var="waiter">
            <c:if test="${waiter.position == 'WAITER'}">
                <tr>
                    <td>${waiter.name}</td>
                    <td>${waiter.getPhoto()}</td>
                    <td><img src="/WEB_INF/images/waiters/2.jpg" width="100" height="100" align: right></td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
    <p></p>
    <form><input type="button" value="Back" onclick="history.go(-1);return true;"></form>

    <%--КНОПКА ВІБОР --%>

    <%--<form:form method="post" commandName="selectedEmployees">--%>
        <%--<form:select path="id">--%>
            <%--<form:options items="${employeeList}" itemValue="id" itemLabel="name" />--%>
        <%--</form:select>--%>
        <%--<button class="btn btn-reg">SUBMIT</button>--%>
    <%--</form:form>--%>
</div>
</html>
