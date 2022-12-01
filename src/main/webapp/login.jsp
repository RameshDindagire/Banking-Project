<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
String msg = (String) session.getAttribute("msg");

%>
<jsp:include page="header.jsp" />

<div class="container">
<form action="userurl" method="POST">
<input type="hidden" name="action" value="login" />
	<h1>Login </h1>
	<%
	if (msg != null) {
	%>
	<div class="alert alert-success">
		<%=msg%>
	</div>
	<%
	session.setAttribute("msg", null);
	}
	%>
		<div class="mb-3">
			<label for="userEmail" class="form-label">Email address</label> <input
				type="text" class="form-control" id="user" name="userEmail"
				placeholder="Enter your email address">
		</div>
	
	<div class="mb-3">
			<label for="userPassword" class="form-label">Password</label> <input
				type="password" class="form-control" id="userPassword" name="userPassword"
				placeholder="Enter your password">
		</div>
		<input type="submit" class="btn btn-success px-3 py-3 float-ends" value="Login" />
		</form>
</div>
<jsp:include page="footer.jsp" />