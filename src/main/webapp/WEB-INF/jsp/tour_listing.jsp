<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
<br><a href="users/account">My Account</a><br><br>
<security:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
    <br><a href="users">All Users</a><br><br>
    <br><a href="springtours">Add Tour</a><br><br>
    <br><a href="bookings">Edit Bookings</a><br><br>
</security:authorize>
<security:authorize access="hasRole('ADMIN')">
    <br><a href="springauthorities">Edit Authorities</a><br><br>
</security:authorize>
<form action="springtours/book">
    <table>
        <tr>
            <td><b>Tour Description</b></td>
            <td><b>Tour Type </b></td>
            <td><b> Price </b></td>
            <td><b>Available for Booking </b></td>
            <td><b>Start Date </b></td>
            <td><b>End Date </b></td>
            <td><b>Status</b></td>
            <td><b>Booking</b></td>
            <security:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
            <td><b>Change Status</b></td>
            </security:authorize>
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
                    <button name="booking" value="${tour.id}"
                        ${(tour.capacity-tour.booked <= 0)
                                || (tour.tourStatus.equals(by.pavka.springtour.model.TourStatus.CANCELLED))?
                                'disabled="disabled"':''}>Book Now!
                    </button>
                </td>
                <security:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
                    <td><b>Change Status</b></td>
                </security:authorize>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
