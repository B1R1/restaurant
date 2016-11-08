<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>New/Edit Contact</title>
</head>
<body>


    <div align="center">
        <h2>New/Edit Ingredient</h2>

        <form:form action="saveContact" method="post" modelAttribute="contact">
            <table>
                <form:hidden path="id"/>
                <tr>
                    <td>Name:</td>
                    <td><form:input path="name" /></td>
                </tr>
                <tr>
                    <td>Amount:</td>
                    <td><form:input path="amount" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Save"></td>
                </tr>
            </table>
        </form:form>

    </div>
</body>





<%--<form:form modelAttribute="ingredient" method="POST" action="/ingredient">--%>

    <%--<div class="panel panel-default">--%>
        <%--<div class="panel-body"><h2>Ingredient<span class="glyphicon glyphicon-stats"></span></h2></div>--%>
        <%--<div class="panel-body">--%>
            <%--<div class="form-group">--%>
                <%--<label for="id">Id:</label>--%>
                <%--<form:input type="text" class="form-control" path="id" readonly="true"/>--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
                <%--<label for="ingredient">Name:</label>--%>
                <%--<form:select path="ingredient.id" id="ingredient" items="${ingredients}" itemValue="id" itemLabel="name"/>--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
                <%--<label for="quantity">Amount:</label>--%>
                <%--<form:input type="number" class="form-control" path="quantity"/>--%>
            <%--</div>--%>

            <%--<p class="text-right">--%>

                <%--<button type="submit" class="btn btn-success custom-width">OK</button>--%>
                <%--<a href="/ingredients" class="btn btn-danger custom-width" role="button">Cancel</a>--%>

            <%--</p>--%>
        <%--</div>--%>
    <%--</div>--%>

<%--</form:form>--%>

</html>


