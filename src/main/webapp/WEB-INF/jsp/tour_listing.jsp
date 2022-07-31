<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/31/2022
  Time: 6:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Spring Tour</title>
</head>
<body>
<h3>Choose Your Spring Tour!</h3>
<form action="springtours/book">
<table>
    <tr>
        <td> <b>Tour Description</b> </td>
        <td> <b>Tour Type </b></td>
        <td> <b> Price </b></td>
        <td> <b>Available for Booking </b></td>
        <td> <b>Start Date </b></td>
        <td> <b>End Date </b></td>
        <td> <b></b>Status </td></td>
        <td> <b></b>Booking </td></td>
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
                <button name="booking" value="${tour.id}">Book Now!</button>
            </td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>
