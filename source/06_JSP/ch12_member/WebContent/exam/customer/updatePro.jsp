<%@page import="java.sql.Date"%>
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
	<jsp:useBean id="dto" class="com.lec.customer.CustomerDto" scope="request"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String id = request.getParameter("id");
		String oldpw = request.getParameter("oldPw"); // 현재비밀번호
		String pw = request.getParameter("pw"); // 새비밀번호
		String pwChk = request.getParameter("pwChk");
		if (pw.equals("")) {
			pw = oldpw;
			pwChk = pw;
		}
		String tempbirth = request.getParameter("tempbirth");
		
		CustomerDao dao = CustomerDao.getInstance();
		CustomerDto ctm = dao.getCustomer(dto.getId()); // 현재 비밀번호 일치 확인을 위한 객체 불러오기
		
		if (!oldpw.equals(ctm.getPw())) {
	%>
		<script>
			alert('현재 비밀번호를 확인하세요');
			history.back();
		</script>
	<%
		} else if (!pw.equals(pwChk)){
	%>
		<script>
			alert('새 비밀번호를 확인하세요');
			history.back();
		</script>
	<%
		} else {
			dto.setBirth(Date.valueOf(tempbirth));
			dto.setPw(pw);
			int result = dao.updateCustomer(dto);
			if (result == CustomerDao.SUCCESS) {
				session.removeAttribute("customer");
				session.setAttribute("customer", dto);
	%>
			<script>
				alert('정보수정 성공!');
				location.href='main.jsp';
			</script>
	<%
			} else {
	%>
			<script>
				alert('정보수정 실패! 다시 시도하세요');
				history.back();
			</script>
	<%
			}
		}
	%>
</body>
</html>