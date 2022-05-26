<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<form action="agree.jsp" method="post">
		<table>
			<caption>회원가입</caption>
			<tr>
				<th><label for="id">아이디</label>
				<td><input type="text" name="id" required="required"></td>
			</tr>
			<tr>
				<th><label for="pw">비밀번호</label>
				<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr>
				<th><label for="pwChk">비밀번호확인</label>
				<td><input type="password" name="pwChk"></td>
			</tr>
			<tr>
				<th><label for="name">이름</label>
				<td><input type="text" name="name" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="가입">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>