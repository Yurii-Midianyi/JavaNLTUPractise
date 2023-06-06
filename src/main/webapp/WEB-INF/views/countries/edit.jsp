<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit ${country.countryName}</title>
</head>
<body>
<%--<form method="POST" action="<c:url value="/countries/${country.id}" />">--%>
<%--    <input type="hidden" name="_method" value="PATCH">--%>
<%--    <label for="name">Enter name: </label>--%>
<%--    <input type="text" name="countryName" id="name" value="${country.countryName}"/>--%>
<%--    <br/>--%>
<%--    <input type="submit" value="Update"/>--%>
<%--</form>--%>
    <form:form action="${pageContext.request.contextPath}/countries/${country.id}" modelAttribute="country" method="POST">
            <input type="hidden" name="_method" value="PATCH"/>
            <label for="name">Enter name: </label>
            <form:input path="countryName" id="name"/>
        <form:select path="enabled">
            <form:option value="true" label="true"/>
            <form:option value="false" label="false"/>
        </form:select>
        <br/>
           <input type="submit" value="Update"/>
    </form:form>
</body>
</html>
