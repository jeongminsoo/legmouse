<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="com.lec.customer.CustomerDao"%>
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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		CustomerDao dao = CustomerDao.getInstance();
		int result = dao.loginChk(id, pw);
		
		if (result == CustomerDao.SUCCESS) {
			session.removeAttribute("id");
			CustomerDto customer = dao.getCustomer(id);
			session.setAttribute("customer", customer);
			response.sendRedirect("main.jsp");
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