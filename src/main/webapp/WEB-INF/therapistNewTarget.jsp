<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Target | AutConnect</title>
	</head>
	<body>
		<div>
			<form:form action="/therapist/clients/${client.id}/newTarget" method="post" modelAttribute="newTarget">
				<div>
					<form:label path="targetName">Target Name</form:label>
					<form:errors path="targetName"/>
					<form:input path="targetName" />
				</div>
				<form:input path="client" value="${client.id}" type="hidden" />
				<input type="submit" value="Save Target">
			</form:form>
		</div>
	</body>
</html>