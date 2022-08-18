<%@page import="com.custom.dto.MemberDto"%>
<%@page import="com.custom.dao.MemberDao"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		
		int custno = Integer.parseInt(request.getParameter("custno"));
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String tempdate = request.getParameter("tempdate");
		Date joindate = null;
		if (tempdate != null) {
			joindate = Date.valueOf(tempdate);
		}
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		
		MemberDao dao = MemberDao.getInstance();
		MemberDto dto = new MemberDto(custno, custname, phone, address, joindate, grade, city);
		int result = dao.modify(dto);
		
		if (result == MemberDao.SUCCESS) {
	%>
			<script>
				alert('회원정보 수정이 완료되었습니다');
				location.href="<%=conPath%>/member/listAndModify.jsp";
			</script>
	<%	} else { %>
			<script>
				alert('회원정보 수정에 실패하였습니다');
				history.back();
			</script>
	<%	} %>
</body>
</html>