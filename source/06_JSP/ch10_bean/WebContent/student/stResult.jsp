<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="s" class="com.lec.ex.Student" scope="request"/>
	<h2>학생 정보 출력</h2>
	<p>학번 : <jsp:getProperty property="stNum" name="s"/></p>
	<p>이름 : <jsp:getProperty property="name" name="s"/></p>
	<p>학년 : <jsp:getProperty property="grade" name="s"/></p>
	<p>학과 : <jsp:getProperty property="major" name="s"/></p>
	<p>점수 : <jsp:getProperty property="score" name="s"/></p>
</body>
</html>