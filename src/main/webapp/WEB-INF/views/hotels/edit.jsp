<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <title>Edit</title>
</head>
<body>
<%--<form method="POST" action="<c:url value="/hotel/${hotel.id}" />">--%>
<%--    <input type="hidden" name="_method" value="PATCH">--%>
<%--    <label for="name">Enter name: </label>--%>
<%--    <input type="text" name="hotelName" id="name" value="${hotel.hotelName}"/>--%>
<%--    <br/>--%>
<%--    <input type="submit" value="Update"/>--%>
<%--</form>--%>
<form:form action="${pageContext.request.contextPath}/hotel/${hotel.id}" modelAttribute="hotel"  method="POST">
    <input type="hidden" name="_method" value="PATCH">
    <label for="name">Enter name: </label>
    <form:input path="hotelName" id="name"/>
    <form:select path="country.id">
        <c:forEach var="country" items="${countries}">
            <option value="${country.id}">${country.countryName}</option>
        </c:forEach>
    </form:select>
    <form:select path="enabled">
        <form:option value="true" label="true"/>
        <form:option value="false" label="false"/>
    </form:select>
    <br/>
    <input type="submit" value="Update"/>
</form:form>
</body>
</html>