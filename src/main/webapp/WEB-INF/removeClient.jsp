<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Remove Client</title>
</head>
<body>
	<table>
		
		<c:forEach items="${therapists}" var = "therapist">
		<tr>
			<c:out value="${therapist.firstName}"></c:out>
			<c:out value="${therapist.lastName}"></c:out>
			<form:form action="/supervisor/clients/${client.id}/therapist/remove" method="post">
   			 <input type="submit" value="Remove">
		   </form:form>
		</tr>
		</c:forEach>
	</table>
	<table>
		<tr>
			<td>Add Therapist</td>
		</tr>
		<tr>
			<td><c:forEach var="therapists" items="${therapists}">
    			<form:checkbox path="therapists"
    			value="${therapist }" label="" />
				</c:forEach>
			</td>
		</tr>
	</table>
	
</body>
</html>