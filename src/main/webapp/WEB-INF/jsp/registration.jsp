<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Tour</title>
</head>
<body>
<h2>Register to Spring Tour</h2><br>

<br>

<form:form method="post" action="registered" modelAttribute="user"><br><br>
    Name: <form:input type="text" path="name"/><br><br>
    Surname: <form:input type="text" path="surname"/><br><br>
    Email: <form:input type="email" path="email"/><br><br>
    Login: <form:input type="text" path="username"/>
    <form:errors path="username"/><br><br>
    Password: <form:input type="password" path="password"/><br><br>
    Enter password again: <form:input type="password" path="checkPassword"/>
    <form:errors path="password"/><br><br>
    <input type="submit" value="Register"/><br>
</form:form>
</body>
</html>
