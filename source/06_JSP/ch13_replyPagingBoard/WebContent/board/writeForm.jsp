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
		request.setCharacterEncoding("utf-8");
		BoardDto dto = new BoardDto(); 
		String numStr = request.getParameter("num");
		int num = 0;
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		if (numStr != null) {
			num = Integer.parseInt(numStr);
			BoardDao dao = BoardDao.getInstance();
			dto = dao.getBoardOneLine(num);
		}
		String msg = request.getParameter("msg");
		if (msg == null) {
			msg = "";
		}

	%>
	<form action="writePro.jsp" method="post">
		<input type="hidden" name="pageNum" value="<%=pageNum%>">
		<input type="hidden" name="num" value="<%=num%>">
		<input type="hidden" name="ref" value="<%=dto.getRef()%>">
		<input type="hidden" name="re_step" value="<%=dto.getRe_step()%>">
		<input type="hidden" name="re_indent" value="<%=dto.getRe_indent()%>">
		<table>
			<caption>게시판</caption>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" required="required" value="<%=msg%><%=dto.getSubject()%>"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" required="required"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="5" cols="5" required="required"></textarea></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="저장" class="btn">
					<input type="reset" value="취소" class="btn">
					<input type="button" value="목록" class="btn" onclick="location.href='list.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>