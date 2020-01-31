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
		<title>Supervisor Target Goal</title>
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