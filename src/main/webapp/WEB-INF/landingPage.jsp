<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to AutConnect.
Connecting families, therapists, and supervisors to improve A.B.A. Therapy
and keep progress consistent.</h1>

	<form id="logoutForm" method="POST" action="/logout">
       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
       <input type="submit" value="Logout!" />
   </form>
</body>
</html>