
<%@page import="com.banking.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%
	User user=(User)session.getAttribute("user");
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ONEBank.in</title>
<link rel="icon" type="image/x-icon" href="images/bank2.svg">

<!-- BOOTSTRAP CSS -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

<!-- BOOTSTRAP ICONS CSS -->
<link rel="stylesheet" type="text/css" href="font/bootstrap-icons.css" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light" style="background-color: rgba(0, 0, 0, 0.2);">
		<a class="navbar-brand" href="index.jsp">ONEBank</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link"
					href="bookurl?action=list">Employee</a> <!-- BookeController perform multiple actions like show, add, update, delete etc.
 So to differentiate each action we use action parameter in url.--></li>
				<li class="nav-item"><a class="nav-link"
					href="bookurl?action=add">Add Employee</a></li>
				<li class="nav-item"><a class="nav-link" href="about.jsp">Contact Us</a></li>
			</ul>
			</div>
			<div class="float-ends">
			<%if(user==null){ %>
				<a href="userurl?action=login" class="btn btn-outline-success me-2">Login</a>
				<a href="userurl?action=register" class="btn btn-outline-success">Register</a>
			<%} %>
			<%if(user !=null){ %>
			<p>Welcome <strong><%=user.getUserName() %></strong></p>
			<a href="logout.jsp" class="btn btn-outline-secondary" onclick="return confirm('Are you sure you want to logout?')">Logout</a>
			<%} %>
			</div>
		</nav>