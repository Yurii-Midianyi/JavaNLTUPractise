<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <title>Customers</title>
</head>
<body>
<p>Customer page</p>
<a href="<c:url value="/home" />">home page</a>

	<div>
		<h2>Test</h2>
	</div>
	
	<div>
		<table>
			<tr>
				<th>id</th>
				<th>First name</th>
				<th>Last name</th>
				<th>email</th>
			</tr>
			<c:forEach var="tempCustomer" items="${customers}">
				<tr>
					<td>${tempCustomer.id}</td>
					<td>${tempCustomer.firstName}</td>
					<td>${tempCustomer.lastName}</td>
					<td>${tempCustomer.email}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>
 