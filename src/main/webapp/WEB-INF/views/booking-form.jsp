<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css?version=51" />" rel="stylesheet">
    <title>Save room</title>
</head>
<body>
	
	<form:form action="${pageContext.request.contextPath}/booking/saveBooking" modelAttribute="booking" method="POST">
		<table>
			<tbody>
				<tr>
					<td><label>booked since:</label></td>
					<td>
						<form:input type="date" path="bookedSince"/>
						<form:errors path="bookedSince" cssClass="form-error"/>
					</td>					
				</tr>
				
				<tr>
					<td><label>booked to:</label></td>
					<td>
						<form:input type="date" path="bookedTo"/>
						<form:errors path="bookedTo" cssClass="form-error"/>
					</td>					
				</tr>
				
				<tr>				
					<td><form:input type="hidden" path="enabled" value="true"/></td>					
				</tr> 	
				
				<tr>				
					<td><form:input type="hidden" path="room.id"/></td>					
				</tr> 
				
				<tr>				
					<td><form:input type="hidden" path="user.id"/></td>					
				</tr>
			
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save"/></td>					
				</tr>
			
			</tbody>
		</table>
	</form:form>
	
	<a href="${pageContext.request.contextPath}/home">Back to Home</a>
	
</body>
</html>