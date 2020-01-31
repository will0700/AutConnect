<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Target Goals | AutConnect</title>
	</head>
	<body>
		<div>
			<h2>Target Goals</h2>
		</div>
		<div>
			<c:forEach items="${client.targets}" var="target">
				<p><c:out value="${target.targetName}" /></p>
				<form:form action="/therapist/clients/${client.id}/target/${target.id}/newGoal" method="post" modelAttribute="newGoal">
					<form:input path="goalQuestion" required="true"/>
					<input type="submit" value="Add New Goal">	
				</form:form>
				<div>
					<c:forEach items="${target.goals}" var="goal">
						<div>
							<p><c:out value="${goal.goalQuestion}" /><input type="number" name="${goal.id}" placeholder="0">%</p>
						</div>
					</c:forEach>
				</div>
			</c:forEach>
		</div>
		<div>
			<a href="/therapist/clients/${client.id}/newTarget">New Target</a>
		</div>
	</body>
</html>