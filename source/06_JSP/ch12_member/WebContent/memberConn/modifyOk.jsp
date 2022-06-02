<%@page import="com.lec.member.MemberDaoConn"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.lec.member.MemberDto"%>
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
		if (tempbirth.equals("")) {
			tempbirth = null;
		} else {
			dto.setBirth(Timestamp.valueOf(tempbirth+" 00:00:00"));
		}
		
		MemberDto member = (MemberDto)session.getAttribute("member");
		MemberDaoConn dao = new MemberDaoConn();
		String oldPw = request.getParameter("oldPw");
		String sessionPw = null;
		if (member != null) {
			sessionPw = member.getPw();
		}
		
		
		if (sessionPw.equals(oldPw)) {
			if (dto.getPw() == null) {
				dto.setPw(sessionPw);
			}
			int result = dao.modifyMember(dto);
			if (result == MemberDaoConn.SUCCESS) {
				session.setAttribute("member", dto);
	%>
				<script>
					alert("회원 정보가 수정되었습니다");
					location.href="main.jsp";
				</script>
		<%
			} else {
		%>
				<script>
					alert("회원 정보 수정에 실패하였습니다.");
					location.href="modify.jsp";
				</script>
		<%
			}
		%>
	<%	
		} else {
	%>
			<script>
				alert("현재 비밀번호가 다릅니다");
				history.back();
			</script>
	<%
		}
	%>
</body>
</html>