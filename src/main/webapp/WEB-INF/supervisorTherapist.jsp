<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Supervisor Therapist</title>
</head>
<body>
	<h4>
		<c:out value="${therapist.firstName}"></c:out>
		<c:out value="${therapist.lastName}"></c:out>
		
	</h4>
	<h4>
	Date:
		<c:out value="${created_At}"></c:out>
	</h4>
	
	<h4>
		<a href="/supervisor/client/{id}/remove"></a>Remove
	</h4>
	
	<div>
		<form:label path="therapist">Add Therapist</form:label>
		<form:errors path="therapist"/>
		<form:input path="therapist" type="text"/>
	</div>
	<form:input path="therapist" type="hidden" value="${currentUser.id}" />
	<input type="submit" value="Add Therapist">
</body>
</html>