<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<jsp:include page="header.jsp" />

<div class="container">
<form action="userurl" method="POST">
<input type="hidden" name="action" value="register" />
	<h1>Register </h1>
	<div class="mb-3">
			<label for="userName" class="form-label">Name</label> <input
				type="text" class="form-control" id="userName" name="userName"
				placeholder="Enter your name">
		</div>
		<div class="mb-3">
			<label for="userEmail" class="form-label">Email address</label> <input
				type="text" class="form-control" id="user" name="userEmail"
				placeholder="Enter your email address">
		</div>
		<div class="mb-3">
			<label for="userRole" class="form-label">Role</label>
			<select name="userRole" id="userRole" class="form-control">
			<option hidden>Select</option>
			<option value="admin">Admin</option>
			<option value="customer">Customer</option> 
			</select>
		</div>
	<div class="mb-3">
			<label for="userPassword" class="form-label">Password</label> <input
				type="password" class="form-control" id="userPassword" name="userPassword"
				placeholder="Enter your password">
		</div>
		<input type="submit" class="btn btn-success px-3 py-3 float-ends" />
		</form>
</div>
<jsp:include page="footer.jsp" />