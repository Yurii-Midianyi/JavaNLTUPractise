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
    <title>Management</title>
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
                            <h1 class="display-4 fw-bolder">Менеджмент</h1>
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
                <h2>Країни</h2>
                <div class="col-lg-6">
                    <table class="table table-sm table-striped table-bordered">
                        <tr>
                            <th>id</th>
                            <th>enabled</th>
                            <th>name</th>
                            <th>show</th>
                            <th>update</th>
                            <th>delete</th>
                        </tr>
                        <c:forEach var="country" items="${countries}">
                            <tr>
                                <td>${country.id}</td>
                                <td>${country.enabled}</td>
                                <td>${country.countryName}</td>
                                <td>
                                    <form method="GET" action="<c:url value="/countries/${country.id}" />">
                                        <input type="submit" value="Show">
                                    </form>
                                </td>
                                <td>
                                    <form method="GET" action="<c:url value="/countries/${country.id}/edit" />">
                                        <input type="submit" value="Update">
                                    </form>
                                </td>
                                <td>
                                    <form method="POST" action="<c:url value="/countries/${country.id}" />">
                                        <input type="hidden" name="_method" value="DELETE">
                                        <input type="submit" onclick="if (!(confirm('Are you sure you want to delete this?'))) return false" value="Delete">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <form method="GET" action="<c:url value="/countries/new" />">
                    <input type="submit" value="Add new country">
                </form>
            </div>
        </div>
        <div class="row g-0">
            <div class="col-lg m-auto px-5">
                <h2>Готелі</h2>
                <div class="col-lg-6">
                    <table class="table table-sm table-striped table-bordered">
                        <tr>
                            <th>id</th>
                            <th>name</th>
                            <th>enabled</th>
                            <th>country</th>
                            <th>show</th>
                            <th>update</th>
                            <th>delete</th>
                        </tr>
                        <c:forEach var="hotel" items="${hotels}">
                            <tr>
                                <td>${hotel.id}</td>
                                <td>${hotel.hotelName}</td>
                                <td>${hotel.enabled}</td>
                                <td>${hotel.country.countryName}</td>
                                <td>
                                    <form method="GET" action="<c:url value="/room/list/${hotel.id}" />">
                                        <input type="submit" value="Show">
                                    </form>
                                </td>
                                <td>
                                    <form method="GET" action="<c:url value="/hotel/${hotel.id}/edit" />">
                                        <input type="submit" value="Update">
                                    </form>
                                </td>
                                <td>
                                    <form method="POST" action="<c:url value="/hotel/${hotel.id}" />">
                                        <input type="hidden" name="_method" value="DELETE">
                                        <input type="submit" onclick="if (!(confirm('Are you sure you want to delete this?'))) return false" value="Delete">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <form method="GET" action="<c:url value="/hotel/new" />">
                    <input type="submit" value="Add new hotel">
                </form>
            </div>
        </div>
        <div class="row g-0">
            <div class="col-lg m-auto px-5">
                <h2>Користувачі</h2>
                <div class="col-lg-6">
                    <table class="table table-sm table-striped table-bordered">
                        <tr>
                            <th>id</th>
                            <th>username</th>
                            <th>password</th>
                            <th>role</th>
                            <th>enabled</th>
                            <th>show</th>
                            <th>delete</th>
                        </tr>
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.username}</td>
                                <td>${user.password}</td>
                                <td>${user.role}</td>
                                <td>${user.enabled}</td>
                                <td>
                                    <form method="GET" action="<c:url value="/booking/list/${user.id}" />">
                                        <input type="submit" value="Show">
                                    </form>
                                </td>
                                <td>
                                    <form method="POST" action="<c:url value="/user/${user.id}" />">
                                        <input type="hidden" name="_method" value="DELETE">
                                        <input type="submit" onclick="if (!(confirm('Are you sure you want to delete this?'))) return false" value="Delete">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <div class="row g-0">
            <div class="col-lg m-auto px-5">
                <h2>Букінги</h2>
                <div class="col-lg-6">
                    <table class="table table-sm table-striped table-bordered">
                        <tr>
                            <th>id</th>
                            <th>booked_since</th>
                            <th>booked_to</th>
                            <th>room Id</th>
                            <th>user</th>
                            <th>enabled</th>
                            <th>delete</th>
                        </tr>
                        <c:forEach var="booking" items="${bookings}">
                            <tr>
                                <td>${booking.id}</td>
                                <td>${booking.bookedSince}</td>
                                <td>${booking.bookedTo}</td>
                                <td>${booking.room.id}</td>
                                <td>${booking.user.username}</td>
                                <td>${booking.enabled}</td>
                                <td>
                                    <form method="GET" action="<c:url value="/booking/delete/${booking.id}"/>">
                                        <input type="submit" onclick="if (!(confirm('Are you sure you want to delete this?'))) return false" value="Delete">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
