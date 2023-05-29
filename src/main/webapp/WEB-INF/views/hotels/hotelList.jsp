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
    <title>Hotels</title>
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
					<a class="nav-link fs-3" href="<c:url value="/login" />">Login page</a>
				</li>
			</ul>
		</div>
	</div>
</nav>
<header class="bg-dark py-5">
	<div class="container px-4 px-lg-5 my-5 pt-5">
		<div class="text-center text-white">
			<h1 class="display-4 fw-bolder">Hotels</h1>
			<p class="lead fw-normal text-white-50 mb-0 fs-3">Найкращий вибір тільки у нас</p>
		</div>
	</div>
</header>
<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">
		<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			<c:forEach var="tempHotel" items="${hotels}">
				<!-- ПОЧАТОК КАРТКИ -->
					<div class="col mb-5">
						<div class="card h-100">
							<img class="card-img-top" src="https://dummyimage.com/450x300" alt="..." />
							<div class="card-body p-4">
								<div class="text-center">
									<h5 class="card-title fw-bolder fs-3">${tempHotel.id}. ${tempHotel.hotelName}</h5>
									<span class="card-text fs-4">${tempHotel.country}</span>
								</div>
							</div>
							<div class="card-footer p-4 pt-1 border-top-0 bg-transparent">
								<div class="text-center">
									<a class="btn btn-outline-secondary mt-auto fs-5"
									   href="<c:url value="/hotel/${tempHotel.id}" />">Переглянути</a>
								</div>
							</div>
						</div>
					</div>
				<!-- КІНЕЦЬ КАРТКИ -->
			</c:forEach>
		</div>
	</div>
</section>

<div>
	<a href="<c:url value="/hotel/new" />">add new hotel</a>
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
<%--<a href="/hotels/${hotel.getID()}"> ${tempHotel.id} </a>--%>