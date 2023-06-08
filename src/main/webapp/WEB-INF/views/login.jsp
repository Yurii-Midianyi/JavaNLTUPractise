<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous">
    </script>
    <title>Login</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light p-0 z-2" style="opacity: 0.96">
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
<canvas id="canvas"></canvas>
<div class="row w-100" style="padding-top: 175px;">
  <div class="col-lg-6 m-auto introducing p-5">
    <h1>Допоможемо підібрати номер в готелях всього світу</h1>
    <h5>
      Широкий вибір найвідоміших готелів.
    </h5>
    <h5>
      Багатий вибір кімнат на різний смак.
    </h5>
    <h5>
      Можливість замовити номер 24/7.
    </h5>
  </div>
  <div class="col-lg-5 d-flex">
    <div class="form-wrapper is-active">
      <button type="button" class="switcher switcher-login">
        Login
        <span class="underline"></span>
      </button>
      <form method="POST" action="/process_login" class="form form-login">
        <fieldset>
          <legend>Please, enter your email and password for login.</legend>
          <div class="input-block">
            <label for="login-email">E-mail</label>
            <input id="login-email" class="email" type="email" name="username" required>
          </div>
          <div class="input-block">
            <label for="login-password">Password</label>
            <input id="login-password" class="password" name="password" type="password" required>
          </div>
        </fieldset>
        <button type="submit" class="btn-login">Login</button>
      </form>
    </div>

    <div class="form-wrapper">
      <button type="button" class="switcher switcher-signup">
        Sign Up
        <span class="underline"></span>
      </button>
      <form:form method="POST" action="/login" class="form form-signup" modelAttribute="user">
        <fieldset>
          <legend>Please, enter your email, password and password confirmation for sign up.
          </legend>
          <div class="input-block">
            <label for="signup-email">E-mail</label>
            <input id="signup-email" type="email" name="username" required>
          </div>
          <div class="input-block">
            <label for="signup-firstname-confirm">first name</label>
            <input id="signup-firstname-confirm" type="text" name="firstname" required>
          </div>
          <div class="input-block">
            <label for="signup-lastName-confirm">last name</label>
            <input id="signup-lastName-confirm" type="text" name="lastname" required>
          </div>
          <div class="input-block">
            <label for="signup-password">Password</label>
            <input id="signup-password" type="password" name="password" required>
          </div>
        </fieldset>
        <button type="submit" class="btn-signup">Continue</button>
      </form:form>
    </div>
  </div>
</div>
<script src="<c:url value="/resources/js/login.js" />"></script>
</body>
</html>
