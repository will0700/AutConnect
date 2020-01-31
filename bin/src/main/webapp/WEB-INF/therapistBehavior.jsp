<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Behaviors | AutConnect</title>
	</head>
	<body>
		<div>
			<h2>Today's Behaviors</h2>
			<form:form action="/therapist/clients/${client.id}/behaviors/add" method="post" modelAttribute="behavior">
				<div>
					<form:label path="percentAggression">Aggression</form:label>
					<form:errors path="percentAggression" />
					<form:input path="percentAggression" type="number"/>
					<form:errors path="commentAggression" />
					<form:input path="commentAggression" />
				</div>
				<div>
					<form:label path="percentAttention">Attention</form:label>
					<form:errors path="percentAttention" type="number"/>
					<form:input path="percentAttention" />
					<form:errors path="commentAttention" />
					<form:input path="commentAttention" />
				</div>
				<div>
					<form:label path="percentEscape">Escape</form:label>
					<form:errors path="percentEscape" type="number"/>
					<form:input path="commentEscape" /><form:errors path="commentAggression" />
					<form:input path="commentEscape" />
				</div>
				<div>
					<form:label path="session">Session</form:label>
					<form:select path="session">
						<form:option value="morning">Morning</form:option>
						<form:option value="afternoon">Afternoon</form:option>
						<form:option value="evening">Evening</form:option>
					</form:select>
				</div>
				<form:input type="hidden" path="client" value="${client.id}" />
				<input type="submit" value="Save">
			</form:form>
			<h2>Monthly Graph</h2>
			<div>
				<div>
					<p>Aggression</p>
					<!-- Graph Soon(TM) -->
				</div>
				<div>
					<p>Attention</p>
					<!-- Graph Soon(TM) -->
				</div>
				<div>
					<p>Escape</p>
					<!-- Graph Soon(TM) -->
				</div>
			</div>
		</div>
	</body>
</html>