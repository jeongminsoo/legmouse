<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="ex2_scope.jsp">
		<p>이름<input type="text" name="name"></p>
		<p>ID<input type="text" name="id"></p>
		<p><input type="submit"></p>
	</form>
	<%
		pageContext.setAttribute("pageName", "pageValue");
		request.setAttribute("requestName", "requestVale");
		session.setAttribute("sessionName", "sessionValue");
		application.setAttribute("applicationName", "applicationValue");
		// forward 할 객체 (dispatcher)
		RequestDispatcher disp = request.getRequestDispatcher("ex2_scope.jsp");
		disp.forward(request, response);
	%>
	<h3>페이지내 속성변수 값 : <%=pageContext.getAttribute("pageName") %></h3>
	<h3>request내 속성변수 값 : <%=request.getAttribute("requestName") %></h3>
	<h3>session내 속성변수 값 : <%=session.getAttribute("sessionName") %></h3>
	<h3>application내 속성변수 값 : <%=application.getAttribute("applicationName") %></h3>
	<hr>
	<h3>페이지내 속성변수 값 : ${pageScope.pageName}</h3>
	<h3>request내 속성변수 값 : ${requestScope.requestName}</h3>
	<h3>session내 속성변수 값 : ${sessionScope.sessionName}</h3>
	<h3>application내 속성변수 값 : ${applicationScope.applicationName}</h3>
	<hr>
	<!-- scope객체일 경우 생략 가능 -->
	<h3>페이지내 속성변수 값 : ${pageName}</h3>
	<h3>request내 속성변수 값 : ${requestName}</h3>
	<h3>session내 속성변수 값 : ${sessionName}</h3>
	<h3>application내 속성변수 값 : ${applicationName}</h3>
</body>
</html>