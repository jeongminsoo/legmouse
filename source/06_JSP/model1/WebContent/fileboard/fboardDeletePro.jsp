<%@page import="com.lec.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String pageNum = request.getParameter("pageNum");
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		String fpw = request.getParameter("fpw");
		FileBoardDao dao = FileBoardDao.getInstance();
		int result = dao.deleteFileBoard(fnum, fpw);
		if (result == FileBoardDao.SUCCESS) {
	%>
		<script>
			alert('<%=fnum %>번글 삭제 성공');
			location.href='fboardList.jsp?pageNum=<%=pageNum %>';
		</script>
	<%
		} else {
	%>
		<script>
			alert('<%=fnum%>번글 삭제 실패. 비밀번호를 확인하세요');
			history.back();
		</script>
	<%
		}
	%>
</body>
</html>