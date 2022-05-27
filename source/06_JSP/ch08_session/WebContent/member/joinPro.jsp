<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/join.css" rel="stylesheet">
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String hidden = request.getParameter("hiddenParam");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String birth = request.getParameter("birth");
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String[] mailSend = request.getParameterValues("mailSend");
		session.setAttribute("id", id);
	%>
	<jsp:include page="header.jsp"/>
	<div id="join_wrap">
		<div id="title">
			회원가입을 축하드립니다!
		</div>
		<h2>hiddenParam : <%=hidden %></h2>
		<h2>이름 : <%=name %></h2>
		<h2>아이디 : <%=id %></h2>
		<h2>비밀번호 : <%=pw %></h2>
		<h2>생년월일 : <%=birth %></h2>
		<h2>취미 : <%
					if (hobby == null) {
						out.println("없음");
					} else {
						out.println(hobby.toString());	
					}
				 %>
		</h2>
		<h2>성별 : <%=gender %></h2>
		<h2>email : <%=email %></h2>
		<h2>메일수신 : <%
						if (mailSend == null) {
							out.println("없음");
						} else {
							out.println(mailSend.toString());
						}
					%>
		</h2>
		
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>