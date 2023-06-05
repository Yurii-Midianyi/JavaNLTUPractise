<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css?version=51" />" rel="stylesheet">
    <title>Save room</title>
</head>
<body>
	
	<form:form action="${pageContext.request.contextPath}/room/saveRoom" modelAttribute="room" method="POST">
		<table>
			<tbody>
				<tr>
					<td><label>Capacity:</label></td>
					<td>
						<form:input path="capacity"/>
						<form:errors path="capacity" cssClass="form-error"/>
					</td>					
				</tr>
				
				<tr>
					<td><label>Room number:</label></td>
					<td>
						<form:input path="roomNumber"/>
						<form:errors path="roomNumber" cssClass="form-error"/>
					</td>					
				</tr>
				
				<tr>
					<td><label>enabled:</label></td>
					<td>
						<form:select path="enabled"> 
							<form:option value="true" label="true"/>  
        					<form:option value="false" label="false"/>  
						</form:select> 
					</td>					
				</tr>
				
				<tr>				
					<td><form:input type="hidden" path="hotel.id"/></td>					
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
	
	<a href="${pageContext.request.contextPath}/room/list/${hotelId}">Back to List</a>
	
</body>
</html>