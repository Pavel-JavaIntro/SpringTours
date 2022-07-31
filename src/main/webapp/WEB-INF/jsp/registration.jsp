<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Tour</title>
</head>
<body>
<h2>Register to Spring Tour</h2><br>
<%--<form action="" method="post">--%>
<%--    <label for="name">Enter your first name </label><input type="text" id="name" name="name" placeholder="Имя"/><br/>--%>
<%--    <label for="surname">Enter your surname </label><input type="text" id="surname" name="surname" placeholder="Surname"/><br/>--%>
<%--    <label for="email">Enter your corporate email ending with mycompany.com </label><input type="text" id="email" name="email" placeholder="Email"/><br/>--%>
<%--    <label for="username">Enter your login </label><input type="text" id="username" name="username" placeholder="Login"/><br/>--%>
<%--    <label for="password1">Enter your password </label><input type="password" id="password1" name="" placeholder="Password"/><br/>--%>
<%--    <label for="password2">Re-enter your password </label><input type="password" id="password2" name="password" placeholder="Repeat Password"/><br/>--%>
<%--    <input type="submit" value="Register"/>--%>
<%--</form>--%>
<br>
<br>

<form:form method="post" action="registered" modelAttribute="user"><br>
    Name: <form:input type="text" path="name"/><br>
    Surname: <form:input type="text" path="surname"/><br>
    Email: <form:input type="email" path="email"/><br>
    Login: <form:input type="text" path="username"/>
    <form:errors path="username"/><br>
    Password: <form:input type="password" path="password"/><br>
    Enter password again: <form:input type="password" path="checkPassword"/>
    <form:errors path="password"/><br>
    <input type="submit" value="Register"/><br>
</form:form>
</body>
</html>
