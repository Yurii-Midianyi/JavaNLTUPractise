<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 31.05.2023
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/home/result" modelAttribute="countries" method="GET">
    <c:forEach var="country" items="${countries}">
        <p>${country.hotelName}</p>
    </c:forEach>
</form:form>
</body>
</html>
