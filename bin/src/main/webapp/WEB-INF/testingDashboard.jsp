<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Dashboard - AutConnect</title>
	</head>
	<body>
		<div>
			<h2>Dashboard</h2>
			<c:out value="${user.email}"/>
			<c:forEach items="${user.roles}" var="role">
				<c:out value="${role.name}"/>
			</c:forEach>
		</div>
		<div>
		
		</div>
	</body>
</html>