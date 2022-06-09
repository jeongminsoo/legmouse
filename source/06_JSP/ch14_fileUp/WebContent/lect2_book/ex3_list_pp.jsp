<%@page import="com.lec.book.BookDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.book.BookDao"%>
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
	<tr>
	<%
		final int PAGESIZE = 3;
		final int BLOCKSIZE = 4;
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int start = (currentPage - 1) * PAGESIZE + 1;
		int end = start + PAGESIZE - 1;
		
		BookDao dao = BookDao.getInstance();
		ArrayList<BookDto> books = dao.listBook(start, end);
		for (int i = 0; i < books.size(); i++) {
	%>
		<td>
			<a href="ex4_detail.jsp?bid=<%=books.get(i).getBid()%>&pageNum=<%=pageNum%>">
				<img src="../bookImg/<%=books.get(i).getBimage1()%>"><br>
				<%=books.get(i).getBtitle() %><br>
			</a>
			<del><%=books.get(i).getBprice() %></del><br>
			(<%=books.get(i).getBdiscount() %>할인)<br>
			<b><%=books.get(i).getBprice() * (100-books.get(i).getBdiscount())/100 %>원</b>
		</td>
		<%
			if (i % 3 == 2) {
				out.println("</tr><tr>");
			}
		%>
	<%	
		}
	%>
	</tr>
	</table>
	<div class="paging">
		<%
			int bookTotalCnt = dao.countBook();
			int pageCnt = (int)Math.ceil((double)bookTotalCnt/PAGESIZE);
			int startPage = ((currentPage-1) / BLOCKSIZE) * BLOCKSIZE + 1;
			int endPage = startPage + BLOCKSIZE - 1;
			if (endPage > pageCnt) {
				endPage = pageCnt;
			}
			if (startPage > BLOCKSIZE) {
		%>
			<a href="ex3_list_pp.jsp?pageNum=<%=startPage-1%>"> 이전 </a>
		<%
			}
			for (int i = startPage; i<= endPage; i++) {
				if (i == currentPage) {
					out.println("<b> " + i + " </b>");
				} else {
					out.println("<a href='ex3_list_pp.jsp?pageNum=" + i + "'> " + i + " </a>");
				}
			}
			if (endPage < pageCnt) {
		%>
			<a href="ex3_list_pp.jsp?pageNum=<%=endPage+1 %>"> 다음 </a>
		<%
			}
		%>
	</div>
</body>
</html>