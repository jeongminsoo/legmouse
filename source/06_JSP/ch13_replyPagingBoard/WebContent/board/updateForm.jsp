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
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		String pageNum = request.getParameter("pageNum");
		String num = request.getParameter("num");
		BoardDao dao = BoardDao.getInstance();
		BoardDto dto = dao.getBoardOneLine(Integer.parseInt(num)); 
	%>
	<form action="updatePro.jsp?pageNum=<%=pageNum %>" method="post">
		<input type="hidden" name="num" value="<%=num %>">
		<table>
			<caption><%=num %>번 글 수정</caption>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" required="required" value="<%=dto.getSubject()%>"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="<%=dto.getWriter() %>" readonly="readonly"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" value='<%=dto.getEmail()==null?"":dto.getEmail() %>'></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="5" cols="5" required="required"><%=dto.getContent() %></textarea></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required="required" value="<%=dto.getPw() %>"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="저장" class="btn">
					<input type="reset" value="취소" class="btn">
					<input type="button" value="목록" class="btn" onclick="location.href='list.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>