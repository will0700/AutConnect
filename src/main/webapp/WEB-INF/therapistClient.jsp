<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><c:out value="${client.firstInitial}" />.<c:out value="${client.lastInitial}" />. | Autconnect</title>
	</head>
	<body>
		<div>
			<p><c:out value="${client.firstInitial}" />.<c:out value="${client.lastInitial}" />.</p>
		</div>
		<br>
		<div>
			<a href="/therapist/clients/${client.id}/targetGoals">Target Goals</a>
			<br>
			<a href="/therapist/clients/${client.id}/behaviors">Bx</a>
			<br>
			<a href="">Daily Notes (INCOMPLETE)</a>
		</div>
	</body>
</html>