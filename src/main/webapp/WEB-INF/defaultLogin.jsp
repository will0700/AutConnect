<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Login</h1>
		<c:if test="${logoutMessage != null}">
	        <c:out value="${logoutMessage}"></c:out>
	    </c:if>
	    <h1>Login</h1>
	    <c:if test="${errorMessage != null}">
	        <c:out value="${errorMessage}"></c:out>
	    </c:if>
	    <form method="POST" action="/login">
	        <div>
				<label>Email</label>
				<input type="email" name="username" placeholder="email@domain.com"> <!-- name is "username" for Spring Security reasons -->
			</div>
			<div>
				<label>Password</label>
				<input type="password" name="password" placeholder="password">
			</div>
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Login!"/>
	    </form>
	</body>
</html>