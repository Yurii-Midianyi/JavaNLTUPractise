<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <title>Save Booking</title>
</head>
<body>
	
	<form action="${pageContext.request.contextPath}/booking/saveBooking" method="POST">
		<table>
			<tbody>
				 
				<tr>
					<td><label>bookedSince:</label></td>
					<td><input type="date" name="bookedSince"></td>					
				</tr>
				
				<tr>
					<td><label>bookedTo:</label></td>
					<td><input type="date" name="bookedTo"></td>					
				</tr>
					
				<tr>
					<td><input type="hidden" name="roomId"  value="${roomId}"></td>					
				</tr>
									
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save"/></td>					
				</tr>
			
			</tbody>
		</table>
	</form>
	
	<a href="${pageContext.request.contextPath}/booking/list">Back to List</a>
	
</body>
</html>