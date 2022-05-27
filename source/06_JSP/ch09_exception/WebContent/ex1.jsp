<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="exceptionPage.jsp" %>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%!
		int num1, num2;
	%>
	<%
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
	%>
	<h3>num1 = <%=num1 %>, num2 = <%=num2 %></h3>
	<h3>num1 + num2 = <%=num1 + num2 %></h3>
	<h3>num1 - num2 = <%=num1 - num2 %></h3>
	<h3>num1 * num2 = <%=num1 * num2 %></h3>
	<h3>num1 / num2 = <%=num1 / num2 %></h3>
</body>
</html>