<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Dashboard | AutConnect</title>
	</head>
	<body>
		<div>
			<div id="navigation">
				<a href="/logout">Logout</a>
				<h2>Parent Dashboard</h2>
			</div>
			<div id="main">
				<p>Clients:</p>
				<c:forEach items="${currentUser.clientsP}" var="client">
					<a href="/parent/clients/${client.id}"><c:out value="${client.firstInitial}" />.<c:out value="${client.lastInitial}" /></a>
				</c:forEach>
			</div>
		</div>
	</body>
</html>