<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Supervisor Messages</title>
</head>
<body>
	<a href="/">Logout</a>
	<h4>
		
		<c:out value="${user.firstName}"></c:out>
		<c:out value="${user.lastName}"></c:out>
	</h4>
		<form method="post" action="/supervisor/client/{id}/messages">
		<label>Add Comment:</label>
		<textarea name = "message"></textarea>
		<input type="submit" value="Submit">
</body>
</html>