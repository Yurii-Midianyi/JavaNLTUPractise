<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New country</title>
</head>
<body>
<form method="POST" action="<c:url value="/countries" />">
    <label for="name">Enter name: </label>
    <input type="text" name="countryName" id="name"/>
    <br/>
    <input type="submit" value="Create!"/>
</form>
</body>
</html>
