<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage = "true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Daily Notes | AutConnect</title>
	</head>
	<body>
		<div>
			<h2>Therapist Daily Notes</h2>
		</div>
		<div>
			<form:form action="/therapist/clients/${client.id}/dailyNotes/add" method="POST" modelAttribute="dailyNote">
				<p>Client: <c:out value="${client.firstInitial}" />.<c:out value="${client.lastInitial}" />.</p>
				<p>Therapist: <c:out value="${currentUser.firstName}" /> <c:out value="${currentUser.lastName}" /></p>
				<div>
					<form:label path="location">Location:</form:label>
					<form:errors path="location" />
					<form:input path="location" />
				</div>
				<div>
					<form:label path="session">Session:</form:label>
					<form:errors path="session" />
					<form:input path="session" />
				</div>
				<div>
					<form:label path="notes">Today's Note:</form:label>
					<form:errors path="notes" />
					<form:input path="notes" />
				</div>
				<input type="submit" value="Submit">
			</form:form>
		</div>
	</body>
</html>