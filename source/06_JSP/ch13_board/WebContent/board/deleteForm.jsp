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
	<%
		String num = request.getParameter("num");
	%>
	<form action="deletePro.jsp" method="post">
		<input type="hidden" name="num" value="<%=num %>">
		<table>
			<caption><%=num %>번 글 삭제</caption>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="삭제" class="btn">
					<input type="button" value="취소" class="btn" onclick="history.back()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>