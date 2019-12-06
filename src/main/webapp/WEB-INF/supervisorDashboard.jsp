<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Supervisor Dashobard</title>
</head>
<body>
	<div>
		<h3>client 1</h3>
	</div>
	<div>	
		<h3>client 2</h3>
	</div>
	<div>
		<h3>client 3</h3>
	</div>
	
	<a href = "/supervisor/clients/create">New Client</a>
	<a href = "/supervisor/clients/remove">Remove Client</a>
	<a href = "/supervisor/clients/messages">Messages</a>
</body>
</html>