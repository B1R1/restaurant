<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>

<h2>Menu details</h2>
<table style="align-items: center">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Dishes</th>
    </tr>
    <tr>
        <td>${menu.id}</td>
        <td>${menu.name}</td>
        <td>
            <c:forEach var="component" items="${menu.menuDishes}">
                ${component.dishName};
            </c:forEach>
        </td>
    </tr>
</table>


<%--<form:form modelAttribute="menu" method="POST" action="/menu" id="menuForm">--%>

<%--<div class="panel panel-default">--%>
    <%--<div class="panel-body"><h2>Menus <span class="glyphicon glyphicon-cutlery"></span></h2></div>--%>
    <%--<div class="panel-body">--%>
        <%--<div class="form-group">--%>
            <%--<label for="id">ID:</label>--%>
            <%--<form:input type="text" class="form-control" path="id" readonly="true"/>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<label for="name">Name:</label>--%>
            <%--<form:input type="text" class="form-control" path="name"/>--%>
        <%--</div>--%>

        <%--<table class="table">--%>
            <%--<thead>--%>
            <%--Dishes--%>
            <%--<button href="#" id="addDish" class="btn btn-info">--%>
                <%--<span class="glyphicon glyphicon-plus"></span>--%>
            <%--</button>--%>
            <%--<tr>--%>
                <%--<th>ID</th>--%>
            <%--</tr>--%>
            <%--</thead>--%>

            <%--<tbody id="menu">--%>
            <%--<c:forEach items="${menu.menuDishes}" var="Dish" varStatus="i" begin="0">--%>
                <%--<tr class="dish">--%>
                    <%--<td>--%>
                        <%--<!--<form:input path="components[${i.index}].id" id="$id{i.index}"/>-->--%>
                        <%--<form:select path="dishes[${i.index}].id" id="$id{i.index}" items="${allDishes}" itemValue="id" itemLabel="name"/>--%>

                    <%--</td>--%>
                    <%--<td>--%>
                        <%--<button href="#" class="removeDish btn btn-danger btn-sm"><span--%>
                                <%--class="glyphicon glyphicon-trash"></span></button>--%>
                    <%--</td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
                <%--&lt;%&ndash;--%>
                <%--IMPORTANT--%>
                <%--There must always be one row to allow the JavaScript to clone the row.--%>
                <%--If there is no row at all, it cannot possibly add a new row.--%>
                <%--&ndash;%&gt;--%>
            <%--<c:if test="${menu.dishes.size() == 0}">--%>
                <%--<tr class="dish defaultRow">--%>
                    <%--<td>--%>
                        <%--<!--<input type="text" name="components[0].id" value=""/>-->--%>
                        <%--<form:select path="dishes[0].id" id="$id{0}" items="${allDishes}" itemValue="id" itemLabel="name"/>--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--<button href="#" class="removeDish btn btn-danger btn-sm"><span--%>
                                <%--class="glyphicon glyphicon-trash"></span></button>--%>
                    <%--</td>--%>
                <%--</tr>--%>
            <%--</c:if>--%>
            <%--</tbody>--%>
        <%--</table>--%>

        <%--<p class="text-right">--%>
            <%--<button type="submit" class="btn btn-success custom-width">OK</button>--%>
            <%--<a href="/menus" class="btn btn-danger custom-width" role="button">Cancel</a>--%>
        <%--</p>--%>
    <%--</div>--%>
<%--</div>--%>

<%--</form:form>--%>

</body>
</html>