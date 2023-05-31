<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <title>Save Booking</title>
</head>
<body>
	
	<form:form action="${pageContext.request.contextPath}/booking/saveBooking" modelAttribute="booking" method="POST">
		<table>
			<tbody>
				<tr>
					<td><label>Booked since (enter in format 'yyyy-mm-dd'):</label></td>
					<td><form:input path="bookedSince"/></td>					
				</tr>
				
				<tr>
					<td><label>Booked to (enter in format 'yyyy-mm-dd'):</label></td>
					<td><form:input path="bookedTo"/></td>					
				</tr>
						
				<tr>				
					<td><form:input type="hidden" path="room"/></td>					
				</tr>
				
				<tr>				
					<td><form:input type="hidden" path="user"/></td>					
				</tr>	
						
				<tr>				
					<td><form:input type="hidden" path="id"/></td>					
				</tr>
			
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save"/></td>					
				</tr>
			
			</tbody>
		</table>
	</form:form>
	
	<a href="${pageContext.request.contextPath}/booking/list">Back to List</a>
	
</body>
</html>