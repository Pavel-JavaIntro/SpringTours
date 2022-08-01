<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/25/2022
  Time: 11:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>

<a href="../springtours"> Back to All Tours </a>
<p>User Name: ${user.name}<br>
User Surname: ${user.surname}<br>
User Login: ${user.username}</p>

<form action="../springtours/cancel">
    <table>
        <tr>
            <td><b>Tour Description</b></td>
            <td><b>Tour Type </b></td>
            <td><b> Price </b></td>
            <td><b>Available for Booking </b></td>
            <td><b>Start Date </b></td>
            <td><b>End Date </b></td>
            <td><b>Status</b></td>
            <td><b>Cancellation</b></td>
        </tr>
        <c:forEach items="${tours}" var="tour">
            <tr>
                <td>${tour.description}</td>
                <td>${tour.tourType}</td>
                <td>${tour.price}</td>
                <td>${tour.capacity-tour.booked}</td>
                <td>${tour.startDate}</td>
                <td>${tour.endDate}</td>
                <td>${tour.tourStatus}</td>
                <td>
                    <button name="booking" value="${tour.id}">Cancel</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
