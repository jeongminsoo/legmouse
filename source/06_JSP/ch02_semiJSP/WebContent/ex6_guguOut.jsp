<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table { background-color : green; text-align : center; }
		td { background-color : white; padding : 5px; }
	</style>
</head>
<body>
	<%
	int su1 = Integer.parseInt(request.getParameter("su1"));
	int su2 = Integer.parseInt(request.getParameter("su2"));
	%>
	<h3><%=su1 %>단 ~ <%=su2 %>단</h3>
	<table>
		<tr>
		<%for (int i = su1; i <= su2; i++) {%>
			<td><%=i %>단</td>
		<%} %> 
		</tr>
		<%for (int i = 1; i <= 9; i++) {%>
			<tr><%for (int j = su1; j <= su2; j++) {%>
					<td><%=j %> * <%=i %> = <%=j*i %></td>
				<%} %></tr>
		<%} %>
	</table>
	<br>
	<button onclick="history.go(-1);">뒤로가기</button>
	<button onclick="location.href='ex6_su2Input.html'">새로하기</button>
</body>
</html>