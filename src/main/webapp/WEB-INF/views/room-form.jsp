<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <title>Save room</title>
</head>
<body>
	
	<form:form action="saveRoom" modelAttribute="room" method="POST">
		<table>
			<tbody>
				<tr>
					<td><label>Capacity:</label></td>
					<td><form:input path="capacity"/></td>					
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