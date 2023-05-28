<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>   
    <title>User list</title>
</head>
<body>
<div>
	<table>
		<tr>
			<th>id</th>
			<th>booked_since</th>
			<th>booked_to</th>
			<th>room Id</th>
			<th>User Id</th>
		</tr>
		<c:forEach var="tempBooking" items="${bookings}">
			<tr>
				<td>${tempBooking.id}</td>
				<td>${tempBooking.bookedSince}</td>
				<td>${tempBooking.bookedTo}</td>
				<td>${tempBooking.room}</td>
				<td>${tempBooking.user}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>