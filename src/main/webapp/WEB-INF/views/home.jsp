<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
<head>
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
		  integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous">
	</script>
	<title>Home page</title>
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
                <c:if test="${pageContext.request.isUserInRole('ROLE_MANAGER')}">
				<li class="nav-item mx-auto" style="padding: 0 10px">
					<a class="nav-link fs-3" href="<c:url value="/management" />">Management page</a>
				</li>
				</c:if>
				<li class="nav-item mx-auto" style="padding: 0 10px">
					<a class="nav-link fs-3" href="<c:url value="/home" />">Home page</a>
				</li>
				<li class="nav-item mx-auto" style="padding: 0 10px">
					<a class="nav-link fs-3" href="<c:url value="/hotel/list" />">Hotel page</a>
				</li>
				<c:choose>
					<c:when test="${pageContext.request.isUserInRole('ROLE_MANAGER')}">
						<div>
							<li class="nav-item mx-auto" style="padding: 0 10px">
								<a class="nav-link fs-3" href="<c:url value="/logout" />">Logout</a>
							</li>
						</div>
					</c:when>
					<c:when test="${pageContext.request.isUserInRole('ROLE_USER')}">
						<div>
							<li class="nav-item mx-auto" style="padding: 0 10px">
								<a class="nav-link fs-3" href="<c:url value="/logout" />">Logout</a>
							</li>
						</div>
					</c:when>
					<c:otherwise>
						<div>
							<li class="nav-item mx-auto" style="padding: 0 10px">
								<a class="nav-link fs-3" href="<c:url value="/login" />">Login</a>
							</li>
						</div>
					</c:otherwise>
				</c:choose>
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
							<h1 class="display-4 fw-bolder">Вибір за країнами</h1>
							<p class="lead fw-normal text-white-50 mb-0 fs-3">Ви можете обрати готель за країною</p>
						</div>
					</div>

					<form:form action="${pageContext.request.contextPath}/home/result" modelAttribute="countries" method="GET">
						<div class="row">
							<div class="col">
								<select class="form-select form-select-lg" id="country" name="id" value="${country.id}">
									<c:forEach var="country" items="${countries}">
												<option value="${country.id}" >${country.countryName}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-auto">
								<input class="btn btn-secondary btn-lg" type="submit" value="Пошук">
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</header>
<section class="py-5 text-center">
	<div class="container">
		<div class="row">
			<div class="col-lg-4">
				<div class="mx-auto mb-5 mb-lg-0 mb-lg-3">
					<div class="d-flex">
						<i class="bi bi-building m-auto text-secondary display-1"></i>
					</div>
					<h3>Багатий вибір готелів</h3>
					<p class="lead mb-0">Великий вибір готелів по країнам всього світу</p>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="mx-auto mb-5 mb-lg-0 mb-lg-3">
					<div class="d-flex">
						<i class="bi bi-cash-coin m-auto text-secondary display-1"></i>
					</div>
					<h3>Багатий вибір номерів</h3>
					<p class="lead mb-0">Великий вибір номерів за будь-який прайс</p>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="mx-auto mb-5 mb-lg-0 mb-lg-3">
					<div class="d-flex">
						<i class="bi bi-watch m-auto text-secondary display-1"></i>
					</div>
					<h3>Легко та швидко</h3>
					<p class="lead mb-0">Легко шукати потрібний номер</p>
				</div>
			</div>
		</div>
	</div>
</section>
<section>
	<div class="container-fluid p-0">
		<div class="row g-0">
			<div class="col-lg-6 order-lg-2 text-white" style="background-image: url('https://www.yonghaophotography.com/blog/wp-content/uploads/2012/05/exterior1-16x9-copy-low-res1.jpg'); min-height: 30rem; background-size: cover;"></div>
			<div class="col-lg-6 order-lg-1 m-auto px-5">
				<h2>Багатий вибір готелів по всьому світу</h2>
				<p class="lead mb-0">Тут великий вибір готелів зі всього світу на будь-який смак</p>
			</div>
		</div>
		<div class="row g-0">
			<div class="col-lg-6 text-white" style="background-image: url('https://wallpaperswide.com/download/hotel_room_2-wallpaper-2880x1620.jpg'); min-height: 30rem; background-size: cover;"></div>
			<div class="col-lg-6 m-auto px-5">
				<h2>Багатий вибір номерів по готелям всього світу</h2>
				<p class="lead mb-0">Тут великий вибір номерів на будь-який смак, ціну, кількість людей</p>
			</div>
		</div>
		<div class="row g-0">
			<div class="col-lg-6 order-lg-2 text-white" style="background-image: url('https://wallpapersmug.com/download/2560x1440/792013/earth-planet-space-moon-sunrise.jpg'); min-height: 30rem; background-size: cover;"></div>
			<div class="col-lg-6 order-lg-1 m-auto px-5">
				<h2>Легко та швидко</h2>
				<p class="lead mb-0">Тут Ви легко і швидко найдете потрібний вам готель, номер в будь-якій країні світу</p>
			</div>
		</div>
	</div>
</section>
<section class="py-5 text-center">
	<div class="container">
		<h2 class="mb-5">Відгуки</h2>
		<div class="row">
			<div class="col-lg-4">
				<div class="mx-auto mb-5 mb-lg-0 mw-" style="max-width: 18rem;">
					<img class="img-fluid rounded-circle mb-3" src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Woman_1.jpg/768px-Woman_1.jpg"/>
					<h5>Маргарита Є.</h5>
					<p class="font-weight-light mb-0">"Lorem ipsum dolor sit amet, consectetur adipisicing elit. At, tempora."</p>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="mx-auto mb-5 mb-lg-0" style="max-width: 18rem;">
					<img class="img-fluid rounded-circle mb-3" src="https://images.squarespace-cdn.com/content/v1/5b14d6b9e17ba3952cac9f04/1529195603042-9ITIYY4D1VS00NETN01Q/image-asset.jpeg"/>
					<h5>Федір С.</h5>
					<p class="font-weight-light mb-0">"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Culpa, optio, rerum?"</p>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="mx-auto mb-5 mb-lg-0" style="max-width: 18rem;">
					<img class="img-fluid rounded-circle mb-3" src="https://www.altermattlab.ch/wp-content/uploads/2020/02/Screen-Shot-2020-02-06-at-19.37.30-500x500.png"/>
					<h5>Сергій В.</h5>
					<p class="font-weight-light mb-0">"Lorem ipsum dolor sit amet, consectetur adipisicing."</p>
				</div>
			</div>
		</div>
	</div>
</section>
<section class="bg-dark py-5">
	<div class="container position-relative">
		<div class="row justify-content-center">
			<div class="col-xl-6">
				<div class="text-center text-white">
					<h2 class="mb-4">Готові обрати готель?</h2>
					<div class="row">
						<div class="col">
							<a href="#search" class="btn btn-secondary btn-lg" type="submit">Пошук готелів за країною</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<footer class="footer pt-3">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-xl-6">
				<div class="text-center">
					<p>&copy; 2023, Y2N. All rights reserved.</p>
				</div>
			</div>
		</div>
	</div>
</footer>
</body>
</html>


