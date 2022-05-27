<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/login.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="login_wrap">
		<div id="title">
			로그인
		</div>
		<form action="loginPro.jsp">
			<table>
				<tr>
					<th><label for="id">아이디</label></th>
					<td><input type="text" name="id" id="id" class="class"
						value="<%
							String id = (String)session.getAttribute("id");
							if (id != null) {
								out.println(id.trim());
							}
						%>"></td>
				</tr>
				<tr>
					<th><label>비밀번호</label></th>
					<td><input type="password" name="pw" id="pw" class="pw"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="로그인" class="loginBtn"></td>
				</tr>
				<tr>
					<td>
						<%	
							String msg = request.getParameter("msg");
							if (msg != null) {
						%>
						<p id="findIdPw" onclick="alert('아이디는 aaa/pw는 111');">
							아이디/비밀번호를 잊으셨나요?
						</p>	
						<%
							}
						%>
					</td>
				</tr>
			</table>
			<p id="login_join">아직회원이 아니신가요?<a href="join.jsp">회원가입</a></p>
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>