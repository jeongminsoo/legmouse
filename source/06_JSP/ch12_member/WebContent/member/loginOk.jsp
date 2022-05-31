<%@page import="com.lec.member.MemberDto"%>
<%@page import="com.lec.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.loginCheck(id, pw);
		
		if (result == MemberDao.LOGIN_SUCCESS) {
			MemberDto member = mDao.getMember(id);
			session.setAttribute("member", member);
			response.sendRedirect("main.jsp");
		} else if (result == MemberDao.LOGIN_FAIL_PW) {
	%>
			<script>
				alert('비밀번호가 다릅니다');
				location.href='login.jsp';
			</script>
	<%		
		} else {
	%>
			<script>
				alert('아이디가 다릅니다');
				location.href='login.jsp';
			</script>
	<%
		}
	%>
</body>
</html>