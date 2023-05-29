<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit ${country.countryName}</title>
</head>
<body>
<form method="POST" action="<c:url value="/countries/${country.id}" />">
    <input type="hidden" name="_method" value="PATCH">
    <label for="name">Enter name: </label>
    <input type="text" name="countryName" id="name"/>
    <br/>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
