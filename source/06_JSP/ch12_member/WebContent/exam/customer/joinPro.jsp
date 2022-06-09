<%@page import="java.sql.Date"%>
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
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:useBean id="dto" class="com.lec.customer.CustomerDto" scope="request"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String pw = request.getParameter("pw");
		String pwChk = request.getParameter("pwChk");
		String tempbirth = request.getParameter("tempbirth");
		CustomerDao dao = CustomerDao.getInstance();
		
		if (dao.idCheck(dto.getId()) == CustomerDao.FAIL) {
		
			if (!pw.equals(pwChk) || pw ==null || pw.equals("") || pwChk == null || pwChk.equals("")) {
	%>
			<script>
				alert('비밀번호를 확인하세요');
				history.back();
			</script>
	<%
			} else {
				dto.setBirth(Date.valueOf(tempbirth));
				int result = dao.joinCustomer(dto);
				
				if (result == CustomerDao.SUCCESS) {
					session.setAttribute("id", dto.getId());
	%>
				<script>
					alert('회원가입 성공! 로그인 이후 서비스 이용 가능합니다');
					location.href='login.jsp';
				</script>
	<%
				} else {
	%>
				<script>
					alert('회원가입 실패! 다시 가입해주세요');
					history.back();
				</script>
	<%
				}
			}
		} else {
	%>
		<script>
			alert('중복된 아이디입니다. 다시 입력해주세요');
			history.back();
		</script>
	<%
		}
	%>
</body>
</html>