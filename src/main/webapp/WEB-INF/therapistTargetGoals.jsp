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
			<form action="/therapist/clients/${client.id}/targetGoals/process"  method="post">
			<c:forEach items="${client.targets}" var="target">
				<p><c:out value="${target.targetName}" /></p>
				<a href="/therapist/target/${target.id}/newGoal">New Goal</a>
				<div>
					<c:forEach items="${target.goals}" var="goal">
						<div>
							<p><c:out value="${goal.goalQuestion}" /></p>
							<input type="number" name="${goal.id}" placeholder="0"><p>%</p>
						</div>
					</c:forEach>
				</div>
			</c:forEach>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="submit" value="Save">
			</form>
		</div>
		<div>
			<a href="/therapist/clients/${client.id}/newTarget">New Target</a>
		</div>
	</body>
</html>