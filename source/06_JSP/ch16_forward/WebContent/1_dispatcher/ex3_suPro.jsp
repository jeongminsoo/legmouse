<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		int su = Integer.parseInt(request.getParameter("su"));
		int sum = 0;
		for (int i = 1; i <= su; i++) {
			sum += i;
		}
	%>
	<h2>1부터 ${param.su }까지 누적합 : <%=sum %></h2>
</body>
</html>