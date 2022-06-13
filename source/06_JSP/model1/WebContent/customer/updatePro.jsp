<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="java.sql.Date"%>
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
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDto" scope="request"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String cid = request.getParameter("cid");
		String oldpw = request.getParameter("oldPw"); // 현재비밀번호
		String cpw = request.getParameter("cpw"); // 새비밀번호
		String cpwChk = request.getParameter("cpwChk");
		if (cpw.equals("")) {
			cpw = oldpw;
			cpwChk = cpw;
		}
		String tempbirth = request.getParameter("tempbirth");
		
		CustomerDao dao = CustomerDao.getInstance();
		CustomerDto ctm = dao.getCustomer(dto.getCid()); // 현재 비밀번호 일치 확인을 위한 객체 불러오기
		
		if (!oldpw.equals(ctm.getCpw())) {
	%>
		<script>
			alert('현재 비밀번호를 확인하세요');
			history.back();
		</script>
	<%
		} else if (!cpw.equals(cpwChk)){
	%>
		<script>
			alert('새 비밀번호를 확인하세요');
			history.back();
		</script>
	<%
		} else {
			dto.setCbirth(Date.valueOf(tempbirth));
			dto.setCpw(cpw);
			int result = dao.updateCustomer(dto);
			if (result == CustomerDao.SUCCESS) {
				session.removeAttribute("customer");
				session.setAttribute("customer", dto);
	%>
			<script>
				alert('정보수정 성공!');
				location.href='../main/main.jsp';
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