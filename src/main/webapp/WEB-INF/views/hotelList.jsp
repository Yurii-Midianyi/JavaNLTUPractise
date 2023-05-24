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
	
	<div>
		<table>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>country</th>
				<th>action</th>
			</tr>
			<c:forEach var="tempHotel" items="${hotels}">
				
			  	<!-- create update link for every hotel -->
				<!--<c:url var ="updateLink" value = "/hotel/formForUpdate">
					<c:param name="hotelId" value ="${tempHotel.id}"/>
				</c:url>-->
				
				<!-- create link to get list of rooms for every hotel -->
						
				<c:url var ="roomListLink" value = "/room/list/${tempHotel.id}">					
				</c:url>
			
				<tr>
					<td>${tempHotel.id}</td>
					<td>${tempHotel.hotelName}</td>
					<td>${tempHotel.country}</td>
					<td>
						<a href="${roomListLink}">Rooms</a>
						<!--<a href="${updateLink}">Update</a>-->
					</td>
				</tr>				
									
			</c:forEach>
		</table>
	</div>
	
</body>
</html>
 