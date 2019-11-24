<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
</head>
<body>
    <h1>Register!</h1>
    
    <form:form action="/register" method="POST" modelAttribute="user">
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
</body>
</html>