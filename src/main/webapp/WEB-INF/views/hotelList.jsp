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
			</tr>
			<c:forEach var="tempHotel" items="${hotels}">
				<tr>
					<td>${tempHotel.id}</td>
					<td>${tempHotel.hotelName}</td>
					<td>${tempHotel.country}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>
 