<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <title>Hotels</title>
</head>
<body>
<p>Hotel page</p>
<a href="<c:url value="/home" />">home page</a>

	<div>
		<h2>Test</h2>
	</div>
	
	<input type="button" value="Add Room" 
    onclick="window.location.href='${pageContext.request.contextPath}/room/showFormForAdd/${hotelId}'; return false;"
    class="" /><!-- attribute class needed for style purposes -->
		
	<div>
		<table>
			<tr>
				<th>id</th>
				<th>capacity</th>
				<th>hotel id</th>
				<th>action</th>
			</tr>
			<c:forEach var="tempRoom" items="${rooms}">
    <!-- create update link for every hotel -->
    
    <!-- <c:url var="updateLink" value="/room/showformForUpdate">
        <c:param name="roomId" value="${tempRoom.id}"/>
    </c:url> -->

	<c:url var ="updateLink" value = "/room/showFormForUpdate/${tempRoom.id}">					
				</c:url>

    <tr>
        <td>${tempRoom.id}</td>
        <td>${tempRoom.capacity}</td>
        <td>${tempRoom.hotel.id}</td> <!-- Access hotel's id -->
        <td>           
            <a href="${updateLink}">Update</a>
        </td>
    </tr>  
</c:forEach>
		</table>
	</div>
	
	
	
</body>
</html>
 