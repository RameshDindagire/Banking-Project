<%@page import="com.banking.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% 
String msg = (String) session.getAttribute("msg");
User user=(User)session.getAttribute("user");
%>
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

<%
session.invalidate();
session = request.getSession();
session.setAttribute("msg", "Log out successfull!!");
response.sendRedirect("index.jsp");
%>