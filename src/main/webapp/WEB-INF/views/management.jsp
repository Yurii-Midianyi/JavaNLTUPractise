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
<p>Management page</p>
<div>
    <div>
        <table>
            <tr>
                <th>id</th>
                <th>enabled</th>
                <th>name</th>
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
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div>
        <form method="GET" action="<c:url value="/countries/new" />">
            <input type="submit" value="Add new country">
        </form>
    </div>
</div>
<div>
    <div>
        <table>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>enabled</th>
                <th>country</th>
            </tr>
            <c:forEach var="hotel" items="${hotels}">
                <tr>
                    <td>${hotel.id}</td>
                    <td>${hotel.hotelName}</td>
                    <td>${hotel.enabled}</td>
                    <td>${hotel.country.countryName}</td>
                    <td>
                        <form method="GET" action="<c:url value="/hotel/${hotel.id}" />">
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
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                    <td>
                        <form method="GET" action="<c:url value="/room/list/${hotel.id}" />">
                            <input type="submit" value="Show rooms">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div>
        <form method="GET" action="<c:url value="/hotel/new" />">
            <input type="submit" value="Add new hotel">
        </form>
    </div>
</div>
</body>
</html>
