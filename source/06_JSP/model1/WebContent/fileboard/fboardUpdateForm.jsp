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
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<%
		String pageNum = request.getParameter("pageNum");
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		FileBoardDao dao = FileBoardDao.getInstance();
		FileBoardDto dto = dao.detail(fnum);
	%>
		<form action="fboardUpdatePro.jsp" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pageNum" value="<%=pageNum%>">
			<input type="hidden" name="dbfilename" value="<%=dto.getFfilename() != null ? dto.getFfilename() : ""%>">
			<table>
				<tr>
					<th>글번호</th>
					<td><input type="text" name="fnum" value="<%=dto.getFnum()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="fsubject" value="<%=dto.getFsubject()%>" required="required"></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="ffilename" style="width : 30%;"><%if (dto.getFfilename() != null) {out.println(dto.getFfilename());} else { out.println("첨부파일 없음");} %></td>
				</tr>
				<tr>
					<th>본문</th>
					<td>
						<textarea name="fcontent" rows="5" cols="20"><%=dto.getFcontent()%></textarea>
					</td>
				</tr>
				<tr>
					<th>삭제용 비밀번호</th>
					<td><input type="password" name="fpw" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="글수정" class="btn">
						<input type="button" value="이전" class="btn" onclick="history.back()">
						<input type="button" value="목록" class="btn" onclick="location.href='fboardList.jsp?pageNum=<%=pageNum%>'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>