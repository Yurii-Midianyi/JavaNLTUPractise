<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
		  integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous">
	</script>
    <title>${hotel.hotelName}'s rooms</title>
</head>
<body>
<%--<p>Hotel page</p>--%>
<%--<a href="<c:url value="/home" />">home page</a>--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light p-0" style="opacity: 0.96">
	<div class="container-fluid">
		<a class="navbar-brand" href="<c:url value="/home" />">
			<img src="https://dummyimage.com/130x50&text=logo" alt="Home">
		</a>
		<button class="navbar-toggler fw-bolder fs-3" type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			Menu
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ms-auto">
				<li class="nav-item mx-auto" style="padding: 0 10px">
					<a class="nav-link fs-3" href="<c:url value="/management" />">Management page</a>
				</li>
				<li class="nav-item mx-auto" style="padding: 0 10px">
					<a class="nav-link fs-3" href="<c:url value="/home" />">Home page</a>
				</li>
				<li class="nav-item mx-auto" style="padding: 0 10px">
					<a class="nav-link fs-3" href="<c:url value="/hotel/list" />">Hotel page</a>
				</li>
				<li class="nav-item mx-auto" style="padding: 0 10px">
					<a class="nav-link fs-3" href="<c:url value="/logout" />">Logout</a>
				</li>
			</ul>
		</div>
	</div>
</nav>
<header class="bg-dark py-5" id="search">
	<div class="container position-relative">
		<div class="row justify-content-center">
			<div class="col-xl-6">
				<div class="text-center">
					<div class="container px-4 px-lg-5 my-5 pt-5">
						<div class="text-center text-white">
							<h1 class="display-4 fw-bolder">${hotel.hotelName}</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>
<section>
	<div class="container-fluid p-0">
		<div class="row g-0">
			<div class="col-lg m-auto px-5">
				<h2>Кімнати</h2>
				<div class="col-lg-6">
					<table class="table table-sm table-striped table-bordered">
						<tr>
							<th>id</th>
							<th>capacity</th>
							<th>room number</th>
							<th>hotel id</th>
							<th>enabled</th>
							<th>action</th>
						</tr>
						<c:forEach var="tempRoom" items="${rooms}">
							<!-- create update link for every room -->
							<c:url var ="updateLink" value = "/room/showFormForUpdate/${tempRoom.id}">
							</c:url>
							<!-- create a delete link for every room -->
							<c:url var ="deleteLink" value = "/room/delete/${tempRoom.id}">
							</c:url>
							<!-- create a booking link for every room -->
							<c:url var ="bookingLink" value = "/room/book/${tempRoom.id}">
							</c:url>
							<tr>
								<td>${tempRoom.id}</td>
								<td>${tempRoom.capacity}</td>
								<td>${tempRoom.roomNumber}</td>
								<td>${tempRoom.hotel.id}</td> <!-- Access hotel's id -->
								<td>${tempRoom.enabled}</td>
								<td>
									<a href="${bookingLink}">Book</a>
									|
									<a href="${updateLink}">Update</a>
									|
									<a href="${deleteLink}"
									   onclick="if (!(confirm('Are you sure you want to delete this room?'))) return false">
										Delete</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<input type="button" value="Add Room"
					   onclick="window.location.href='${pageContext.request.contextPath}/room/showFormForAdd/${hotelId}'; return false;"
					   class="" /><!-- attribute class needed for style purposes -->
			</div>
		</div>
	</div>
</section>
</body>
</html>
 