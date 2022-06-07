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
		BoardDao dao = BoardDao.getInstance();
		BoardDto dto = new BoardDto();
		for (int i = 0; i <70; i++) {
			dto.setWriter("홍길동" + i);
			dto.setSubject("제목" + i + "입니다");
			dto.setContent("본문입니다"+i);
			dto.setEmail("hong"+i+"@hong.com");
			dto.setPw("1");
			dto.setIp("127.0.0."+i);
			dao.insertBoard(dto);
		}
		out.println("<script>alert('글 추가 완료');</script>");
		out.println("<script>location.href='list.jsp';</script>");
	%>
</body>
</html>