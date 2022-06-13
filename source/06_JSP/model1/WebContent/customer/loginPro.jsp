<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath();
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String cid = request.getParameter("cid");
		String cpw = request.getParameter("cpw");
		CustomerDao dao = CustomerDao.getInstance();
		int result = dao.loginChk(cid, cpw);
		
		if (result == CustomerDao.SUCCESS) {
			session.removeAttribute("cid");
			CustomerDto customer = dao.getCustomer(cid);
			session.setAttribute("customer", customer);
			response.sendRedirect("../main/main.jsp");
		} else {
	%>
		<script>
			alert('아이디와 비밀번호를 확인해주세요');
			location.href='login.jsp?msg=xx';
		</script>
	<%
		}
	%>
</body>
</html>