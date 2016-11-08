<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Ingredients</title>
</head>
<body>

    <button type="button">Add new</button>

    <div class="container">
        <h2>Storage: list of ingredients for dishes</h2>

    <form:form id="searchForm" action="./ingredients/search/${name}" method="get">
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="name" name="name"/>
                </div>
                <div class="col-sm-6">
                    <button class="btn btn-default" type="submit"><span
                            class="glyphicon glyphicon-search"></span>Find
                    </button>
                    <a href="/ingredient" class="btn btn-warning" role="button">Add new</a>
                    <a href="/ingredients/runningout" class="btn btn-info" role="button">Running Out</a>
                </div>
            </div>
        </form>
    </form:form>

        <a href="/ingredients/runningout" class="btn btn-info" role="button">Running Out</a>

    <table class="tg" border="1">
        <thead>
        <tr>
            <th width="80" align="left">Id</th>
            <th width="120" align="left">Name</th>
            <th width="80" align="left">Amount</th>
            <th width="80" align="left">Edit</th>
            <th width="80" align="left">Delete</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="ingredient" items="${ingredients}">
            <tr>
                <td>${ingredient.id}</td>
                <td>${ingredient.name}</td>
                <td>${ingredient.quantity}</td>
                <td><a href="<c:url value='/ingredients/edit/${ingredient.getId()}'/>"
                       class="btn btn-success" role="button">Edit</a></td>
                <td><a href="<c:url value='/ingredients/delete/${ingredient.getId()}'/>"
                       class="btn btn-danger" role="button">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>


</body>
</html>
