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
            alert('Are you really going to change the role?')
            elmnt.form.submit()
        }
    </script>
</head>
<body>
<h3>Spring Authorities</h3>
<a href="springtours"> Back to All Tours </a><br><br>
<form action="springauthorities">
    <table>
        <tr>
            <td><b>Username</b></td>
            <td><b>Role Manager</b></td>
        </tr>
        <c:forEach items="${authorities}" var="authority">
            <c:if test="${authority.role!='ROLE_ADMIN'}">
            <tr>
                <td>${authority.username}</td>
                <td><input type="checkbox" name="authId" value="${authority.id}"
                    ${authority.role == 'ROLE_MANAGER'?'checked="checked"' : ''} onchange="processUser(this)"/>
                </td>
            </tr>
        </c:if>
        </c:forEach>
    </table>
</form>
</body>
</html>
