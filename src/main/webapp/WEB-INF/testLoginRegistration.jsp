<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login & Registration - AutConnect</title>
	</head>
	<body>
		<div>
			<form:form action="/testing/register" method="POST" modelAttribute="newUser">
				<div>
					<input type="radio" name="role" value="supervisor">Supervisor
					<input type="radio" name="role" value="therapist">Therapist
					<input type="radio" name="role" value="parent">Parent
				</div>
				<div>
					<form:label path="email">Email</form:label>
					<form:errors path="email" />
					<form:input path="email" type="email" placeholder="email@domain.com"/>
				</div>
				<div>
					<form:label path="firstName">First Name</form:label>
					<form:errors path="firstName" />
					<form:input path="firstName" type="text" placeholder="First Name"/>
				</div>
				<div>
					<form:label path="lastName">Last Name</form:label>
					<form:errors path="lastName" />
					<form:input path="lastName" type="text" placeholder="Last Name"/>
				</div>
				<div>
					<form:label path="password">Password</form:label>
					<form:errors path="password" />
					<form:input path="password" type="password" placeholder="password"/>
				</div>
				<div>
					<form:label path="passwordConfirmation">Password Confirmation</form:label>
					<form:errors path="passwordConfirmation" />
					<form:input path="passwordConfirmation" type="password" placeholder="password"/>
				</div>
				<input type="submit" value="Register">
			</form:form>
		</div>
		<div>
			<form action="/testing/register" method="POST">
				<div>
					<label>Email</label>
					<input type="email" name="email" placeholder="email@domain.com">
				</div>
				<div>
					<label>Password</label>
					<input type="password" name="password" placeholder="password">
				</div>
				<input type="submit" value="Login">
			</form>
		</div>
	</body>
</html>