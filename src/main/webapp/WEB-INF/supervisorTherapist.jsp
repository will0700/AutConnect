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
	<div>
		<h2>Therapists for <c:out value="${client.firstInitial}" />.<c:out value="${client.lastInitial}" />. </h2>
	</div>
	<div>
		<h4>Current Therapists</h4>
		<c:forEach items="${client.therapists}" var="therapist">
			<div>
				<c:out value="${therapist.firstName}"></c:out>
				<c:out value="${therapist.lastName}"></c:out>
				<a href="/supervisor/clients/${client.id}/therapists/remove/${therapist.id}">remove</a>
			</div>
		</c:forEach>	
	</div>
	<br>
	<br>
	<br>
	<div>
		<h4>Assign therapists</h4>
		<form action="/supervisor/clients/${client.id}/therapists/add" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<c:forEach items="${notTherapists}" var="notTherapist">
					<input type="checkbox" name="therapistsAdded" value="${notTherapist.id}">
					<c:out value="${notTherapist.firstName}" /> <c:out value="${notTherapist.lastName}" />
					<br>
			</c:forEach>
			<input type="submit">
		</form>
	</div>
		
		
</body>
</html>