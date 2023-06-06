<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New country</title>
</head>
<body>
<%--<form method="POST" action="<c:url value="/countries" />">--%>
<%--    <label for="name">Enter name: </label>--%>
<%--    <input type="text" name="countryName" id="name"/>--%>
<%--    <br/>--%>
<%--    <input type="submit" value="Create!"/>--%>
<%--</form>--%>
<form:form action="${pageContext.request.contextPath}/countries" modelAttribute="country" method="POST">
    <label for="name">Enter name: </label>
    <form:input path="countryName" id="name"/>
    <form:select path="enabled">
        <form:option value="true" label="true"/>
        <form:option value="false" label="false"/>
    </form:select>
    <br/>
     <input type="submit" value="Create!"/>
</form:form>
</body>
</html>
