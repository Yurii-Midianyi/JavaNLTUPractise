<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>   
    <title>User list</title>
</head>
<body>

<input type="button" value="Add Booking" 
    onclick="window.location.href='${pageContext.request.contextPath}/booking/showFormForAdd'; return false;"
    class="" /><!-- attribute class needed for style purposes -->
<div>
	<table>
		<tr>
			<th>id</th>
			<th>booked_since</th>
			<th>booked_to</th>
			<th>room Id</th>
			<th>User</th>
		</tr>
		<c:forEach var="tempBooking" items="${bookings}">
			<tr>
				<td>${tempBooking.id}</td>
				<td>${tempBooking.bookedSince}</td>
				<td>${tempBooking.bookedTo}</td>
				<td>${tempBooking.room.id}</td>
				<td>${tempBooking.user.username}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>