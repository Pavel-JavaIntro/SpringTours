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
            alert('Are you really going to change the status?')
            elmnt.form.submit()
        }
    </script>
</head>
<body>
<h3>Spring Bookingss</h3>
<a href="springtours"> Back to All Tours </a><br><br>
<form action="springbookings">
    <table>
        <tr>
            <td><b>Tourist Id</b></td>
            <td><b>Tour Id</b></td>
            <td><b>Is Paid</b></td>
        </tr>
        <c:forEach items="${bookings}" var="booking">
            <tr>
                <td>${booking.touristId}</td>
                <td>${booking.tourId}</td>
                <td><input type="checkbox" name="bookId" value="${booking.id}"
                    ${booking.paid == true?'checked="checked"' : ''} onchange="processUser(this)"/></td>
            </tr>
        </c:forEach>
    </table>
</form>
<br/>
<br/>
</body>
</html>
