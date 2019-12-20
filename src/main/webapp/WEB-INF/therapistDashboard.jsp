<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Therapist Dashboard | Autconnect</title>
	</head>
	<body>
		<div>
			<h2>Therapist Dashboard</h2>
		</div>
		<div>
			<c:forEach items="${currentUser.clientsT}" var="client">
				<div>
					<a href="/therapist/clients/${client.id}">
						<c:out value="${client.firstInitial}" />.<c:out value="${client.lastInitial}" />.
					</a>
				</div>
			</c:forEach>
		</div>
		<br><br><br><br><br>
		<div>
			<a href="/therapist/pending">pending client list (INCOMPLETE)</a>
			<a href="#">remove client (INCOMPLETE)</a>
			<a href="#">messages (INCOMPLETE)</a>
		</div>
	</body>
</html>