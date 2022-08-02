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
        function processUser(elmnt) {
            if (confirm('Are you really going to change the status?')) {
                elmnt.form.submit()
            }
        }
    </script>
</head>
<body>
<h3>Spring Tourists</h3>
<a href="springtours"> Back to All Tours </a><br><br>
<form action="users">
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
                <td><input type="checkbox" name="userId" value="${user.id}"
                    ${user.enabled == 1?'checked="checked"' : ''} onchange="processUser(this)"/></td>
            </tr>
        </c:forEach>
    </table>
</form>
<br/>
<br/>
</body>
</html>
