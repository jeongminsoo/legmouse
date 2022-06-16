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
	<c:set var="num" value="1234567.8"/>
	<p>num : ${num }</p>
	<fmt:formatNumber value="${num }" groupingUsed="true"/><br>
	<fmt:formatNumber value="${num }" pattern="#,###.00"/>
	<c:set var="num" value="3.16"/>
	<fmt:formatNumber value="${num }" pattern="#.#"/>
</body>
</html>