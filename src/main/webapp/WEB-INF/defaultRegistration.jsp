<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 	<link rel="stylesheet" href='<c:url value="/css/register.css"/>' type="text/css"/>
	<script type="text/javascript" src="js/myscript.js"></script>
	<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<form id="logoutForm" method="POST" action="/logout">
       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
       <input type="submit" value="Logout!" />
   </form>
    <h1 class = "title">AutConnect</h1>
    	<div class="container">
		    <form:form action="/register" method="POST" modelAttribute="user">
				<div class ="role">
				<div class="radio">	
						<input type="radio" name="role" value="parent">Parent
					</div>	
					<div class="radio">
						<input type="radio" name="role" value="supervisor">Supervisor
					</div>
					<div class="radio">	
						<input  type="radio" name="role" value="therapist">Therapist
					</div>
					
		</div>
				<div class ="">
					<form:label  path="email"></form:label>
					<form:errors path="email" />
					<form:input class="reg" path="email" type="email" placeholder="email@domain.com"/>
				</div>
				<div>
					<form:label  path="firstName"></form:label>
					<form:errors path="firstName" />
					<form:input class="reg" path="firstName" type="text" placeholder="First Name"/>
				</div>
				<div>
					<form:label  path="lastName"></form:label>
					<form:errors path="lastName" />
					<form:input class="reg" path="lastName" type="text" placeholder="Last Name"/>
				</div>
				<div>
					<form:label path="password"></form:label>
					<form:errors path="password" />
					<form:input class="reg" path="password" type="password" placeholder="password"/>
				</div>
				<div>
					<form:label  path="passwordConfirmation"></form:label>
					<form:errors path="passwordConfirmation" />
					<form:input class="reg" path="passwordConfirmation" type="password" placeholder="confirm password"/>
				</div>
				<input class="button" type="submit" value="Register">
			</form:form>
		</div>
		<h3 class="login">Login</h3>
		<c:if test="${logoutMessage != null}">
	        <c:out value="${logoutMessage}"></c:out>
	    </c:if>
	    <c:if test="${errorMessage != null}">
	        <c:out value="${errorMessage}"></c:out>
	    </c:if>
	    <form method="POST" action="/login">
	        <div>
				<input class="reg" type="email" name="username" placeholder="email@domain.com"> <!-- name is "username" for Spring Security reasons -->
			</div>
			<div>
				<input class ="reg" type="password" name="password" placeholder="password">
			</div>
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input class="button" type="submit" value="Login"/>
	    </form>
</body>
</html>