<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>contextID : <%=getServletContext().getInitParameter("contextID") %></h2>
	<h2>contextPW : <%=getServletContext().getInitParameter("contextPW") %></h2>
	<hr>
	<h2>contextID : ${initParam.contextID }</h2>
	<h2>contextPW : ${initParam.contextPW }</h2>
	
</body>
</html>