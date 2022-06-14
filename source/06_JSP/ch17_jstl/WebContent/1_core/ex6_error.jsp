<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>예외처리</h2>
	
	<c:catch var="error">
		<%=8/0 %>
		예외가 발생되는 즉시 catch절을 빠져나감.
		
	</c:catch>
	<c:out value="${error }" default="예외 발생 안됨"/>
</body>
</html>