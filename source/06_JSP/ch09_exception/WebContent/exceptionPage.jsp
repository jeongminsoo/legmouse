<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<% response.setStatus(200); %>
<!--
	200 : 정상상태
	400 : 해당문서를 찾을 수 없을때
	407 : 인증을 받지 못한 경우
	500 : 문법오류나 예외사항이 발생한 경우
 -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		console.log('예외 메세지 : ' + '<%=exception.getMessage() %>');
		console.log('예외 타입 : ' + '<%=exception.getClass().getName() %>');
	</script>
</head>
<body>
	<h1>공사중입니다. 0으로 나누는 부분은 아직 처리되지 않았습니다</h1>
	<h6>문의 주시면 감사하겠습니다</h6>
	<%
		System.out.println("예외 메세지 : " + exception.getMessage());
		System.out.println("예외 타입 : " + exception.getClass().getName());
	%>
</body>
</html>