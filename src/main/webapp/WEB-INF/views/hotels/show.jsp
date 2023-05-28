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

<form method="POST" action="<c:url value="/hotel/${hotel.id}" />">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="Delete"/>
</form>
</body>
</html>