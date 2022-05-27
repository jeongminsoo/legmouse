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
	<!-- 객체 프로세스 단계 -->
	<jsp:useBean class="com.lec.ex.Person" id="p" scope="page"/> 
	<jsp:setProperty property="name" name="p" value='<%=request.getParameter("name") %>'/>
	<jsp:setProperty property="age" name="p" value='<%=Integer.parseInt(request.getParameter("age")) %>'/>
	<jsp:setProperty property="gender" name="p" value='<%=request.getParameter("gender").charAt(0) %>'/>
	<jsp:setProperty property="address" name="p" value='<%=request.getParameter("address") %>'/>
	
	<!-- 객체 뷰 단계 -->
	<h2>입력받은 개인정보</h2>
	<p>이름 : <jsp:getProperty property="name" name="p"/></p>
	<p>나이 : <jsp:getProperty property="age" name="p"/></p>
	<p>성별 : <jsp:getProperty property="gender" name="p"/></p>
	<p>주소 : <jsp:getProperty property="address" name="p"/></p>
</body>
</html>