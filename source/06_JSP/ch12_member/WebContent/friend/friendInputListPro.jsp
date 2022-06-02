<%@page import="com.lec.friend.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		FriendDao dao = FriendDao.getInstance();
		
		if (name == null || name.equals("") || phone == null || phone.equals("")) {
	%>
			<script>
				alert('이름, 전화번호를 입력하세요');
				history.back();
			</script>
	<%
		} else {
			if (phone.lastIndexOf('-') != 8) {
	%>
			<script>
				alert('전화번호 형식을 확인해주세요(010-1111-1111)');
				history.back();
			</script>
	<%
			} else {
				if (dao.checkName(name) == FriendDao.FAIL) {
					out.println("<script>alert('이미 등록된 이름입니다.');</script>");
					out.println("<script>history.back();</script>");
				} else if (dao.checkPhone(phone) == FriendDao.FAIL){
					out.println("<script>alert('이미 등록된 전화입니다.');</script>");
					out.println("<script>history.back();</script>");
				} else {
					int result = dao.addFriend(name, phone);
					if (result == FriendDao.SUCCESS) {
	%>
					<script>
						alert('친구 추가 성공');
						location.href='friendInputList.jsp'
					</script>
	<%
					} else {
	%>
					<script>
						alert('친구추가 실패');
						location.href='friendInputList.jsp'
					</script>
	<%
					}
				}
			}
		}
		
	%>
	
</body>
</html>