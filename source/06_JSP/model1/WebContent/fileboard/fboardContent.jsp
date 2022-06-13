<%@page import="com.lec.dto.CustomerDto"%>
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
	<style>
		#content_form{
			height: 550px; 
			padding-top:50px;
		}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<%
			String pageNum = request.getParameter("pageNum");
			int fnum = Integer.parseInt(request.getParameter("fnum"));
			FileBoardDao dao = FileBoardDao.getInstance();
			dao.hitUp(fnum);
			FileBoardDto dto = dao.detail(fnum);
		%>
		<table>
			<caption>글 상세보기</caption>
			<tr>
				<th>글번호</th>
				<td><%=dto.getFnum() %></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><%=dto.getFsubject() %></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=dto.getCname()%>(<a href="mailto:<%=dto.getCemail() != null ? dto.getCemail() : "" %>"><%=dto.getCemail() != null ? dto.getCemail() : " - " %></a>)</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<%
						if (dto.getFfilename() == null) {
							out.println("첨부파일 없음");
						} else {
					%>
					<img src="<%=conPath %>/img/fileup.jpg" height="10">
					<a href='../fileboardUpload/<%=dto.getFfilename() %>'><%=dto.getFfilename() %></a>
					<%
						}
					%>
				</td>
			</tr>
			<tr>
				<th>본문</th>
				<td><pre><%=dto.getFcontent() %></pre></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><%=dto.getFrdate() %></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=dto.getFhit() %></td>
			</tr>
			<tr>
				<th>IP</th>
				<td><%=dto.getFip() %></td>
			</tr>
			<tr>
				<td colspan="2">
					<button onclick="location.href='../fileboard/fboardList.jsp?pageNum=<%=pageNum%>'">목록</button>
					<%
						String cid = null;
						CustomerDto customer = (CustomerDto) session.getAttribute("customer");
						if (customer != null) {
							cid = customer.getCid();
						}
						if (dto.getCid().equals(cid)) {
					%>
					<button onclick="location.href='../fileboard/fboardUpdateForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">수정</button>
					<%
						}
						if (customer != null) {
					%>
					
					<button onclick="location.href='../fileboard/fboardWriteForm.jsp?fnum=<%=fnum %>&pageNum=<%=pageNum %>'">답변</button>
					<%
						}
					%>
					<button onclick="location.href='../fileboard/fboardDeleteForm.jsp?fnum=<%=fnum %>&pageNum=<%=pageNum %>'">삭제</button>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>