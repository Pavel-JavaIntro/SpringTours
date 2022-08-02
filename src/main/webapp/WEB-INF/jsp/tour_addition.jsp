<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Spring Tour</title>
</head>
<body>
<h2>New Spring Tour</h2><br>

<a href="../springtours"> Back to All Tours </a><br><br>
<h3> Tour Types </h3>
<table>
    <tr>
        <td>
            <b>Type id</b>
        </td>
        <td>
            <b>Description</b>
        </td>
    </tr>
    <c:forEach items="${tourTypes}" var="tourType">
        <tr>
            <td>
                ${tourType.id}
            </td>
            <td>${tourType.description}
            </td>
        </tr>
    </c:forEach>
</table><br><br>
<h3>Add Tour</h3>

<form:form method="post" action="added" modelAttribute="tour"><br><br>
    Description: <form:input type="text" path="description"/><br><br>
    Tour Type: <form:input type="number" path="tourType.id"/><br><br>
    Capacity: <form:input type="number" path="capacity"/><br><br>
    Start Date: <form:input type="date" path="startDate"/><br><br>
    Start Date: <form:input type="date" path="endDate"/><br><br>
    Price: <form:input type="number" path="price"/><br><br>
    <input type="submit" value="Add Tour"/><br>
</form:form>
</body>
</html>
