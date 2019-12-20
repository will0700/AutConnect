<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Create Client - AutConnect</title>
	</head>
	<body>
		<h2>Create Client - Supervisor</h2>	
		<form:form action="/supervisor/clients/create" method="post" modelAttribute="newClient">
			<div>
				<form:label path="clientID">Client ID Number</form:label>
				<form:errors path="clientID" />
				<form:input path="clientID" type="text" /> 
			</div>
			<div>
				<form:label path="firstInitial">First Initial</form:label>
				<form:errors path="firstInitial" />
				<form:input path="firstInitial" type="text" maxLength="1" /> 
			</div>
			<div>
				<form:label path="lastInitial">Last Initial</form:label>
				<form:errors path="lastInitial" />
				<form:input path="lastInitial" type="text" maxLength="1" /> 
			</div>
			<div>
				<form:label path="therapists">Therapist</form:label>
				<form:errors path="therapists" />
				<c:forEach items="${therapists}" var="therapist"><br>
					<form:checkbox path="therapists" value="${therapist.id}"/>
					<c:out value="${therapist.firstName}" /> <c:out value="${therapist.lastName}" /><br>
				</c:forEach>
			</div>
			<form:input path="supervisor" type="hidden" value="${currentUser.id}" />
			<input type="submit" value="Create Client">
		</form:form>
	</body>
</html>