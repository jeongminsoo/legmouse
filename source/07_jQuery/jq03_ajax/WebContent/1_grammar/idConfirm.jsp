<%@page import="com.lec.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<%
		String mId = request.getParameter("mId");
		MemberDao dao = MemberDao.getInstance();
		int result = dao.idChk(mId);
		if (result == MemberDao.ID_EXISTENT) {
			out.println("중복된 아이디입니다");
		} else {
			out.println("사용 가능한 아이디입니다");
		}
	%>
</body>
</html>