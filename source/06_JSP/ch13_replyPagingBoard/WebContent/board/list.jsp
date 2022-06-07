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
	<table>
		<caption>게시판</caption>
		<tr>
			<td><a href="<%=conPath %>/board/writeForm.jsp">글쓰기</a></td>
		</tr>
	</table>
	<table>
		<tr>
			<th>글번호</th><th>글작성자</th><th>글제목</th><th>메일</th><th>조회수</th>
		</tr>
		<%
			BoardDao dao = BoardDao.getInstance();
			int totalCnt = dao.getBoardTotalCnt();
			
			final int PAGESIZE = 10, BLOCKSIZE = 10;
			String pageNum = request.getParameter("pageNum");
			
			if (pageNum == null) {
				pageNum = "1";
			}
			
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage-1) * PAGESIZE + 1;
			int endRow = startRow + PAGESIZE - 1;
			
			if (totalCnt == 0) {
				out.println("<tr><td colspan='5'>등록된 글이 없습니다</td><tr>");
			} else {
				ArrayList<BoardDto> dtos = dao.listBoard(startRow, endRow);
				for (BoardDto dto : dtos) {
					out.println("<tr><td>" + dto.getNum() + "</td><td>" + dto.getWriter() + "</td>");
					out.println("<td class='left'>");
					if (dto.getRe_indent() > 0) {
						int width = dto.getRe_indent();
						String re = "　";
						for (int i = 0; i < width; i++) {
							out.print(re);	
						}
						out.println("ㄴ");
						
					}
					if (dto.getReadcount() > 10) {
						out.println("<img src='" + conPath + "/img/hot.gif'>");
					}
					out.println("<a href='" + conPath + "/board/content.jsp?num=" + dto.getNum()+ "&pageNum=" + pageNum + "'>");
					out.println(dto.getSubject() + "</a></td><td>" + (dto.getEmail()!=null?dto.getEmail():"") + "</td><td>" + dto.getReadcount() + "</td></tr>");
				}
			}
		%>	
	</table>
	<div class="paging">
	<%
		int pageCnt = (int)Math.ceil((double)totalCnt/PAGESIZE);
		int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		if (endPage > pageCnt) {
			endPage = pageCnt;
		}
		if (startPage > BLOCKSIZE) {
			out.println("<a href='list.jsp?pageNum=" + (startPage - 1) +"'>< 이전</a>");
		}
		for (int i = startPage; i <= endPage; i++) {
			if (i == currentPage) {
				out.println("<b>"+ i +"</b>");
			} else {
				out.println("<a href='list.jsp?pageNum=" + i + "'>" + i + "</a>");
			}
		}
		if (endPage < pageCnt) {
			out.println("<a href='list.jsp?pageNum=" + (endPage + 1) + "'> 다음 ></a>");
		}
	%>
	</div>
</body>
</html>