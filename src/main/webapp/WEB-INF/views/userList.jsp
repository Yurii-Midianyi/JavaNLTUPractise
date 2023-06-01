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
			<th>username</th>
			<th>password</th>
			<th>enabled</th>
			<th>role</th>
		</tr>
		<c:forEach var="tempUser" items="${users}">
			<tr>
				<td>${tempUser.id}</td>
				<td>${tempUser.username}</td>
				<td>${tempUser.password}</td>
				<td>${tempUser.enabled}</td>
				<td>${tempUser.role}</td>
				<td>
					<form method="GET" action="<c:url value="/booking/list/${tempUser.id}" />">
						<input type="submit" value="Show bookings">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>