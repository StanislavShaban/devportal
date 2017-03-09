<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>DevPortal</title>

	<link href="<c:url value="/resources/css/sign_beauty_style/style.css"/>" rel="stylesheet">

</head>

<body>

  <div class="wrapper">
	<div class="container" ng-app="">
		<h1>Welcome, {{name}}</h1>

		<form class="form" id = "form_login"
			  action="j_spring_security_check" method="POST">
			<c:if test ="${not empty error}">
				${error}
			</c:if>
			<input type="text" placeholder="Username" name="user_login" ng-model="name" value=''>
			<input type="password" placeholder="Password" name="user_password">
			<button type="submit" id="login-button">Login</button>
		</form>
	</div>

	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script src="<c:url value="/resources/js/sign_beauty_js/index.js"/>"></script>
  <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"/>"></script>
</body>
</html>
