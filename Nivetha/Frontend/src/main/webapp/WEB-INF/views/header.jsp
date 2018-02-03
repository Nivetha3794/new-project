<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <html>

<head>
<title>A2Z Computers</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources/css/style.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 </head>
 <body>
 <nav class="navbar navbar-inverse navbar-fixed-top">
<div class="container">
	<div class="navbar-header">
                    <button class="navbar-toggle" data-toggle="collapse" data-target="#myMenu">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    </button>
            
                </div> 
                
 	<div class="collapse navbar-collapse" id="myMenu">
                   <ul class="nav navbar-nav">
                   		<li><img src="resources/images/logo.png" alt="logo" width="50" height="50"></li>
                   		<li><a href="views/index.html" class="navbar-brand">A2Z</a></li>
                   		<li>
                   		<div class="dropdown">
    						<button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">Tutorials
    						<span class="caret"></span></button>
    					<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
      						<li role="presentation"><a role="menuitem" tabindex="-1" href="#">HTML</a></li>
     						 <li role="presentation"><a role="menuitem" tabindex="-1" href="#">CSS</a></li>
      					    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">JavaScript</a></li>
      						<li role="presentation" class="divider"></li>
      						<li role="presentation"><a role="menuitem" tabindex="-1" href="#">About Us</a></li>
    </ul>
  </div>
                   		
</li>                   		                  		
                       <li><a href="About/About.jsp" rel="stylesheet">About</a></li>
                       <li><a href="Feedback/Feedback.html" rel="stylesheet">Feedback</a></li>
                       <li><a href="Contact/Contact.html" rel="stylesheet">Contact</a></li>
                    </ul>
                    
                    <ul class="nav navbar-nav navbar-right">
                   <%-- <c:url value="/NewUser" var="NewUser"></c:url>
                    <c:url value="/Login" var="Login"></c:url> --%>
       <li><a href="Signup.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
               </div>
</div>

</nav>
 
 </body> 
 </html> 
  