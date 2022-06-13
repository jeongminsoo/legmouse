<%@page import="java.sql.Date"%>
<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="com.lec.dao.FileBoardDao"%>
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
		FileBoardDao dao = FileBoardDao.getInstance();
		FileBoardDto dto = new FileBoardDto();
		for (int i = 0; i < 70; i++) {
			if (i % 3 == 0) {
				dto.setCid("aaa");
			} else if (i % 3 == 1) {
				dto.setCid("bbb");
			} else if (i % 3 == 2) {
				dto.setCid("ccc");
			}
			dto.setFsubject("강제로 입력한 글" + i);
			dto.setFcontent("본문" + i);
			if (i % 5 == 0) {
				dto.setFfilename("쿠키.docx");
			}
			dto.setFpw("111");
			dto.setFhit(0);
			dto.setFre_step(0);
			dto.setFre_level(0);
			dto.setFip("127.0.0." + i);
			
			int result = dao.insertFileBoard(dto);
			out.println(result == FileBoardDao.SUCCESS ? "성공<br>" : "실패<br>");
		}
	%>
</body>
</html>