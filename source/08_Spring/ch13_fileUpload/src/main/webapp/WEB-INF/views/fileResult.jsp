<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		$(document).ready(function() {
			
		});
	</script>
</head>
<body>
	<h2>파일 업로드 결과 : ${fileResult }</h2>
	<p>file1 : ${filenames[0] }</p>
	<p>file2 : ${filenames[1] }</p>
	<p>file3 : ${filenames[2] }</p>
	<c:set var="i" value="1"></c:set>
	<c:forEach items="${filenames }" var="f">
		<c:if test="${not empty f }">
			<img src="${conPath }/upload/${f}">
		</c:if>
		<c:if test="${empty f }">
			${i }번째 첨부파일 첨부 안함
		</c:if>
		<c:set var="i" value="${i+1 }"></c:set>
	</c:forEach>
		<%-- <c:if test="${not empty filenames[0] }">
			<img src="${conPath }/upload/${filenames[0]}">
		</c:if>
		<c:if test="${empty filenames[0] }">
			첫번째 첨부파일 첨부 안함
		</c:if>
		<c:if test="${not empty filenames[1] }">
			<img src="${conPath }/upload/${filenames[1]}">
		</c:if>
		<c:if test="${empty filenames[1] }">
			두번째 첨부파일 첨부 안함
		</c:if>
		<c:if test="${not empty filenames[2] }">
			<img src="${conPath }/upload/${filenames[2]}">
		</c:if>
		<c:if test="${empty filenames[2] }">
			세번째 첨부파일 첨부 안함
		</c:if>	 --%>
</body>
</html>