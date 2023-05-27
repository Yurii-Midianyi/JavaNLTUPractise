<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <title>Hotel</title>
</head>
<body>
<p>${hotel.getHotelName()}</p>
<p>${hotel.getId()}</p>

<a href="/hotel/${hotel.getId()}/edit?id=${hotel.getId()}">Edit</a>

<form method="POST" action="/hotel/${hotel.getId()}/?id=${hotel.getId()}">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="Delete"/>
</form>
</body>
</html>