<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <title>New hotel</title>
</head>
<body>

<form:form action="${pageContext.request.contextPath}/hotel/list" method="POST" modelAttribute="hotel">
    <label for="name">Enter name: </label>
    <form:input path="hotelName" id="name"/><form:errors path="hotelName" cssClass="form-error"/>
    <br/>
    <label for="country">Country</label>
    <form:select path="country.id" id="country">
        <form:options items="${countries}" itemValue="id" itemLabel="countryName" />
    </form:select><br>
    <form:select path="enabled">
        <form:option value="true" label="true"/>
        <form:option value="false" label="false"/>
    </form:select><br>
    <input type="submit" value="Create">
</form:form>

</body>
</html>
