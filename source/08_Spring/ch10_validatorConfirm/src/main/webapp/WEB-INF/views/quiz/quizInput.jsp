<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h2 style="color : red;">&ldquo;현재 총 ${cnt }명&ldquo;</h2>
	<form action="${conPath }/quizInput.do" method="post">
		<table>
			<caption>개인 정보 입력</caption>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value='${quiz.name}'></td>
			</tr>
			<tr>
				<th>국어</th>
				<td><input type="number" name="kor" value='${quiz.kor eq 0 ? "" : quiz.kor}'></td>
			</tr>
			<tr>
				<th>영어</th>
				<td><input type="number" name="eng" value='${quiz.eng eq 0 ? "" : quiz.eng}'></td>
			</tr>
			<tr>
				<th>수학</th>
				<td><input type="number" name="math" value='${quiz.math eq 0 ? "" : quiz.math}'></td>
			</tr>
			<tr>
				<th><input type="submit" value="입력"></th>
			</tr>
		</table>
	</form>
	<h4>${nameError }</h4>
	<h4>${korError }</h4>
	<h4>${engError }</h4>
	<h4>${mathError }</h4>
</body>
</html>