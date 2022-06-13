<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="java.util.ArrayList"%>
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
			height: 570px; 
			padding-top:30px;
		}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<table>
		<tr>
			<td colspan="7">
				<%
					if (session.getAttribute("customer") != null) {
						out.println("<a href='fboardWriteForm.jsp'>글쓰기</a>");
					}
				%>
			</td>
		</tr>
		<tr>
			<th>글번호</th><th>작성자</th><th>글제목</th><th>메일</th><th>IP</th><th>작성일</th><th>조회수</th>
		</tr>
		<tr>
			<%
				String pageNum = request.getParameter("pageNum");
				if (pageNum == null) {
					pageNum = "1";
				}
				int currentPage = Integer.parseInt(pageNum);
				final int PAGESIZE = 10;
				final int BLOCKSIZE = 10;
				int start = (currentPage - 1) * PAGESIZE + 1;
				int end = start + PAGESIZE - 1;
				FileBoardDao dao = FileBoardDao.getInstance();
				ArrayList<FileBoardDto> dtos = dao.listFileBoard(start, end);
				if (dtos.isEmpty()) {
					out.println("<td colspan='7'>등록된 글이 없습니다</td>");
				} else {
					for (FileBoardDto d : dtos) {
			%>
						<td><%=d.getFnum() %></td>
						<td><%=d.getCname() %></td>
						<td class="left">
							<%
								if (d.getFre_level() > 0) {
							%>
								<img src="<%=conPath %>/img/level.gif" width="<%=d.getFre_level()*20%>" height="10">
								<img src="<%=conPath %>/img/re.gif">
							<%
								}
								if (d.getFhit() > 10) {
							%>
								<img src="<%=conPath %>/img/hot.gif">
							<%
								}
							%>
								<a href="fboardContent.jsp?fnum=<%=d.getFnum()%>&pageNum=<%=pageNum%>"><%=d.getFsubject() %></a>
							<%
								if (d.getFfilename() != null) {
							%>
								<img src="<%=conPath%>/img/fileup.jpg" height="10">
							<%
								}
							%>
						</td>
						<td><%=d.getCemail() == null ? " - " : d.getCemail() %></td>
						<td><%=d.getFip() %></td>
						<td><%=d.getFrdate() %></td>
						<td><%=d.getFhit() %></td>
					</tr>
					<tr>
			<%
					}
				}
				
			%>
		</tr>
	</table>
	<div class="paging">
		<%
			int boardCnt = dao.count();
			int pageCnt = (int)Math.ceil((double)boardCnt / PAGESIZE);
			int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1; 
			int endPage = startPage + BLOCKSIZE - 1;
			if (endPage > pageCnt) {
				endPage = pageCnt;
			}
			if (startPage > BLOCKSIZE) {
		%>
			<a href="../fileboard/fboardList.jsp?pageNum=<%=startPage - 1%>"> 이전 </a>
		<%
			}
			for (int i = startPage; i <= endPage; i++) {
				if (currentPage == i) {
		%>
			<b> <%=i %> </b>
		<%
				}else {
					
				
		%>
			<a href="../fileboard/fboardList.jsp?pageNum=<%=i %>"> <%=i %> </a>
		<%
				}
			}
			if (endPage < pageCnt) {
		%>
			<a href="../fileboard/fboardList.jsp?pageNum=<%=endPage + 1%>"> 다음 </a>
		<%
			}
		%>
	</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>