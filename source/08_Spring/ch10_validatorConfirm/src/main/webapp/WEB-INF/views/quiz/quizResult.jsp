<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<table>
		<caption>결과는 다음과 같습니다</caption>
		<col style="width : 50px;">
		<col style="width : 100px;">
		<tr>
			<th>이름</th>
			<td>${quiz.name }</td>
		</tr>
		<tr>
			<th>국어</th>
			<td>${quiz.kor }</td>
		</tr>
		<tr>
			<th>영어</th>
			<td>${quiz.eng }</td>
		</tr>
		<tr>
			<th>수학</th>
			<td>${quiz.math }</td>
		</tr>
		<tr>
			<th>총점</th>
			<td>${total }</td>
		</tr>
		<tr>
			<th>평균</th>
			<td><fmt:formatNumber value="${avg }" pattern="##.00"/> </td>
		</tr>
		<tr>
			<th colspan="2">
				<button onclick="history.back()">뒤로가기</button>
				<button onclick="location.href='${conPath}/quizInputForm.do'">다시입력</button>
			</th>
		</tr>
	</table>
	
</body>
</html>