<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		BoardDao dao = BoardDao.getInstance();
		/* 
		out.println("<h3>1. DB글 갯수 : " + dao.getBoardTotalCnt() + "</h3>");
		ArrayList<BoardDto> dtos = dao.listBoard();
		
		// BoardDto dto = new BoardDto(0, "김길동", "글제목", "본문", "email@email.com", 0, "1", 0, 0, 0, "127.0.0.2", null);
		/* int result = dao.insertBoard(dto);
		 if (result == BoardDao.SCCESS) {
			out.println("글쓰기 성공");
		} else {
			out.println("글쓰기 실패");
		} */
		
		
		// for (BoardDto d : dtos) {
			// out.println(d + "<br>");
		// }
		
		
		/* BoardDto dto = dao.getBoardOneLine(1);
		dto.setSubject("글제목이다");
		dto.setContent("본문이다");
		
		int result = dao.modifyBoard(dto);
		dto = dao.getBoardOneLine(1);
		out.println(result == BoardDao.SCCESS?"성공":"실패"); */
		
		BoardDto dto = dao.getBoardOneLine(1);
		int result = dao.deleteBoard(1, "1");
		out.println(result == BoardDao.SCCESS?"성공":"실패");
		
	%>
</body>
</html>