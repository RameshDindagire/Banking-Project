<%@page import="com.banking.pojo.bank"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="header.jsp" />

<h1 align="center">Confirm page</h1>
<%
bank book = (bank) request.getAttribute("book");
%>
<div class="container" align="center">
	<p class="alert alert-danger my-10" style="font-size: 300%">
		Are you sure you want to delete<strong style="color: red"> <em><%=book.getuname()%></em></strong>
		Employee Details?
	</p>
	<form action="bookurl" method="POST">
		<input type="hidden" name="action" value="delete" /> 
		<input
			type="hidden" name="bookId" value="<%=book.getid()%>"> 
			<a
			href="bookurl?action=list" class="btn btn-primary ">Back</a>
			 <input
			class="btn btn-danger" type="submit" value="delete" />

	</form>

</div>

<jsp:include page="footer.jsp" />