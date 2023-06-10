<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <title>Hotel</title>
</head>
<body>
<p>${hotel.hotelName}</p>
<p>${hotel.id}</p>

<a href="<c:url value="/hotel/${hotel.id}/edit" />">Edit</a>
<a href="<c:url value="/room/list/${hotel.id}" />">Rooms</a>
<form method="POST" action="<c:url value="/hotel/${hotel.id}" />">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="Delete"/>
</form>

<h2>Find hotels for selected period</h2>
<form method="POST" action="<c:url value="/hotel/${hotel.id}" />">
   <span>since:</span>
   <input type="date" name="bSince">
   
   <span>to:</span>
   <input type="date" name="bTo">	
   
   <!-- To fix bug with disappearing hotel.id and hotel.hotelName values-->
   <input type="hidden" name="hotelName" value="${hotel.hotelName}" />
   <input type="hidden" name="hotelId" value="${hotel.id}" />
   
   <input type="submit" value="Search"/>	
</form>

<c:if test="${not empty errorMessage}">
    <div class="error-message">${errorMessage}</div>
</c:if>

<c:if test="${not empty rooms}">
	<div>
			<table>
				<tr>
					<th>id</th>
					<th>capacity</th>
					<th>room number</th>
					<th>hotel id</th>	
					<th>Action</th>
				</tr>
				
	<c:forEach var="tempRoom" items="${rooms}">
	<!-- create a booking link for every room -->
	<c:url var ="bookingLink" value = "/room/book/${tempRoom.id}">					
	</c:url>
	    <tr>
	        <td>${tempRoom.id}</td>
	        <td>${tempRoom.capacity}</td>
	        <td>${tempRoom.roomNumber}</td>
	        <td>${tempRoom.hotel.id}</td> <!-- Access hotel's id -->    
	        <td> 
        		<a href="${bookingLink}">Book</a>
            </td> 
	    </tr>  
	</c:forEach>
			</table>
		</div>
</c:if>
				
</body>
</html>