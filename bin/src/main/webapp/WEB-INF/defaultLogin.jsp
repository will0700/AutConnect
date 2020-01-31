<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		  <!-- Compiled and minified CSS -->
		  		 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
		  		 <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
		  
		  	    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		  	    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
		  	    <link rel="stylesheet" href='<c:url value="/css/login.css"/>' type="text/css"/>
		  	    
		  <style>
		  	body{
		  	background-image: url(hands.svg);
		  	background-size: cover;
		  	background-size: contain;
		  	/* background-size:50%; */
		  	}
		  </style>
		 
	    
		
	    <!-- Import materialize.css -->

	            
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
			
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Login</title>
	</head>
		<div class="container">
									
			
			<body style="background-color:gray; margin-top: 10%;">
			
			<p class="error">
<!-- 				<img src="images/children.png">
 -->		    </p>
		    <div>
			    <form method="POST" action="/login">
				    <div class="row">
				    <div class="col s12 m6 offset-m3">
				    
					    <div class="card" style="background: rgba(50, 40, 50, .7);">
					  <!--   <div class="card-action indigo lighten-2 white-text">
					    	<h3 class="center-align">AutConnect</h3>
					    </div> -->
					    <div class="center-align red-text" style="padding-top:20px;"  >
					    
						    <c:if test="${logoutMessage != null}">
						    
							        <c:out value="${logoutMessage}"></c:out>
							    </c:if>
							    <c:if test="${errorMessage != null}">
							    <i class="material-icons md-18 center yellow-text text-darken-2" style="position:relative; top:3px;" >error</i>
							    
							        <c:out value="${errorMessage}"></c:out>
							    </c:if>
						</div>	
					    
					  
						        <div class="card-content">
						        <div class="input-field">
						        <i class="material-icons md-18   prefix">email</i>
								<input class="input white-text" size="50" height="20" type="email" name="username" placeholder="email@domain.com">
									 <!-- name is "username" for Spring Security reasons -->
								</div><br>
								<div class="input-field">
								<i class="material-icons md-18  prefix">lock</i>
								<input class="input white-text" size="50" type="password" name="password" placeholder="password">
								</div><br>
								<div class="switch">
<!-- 									<label>
										Off
										<input type="checkbox">
										<span class="lever"></span>
										On
									</label> -->
									<label>
										<input type="checkbox"  />
										<span>Remember Me</span>
									</label> 
								</div><br>
							<!-- 	<div class="form-field">
									<input type="checkbox" class="filled-in" checked="checked"/>
									
									<label for="remem">Remember me</label>
								</div><br> -->
								<div class="form-field">
									<p class="center-align">
								        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								        <button class="btn-small waves-effect waves-dark deep-orange " style="width:60%;"><i class="material-icons left">person</i><p style="margin-right: 45px;">Sign-in</p></button>
							        </p>
						        </div>
<!-- 			 			        <input type="submit" value="Login"/>
 -->						  </div>
			 				</div>
				       </div>
				      </div>
			    </form>
	    		</div>
	    </div>
	    		  <script type="text/javascript" src="https://code.jquery-3.2.1min.js"></script>
	    
	<script type="text/javascript" src="js/materialize.min.js"></script>
	</body>
</html>