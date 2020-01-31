<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Archive | AutConnect</title>
	</head>
	<body>
		<nav>
			<a href="/dashboard">Dashboard</a>
			<a href="/logout">Logout</a>
		</nav>
		<div id="main">
			<c:forEach items="${dailyNotes}" var="daily">
				<a href="/parent/client/${client.id}/${daily.createdAt}">${daily.createdAt}</a>
			</c:forEach>
		</div>
	</body>
</html>