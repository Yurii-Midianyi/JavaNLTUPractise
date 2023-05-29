<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <title>Countries</title>
</head>
<body>
<div>
    <table>
        <tr>
            <th>id</th>
            <th>country_name</th>
        </tr>
        <c:forEach var="country" items="${countries}">
            <tr>
                <td>${country.id}</td>
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
</body>
</html>
