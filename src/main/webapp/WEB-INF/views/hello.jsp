<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
	<h1>Message : ${message}</h1>
	<div align="center">
		<h1>Contact List</h1>
		<table border="1">
			<th>No</th>
			<th>Username</th>
			<th>Email</th>

			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.id}</td>
					<td>${user.login}</td>
					<td>${user.email}</td>
					<td>${user.password}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>