<%@page import="com.lec.member.MemberDaoConn"%>
<%@page import="java.sql.Timestamp"%>
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
	%>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="request"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String tempbirth = request.getParameter("tempbirth");
		if (!tempbirth.equals("")) {
			dto.setBirth(Timestamp.valueOf(tempbirth + " 00:00:00"));
		}
		MemberDaoConn mDao = new MemberDaoConn();
		int result = mDao.confirmId(dto.getId());
		if (result == MemberDaoConn.MEMBER_NONEXISTENT) {
			result = mDao.joinMember(dto);
			if (result == MemberDaoConn.SUCCESS) {
				session.setAttribute("id", dto.getId());
	%>
				<script>
					alert('회원가입이 완료되었습니다. 로그인 페이지로 이동합니다.');
					location.href="login.jsp";
				</script>
		<%
			} else {
		%>
				<script>
					alert('회원가입에 실패하였습니다. 다시 가입해주세요');
					location.href='join.jsp'
				</script>
	<%
			}
		} else {
	%>
			<script>
				alert('중복된 ID입니다. 다른 ID를 사용하세요.');
				history.back();
			</script>
	<%
		}
	%>
</body>
</html>