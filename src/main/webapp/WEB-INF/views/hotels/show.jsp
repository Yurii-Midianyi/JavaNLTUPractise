<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
		  integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous">
	</script>
    <title>${hotel.hotelName}</title>
</head>
<body>
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
				<security:authorize access="hasRole('MANAGER')">
				<li class="nav-item mx-auto" style="padding: 0 10px">
					<a class="nav-link fs-3" href="<c:url value="/management" />">Management page</a>
				</li>
				</security:authorize>
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
				<security:authorize access="hasRole('MANAGER')">
					<p>${hotel.hotelName}</p>
					<p>${hotel.id}</p>
					<a href="<c:url value="/hotel/${hotel.id}/edit" />">Edit</a>
					<a href="<c:url value="/room/list/${hotel.id}" />">Rooms</a>
					<form method="POST" action="<c:url value="/hotel/${hotel.id}" />">
						<input type="hidden" name="_method" value="DELETE">
						<input type="submit" value="Delete"/>
					</form>
				</security:authorize>
			</div>
		</div>
		<div class="row g-0">
			<div class="col-lg m-auto px-5">
				<h2>Усі кімнати</h2>
				<div class="col-lg-6">
					<table class="table table-sm table-striped table-bordered">
						<tr>
							<th>id</th>
							<th>capacity</th>
							<th>room number</th>
							<th>hotel id</th>
						</tr>
						<c:forEach var="tempRoom" items="${allRooms}">
							<tr>
								<td>${tempRoom.id}</td>
								<td>${tempRoom.capacity}</td>
								<td>${tempRoom.roomNumber}</td>
								<td>${tempRoom.hotel.id}</td> <!-- Access hotel's id -->
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<div class="row g-0">
			<div class="col-lg m-auto px-5">
				<h2>Знайти кімнати в заданий період</h2>
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
				<div class="col-lg-6">
					<c:if test="${not empty rooms}">
						<table class="table table-sm table-striped table-bordered">
							<tr>
								<th>id</th>
								<th>capacity</th>
								<th>room number</th>
								<th>hotel id</th>
								<th>book</th>
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
					</c:if>
				</div>
			</div>
		</div>
	</div>
</section>
</body>
</html>