<%@page import="com.lec.ch11.dto.BoardDto"%>
<%@page import="com.lec.ch11.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		$(document).ready(function() {
			
		});
	</script>
</head>
<body>
		<%
		
			BoardDao dao = BoardDao.getInstance();
			BoardDto dto = new BoardDto();
			for (int i = 1; i <= 110; i++) {
				dto.setBname("홍길동" + i);
				dto.setBtitle("제목" + i);
				dto.setBcontent("본문입니다" + i);
				dto.setBip("127.0.0." + i);
				int result = dao.write(dto);
				System.out.println(i + "번째");
			}
			
		%>
</body>
</html>