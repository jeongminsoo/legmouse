<%@page import="com.lec.dto.BoardDto"%>
<%@page import="com.lec.dao.BoardDao"%>
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
	<jsp:useBean id="dto" class="com.lec.dto.BoardDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDao dao = BoardDao.getInstance();
		dto.setIp(request.getRemoteAddr());
		int result = dao.modifyBoard(dto);
		if (result == BoardDao.SCCESS) {
	%>
		<script>
			alert('수정완료');
			location.href='list.jsp';
		</script>
	<%		
		} else {
	%>
		<script>
			alert('수정실패');
			history.back();
		</script>
	<%
		}
	%>
</body>
</html>