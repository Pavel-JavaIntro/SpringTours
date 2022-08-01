<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/3/2022
  Time: 6:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Spring Tour</title>
    <script type="text/javascript">
        var url = new URL("http://foo.bar/?x=1&y=2");

        // If your expected result is "http://foo.bar/?x=1&y=2&x=42"
        url.searchParams.append('x', 42);
    </script>
</head>
<body>
<h3>Spring Tourists</h3>
<a href="springtours"> Back to All Tours </a><br><br>
<form action="springtours">
    <table>
        <tr>
            <td><b>User Name</b></td>
            <td><b>User Surname </b></td>
            <td><b>User Email</b></td>
            <td><b>User Login</b></td>
            <td><b>Enabled</b></td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.email}</td>
                <td>${user.username}</td>
                <td><input type="checkbox" name="userId" value="${user.enabled}"
                           ${user.enabled == 1?'checked="checked"' : ''} onchange="this.form.submit()"/></td>
            </tr>
        </c:forEach>
    </table>
</form>
<br/>
<br/>
</body>
</html>
