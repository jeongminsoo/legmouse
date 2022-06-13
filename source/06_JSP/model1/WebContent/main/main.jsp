<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.CustomerDao"%>
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
		if (pageNum == null) {
			pageNum = "1";
		}
		final int PAGESIZE = 5;
		final int BLOCKSIZE = 2;
		
		int currentPage = Integer.parseInt(pageNum);
		int start = (currentPage - 1) * PAGESIZE + 1;
		int end = start + PAGESIZE - 1;
		CustomerDao dao = CustomerDao.getInstance();
		ArrayList<CustomerDto> customers = dao.listCustomer(start, end);
		
	%>
	<jsp:include page="header.jsp"/>
	<div id="content_form">
		<table>
			<tr style="height : 60px;">
				<th>회원ID</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>주소</th>
			</tr>

			<%
				if (customers.size() == 0) {
					out.println("<tr><td colspan='5'>해당 회원이 없습니다</td></tr>");
				} else {
					for (CustomerDto c : customers) {
						out.println("<tr style='height : 60px;'><td>" + c.getCid() + "</td>");
						out.println("<td>" + c.getCpw() + "</td><td>" + c.getCname() + "</td>");
						out.println("<td>" + c.getCemail() + "</td><td>" + c.getCaddress() + "</td></tr>");
					}
				}
			%>

		</table>
		<div class="paging">
			<%
				int totalCnt = dao.countCustomer();
				int totalPage = (int)Math.ceil((double)totalCnt / PAGESIZE);
				int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
				int endPage = startPage + BLOCKSIZE - 1;
				if (endPage > totalPage) {
					endPage = totalPage;
				}
				if (startPage > BLOCKSIZE) {
					out.println("<a href='" + conPath + "/main/main.jsp?pageNum=" + (startPage-1) + "'> 이전 </a>");
				}
				for (int i = startPage; i <= endPage; i++) {
					if (i == currentPage) {
						out.println("<b> " + i + " </b>");
					} else {
						out.println("<a href='" + conPath + "/main/main.jsp?pageNum=" + i + "'> " + i + " </a>");
					}
				}
				if (endPage < totalPage) {
					out.println("<a href='" + conPath + "/main/main.jsp?pageNum=" + (endPage+1) + "'> 다음 </a>");
				}
			%>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>