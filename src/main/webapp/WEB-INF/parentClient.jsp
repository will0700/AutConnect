<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><c:out value="${client.firstInitial}" />.<c:out value="${client.lastInitial}" /> | Autconnect</title>
	</head>
	<body>
		<div>
			<div id="navigation">
				<a href="/parent">Dashboard</a>
				<a href="/logout">Logout</a>
			</div>
			<div id="main">
				<a href="/parent/messages">Messages</a>
				<a href="/parent/clients/${client.id}/archives">Archives</a>
			</div>
		</div>
	</body>
</html>