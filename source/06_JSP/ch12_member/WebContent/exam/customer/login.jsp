<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="com.lec.customer.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath();
	String id = String.valueOf(session.getAttribute("id"));
	String msg = request.getParameter("msg");
	CustomerDao dao = CustomerDao.getInstance();
	CustomerDto dto = dao.getCustomer(id);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/exam/css/login.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="login_wrap">
		<div id="title">
			로그인
		</div>
		<form action="loginPro.jsp" method="post">
		<table>
			<tr>
				<th><label for="id">아이디</label></th>
				<td><input type="text" name="id" class="id" id="id" value='<%=dto == null ? "" : dto.getId()%>'></td>
			</tr>
			<tr>
				<th><label for="pw">비밀번호</label></th>
				<td><input type="password" name="pw" class="pw" id="pw"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인" class="loginBtn"></td>
			</tr>
			<tr>
				<td colspan="2">
					<%
						if (msg != null) {
					%>
							<p id="findIdPw" onclick="<% if (dto != null) {
															out.println("alert('아이디 : '" + dto.getId() + "/비밀번호 : "+ dto.getPw() + "')");
														} else {
															out.println("alert('아직 회원가입을 하지 않았습니다')");
														}
							%>">아이디/비밀번호를 잊어버리셨나요?</p>
					<%
						}
					%>
				</td>
			</tr>
		</table>
		</form>
		<p id="login_join">아직 회원이 아니신가요? <a href="join.jsp">회원가입</a></p>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>