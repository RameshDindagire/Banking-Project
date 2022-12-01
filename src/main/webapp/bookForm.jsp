<%@page import="com.banking.pojo.bank"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="header.jsp" />

<%
String action = (String) request.getAttribute("action");
bank book = (bank) request.getAttribute("book");
%>
<div class="container">
	<h1><%=action%>
		Employee
	</h1>
	<form action="bookurl" method="POST">
		<input type="hidden" name="action" value="<%=action%>">
		<!-- IT IS USED TO TRACK USER ACTION -->
		<%
		if (action != null && action.equals("update")) {
		%>
		<div class="mb-3">
			<label for="bookId" class="form-label">Book ID</label> <input
				type="number" class="form-control" id="bookId" name="bookId"
				placeholder="Enter book ID" value="<%=book.getid()%>" readonly>
		</div>
		<%
		}
		%>
		<div class="mb-3">
			<label for="bookName" class="form-label">User name</label> <input
				type="text" class="form-control" id="bookName" name="bookName"
				placeholder="Enter user name" value="<%=book.getuname()%>" autocomplete="off">
		</div>
		<div class="mb-3">
			<label for="bookPrice" class="form-label">User Email</label> <input
				type="text" class="form-control" id="bookPrice" name="bookPrice"
				placeholder="Enter email xyz@xyz.com" value="<%=book.getuemail()%>" autocomplete="off">
		</div>
		<input type="submit" value="<%=action%>"
			class="btn btn-outline-success" />
	</form>
</div>

<jsp:include page="footer.jsp" />