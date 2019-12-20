<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
		 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
		  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
		  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		  <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
<%--  		  <link rel="stylesheet" href='<c:url value="/css/register.css"/>' type="text/css"/>
 --%>		  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Register</title>
	
</head>
<div class="container">
		<body style="background-color:#616161; margin-top:10%">
		<form id="logoutForm" method="POST" action="/logout">
 			<div class="row">
			<div class="col s12 m8 offset-m3">
			<div class="card" style="background: rgba(0, 0, 0, .4)">
		       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<!-- 		       <input type="submit" value="Logout!" />
 -->		   </form>
		    <h3 class = "center-align">AutConnect</h3>
		    	<div class="container">
				    <form:form action="/register" method="POST" modelAttribute="user">
						<div >
							<div>
								<label>
									<input class="with-gap" type="radio" name="role" value="parent">
									<span>Parent</span>
								</label>
							</div>
							<div>
								<input type="radio" checked name="role" value="supervisor">
								<label>Supervisor</label>
							</div>
							<div>
								<input  type="radio" name="role" value="therapist">
								<label>Therapist</label>
							</div>
						</div>
						<div class ="">
							<form:label  path="email"></form:label>
							<form:errors path="email" />
							<form:input class="reg" path="email" type="email" placeholder="email@domain.com"/>
						</div>
						<div>
							<form:label  path="firstName"></form:label>
							<form:errors path="firstName" />
							<form:input class="reg" path="firstName" type="text" placeholder="First Name"/>
						</div>
						<div>
							<form:label  path="lastName"></form:label>
							<form:errors path="lastName" />
							<form:input class="reg" path="lastName" type="text" placeholder="Last Name"/>
						</div>
						<div>
							<form:label path="password"></form:label>
							<form:errors path="password" />
							<form:input class="reg" path="password" type="password" placeholder="password"/>
						</div>
						<div>
							<form:label  path="passwordConfirmation"></form:label>
							<form:errors path="passwordConfirmation" />
							<form:input class="reg" path="passwordConfirmation" type="password" placeholder="confirm password"/>
						</div>
						<input class="button" type="submit" value="Register">
					</form:form>
				</div>
			</div>
			</div>
			</div>
		</div>	
	<%-- 	<h3 class="login">Login</h3>
		<c:if test="${logoutMessage != null}">
	        <c:out value="${logoutMessage}"></c:out>
	    </c:if>
	    <c:if test="${errorMessage != null}">
	        <c:out value="${errorMessage}"></c:out>
	    </c:if>
	    <form method="POST" action="/login">
	        <div>
				<input class="reg" type="email" name="username" placeholder="email@domain.com"> <!-- name is "username" for Spring Security reasons -->
			</div>
			<div>
				<input class ="reg" type="password" name="password" placeholder="password">
			</div>
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input class="button" type="submit" value="Login"/>
	    </form> --%>
</body>
</html>