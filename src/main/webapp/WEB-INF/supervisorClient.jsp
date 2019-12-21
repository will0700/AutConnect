<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Supervisor Client</title>
</head>
<body>
	<h3>Client Icon</h3>
	<div>
		<a href = "/supervisor/clients/${client.id}/therapists">Therapist</a>
	</div>
	<div>
		<a href = "/supervisor/clients/${client.id}/targetGoals">Target Goals</a>
	</div>
	<div>
		<a href = "/supervisor/clients/${client.id}/bx">Bx</a>
	</div>
	<div>
		<a href = "/supervisor/clients/${client.id}/dailyNotes">Daily Notes</a>
	</div>
	<div>
		<a href = "/supervisor/clients/${client.id}/archive">Archive</a>
	</div>
</body>
</html>