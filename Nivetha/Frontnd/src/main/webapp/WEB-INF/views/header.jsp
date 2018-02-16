<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    

<html>
<head>
<title>Online TV Shopping</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
  
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="resources/css/mystyle.css">
  <link rel="stylesheet" href="resources/css/design.css">
  <script type="text/javascript" src="Scripts/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="Scripts/bootstrap.min.js"></script>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <!-- Start WOWSlider.com HEAD section -->
<link rel="stylesheet" type="text/css" href="resources/engine1/style.css" />
<script type="text/javascript" src="resources/engine1/jquery.js"></script>

<!-- End WOWSlider.com HEAD section -->
 <script type="text/javascript" src="js/bootstrap/bootstrap-dropdown.js"></script>
<script>
     $(document).ready(function(){
        $('.dropdown-toggle').dropdown()
    });
</script> 

  </head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header" class="col-md-12">
                <img src="resources\TV\logo2.png" alt="logo" class="logo">
                    <button class="navbar-toggle" data-toggle="collapse"  data-target="#myMenu">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="home.html" class="navbar-brand">Television</a>
                </div>
                <div class="collapse navbar-collapse" id="myMenu">
                    <ul class="nav navbar-nav">
                    <c:url value="/featured" var="featured"></c:url>
  							<li><a href="About" id="page">About</a></li>
  							<li><a href="${featured}" id="page">Featured</a></li>
						<li>
						
						<security:authorize access="hasRole('ROLE_USER')">
							<li><a href="displayartist" id="page">Supplier</a></li>
							<li><a href="albums" id="page">Products</a></li>
							</security:authorize>
							
 						<security:authorize access="hasRole('ROLE_ADMIN')">
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Categories<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="CategoryView">View</a></li>
          <li><a href="Category">Add</a></li>
        
        </ul>
      </li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Supplier<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="SupplierView">View</a></li>
          <li><a href="Supplier">Add</a></li>
        
        </ul>
      </li>
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Product<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="viewProduct">View</a></li>
          <li><a href="Product">Add</a></li>
       
        </ul>
      </li>
         </security:authorize>               
                        
                        
                        <!-- <li><a href="../signup.html"> <span class="glyphicon glyphicon-user"></span>Signup</a>
                        <li><a href="../signup.html"> <span class="glyphicon glyphicon-user"></span>Signup</a> 
                        <li><a href="../cart.html"> <span class="glyphicon glyphicon-shopping-cart"></span>Cart</a> -->
                     </ul>
                     <ul class="nav navbar-nav navbar-right">
                    <c:url value="/Signup" var="Signup"></c:url>
                    <c:if test="${pageContext.request.userPrincipal.name==null }">
                    <c:url value="/login1" var="login1"></c:url> 
       <li><a href="${Signup}"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="${login1}"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </c:if>
      <c:if test="${pageContext.request.userPrincipal.name!=null }">
									<li id="right"><security:authorize access="hasRole('ROLE_USER')">
					<li><a href="#">Hi ${pageContext.request.userPrincipal.name}!!</a></li>
					
					<li><a href="myCart"><span
									class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
									<li><a href="History"><span
									class="glyphicon glyphicon-list"></span> Orders</a></li>
					</security:authorize><security:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="admincart"><span
									class="glyphicon glyphicon-list-alt"></span> Orders</a></li>
					</security:authorize></li>
					
					<c:url value="/logout" var="logout"></c:url>
							<li id="right"><a href="${logout}"><span
									class="glyphicon glyphicon-log-out"></span> Logout</a></li>
									</c:if>
      </ul>
                   </div>
            </div>
        </nav>
</body>
 </html>           