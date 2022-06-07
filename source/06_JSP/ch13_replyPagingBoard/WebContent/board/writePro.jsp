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
	<jsp:useBean id="dto" class="com.lec.dto.BoardDto" scope="request"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		dto.setIp(request.getRemoteAddr());
		BoardDao dao = BoardDao.getInstance();
		if (dto.getNum() == 0 ) {
			int result = dao.insertBoard(dto);
			if (result == BoardDao.SCCESS) {
	%>		
			<script>
				alert('글쓰기 완료');
				location.href='list.jsp'
			</script>
	<%	
			} else {
	%>	
			<script>
				alert('글쓰기 실패');
				history.back();
			</script>
	<%	
			}
	%>
	<%
		} else {
			int result = dao.reply(dto);
			if (result == BoardDao.SCCESS) {
	%>
			<script>
				alert('답글 작성 완료');
				location.href='list.jsp?pageNum=<%=request.getParameter("pageNum")%>';
			</script>
	<%
			} else {
	%>
			<script>
				alert('답글 작성 실패');
				history.back();
			</script>
	<%
			}
		}
	%>
</body>
</html>