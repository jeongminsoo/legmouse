<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/list_view.css" rel="stylesheet">
</head>
<body>
	<fieldset>
		<legend>전체 회원 보기</legend>
		<ul>
			<c:if test="${members.size() eq 0 }">
				<li>
					<h2>등록된 회원이 없습니다</h2>
				</li>
			</c:if>
			<c:if test="${members.size() != 0 }">
				<c:forEach items="${members }" var="m">
				<li>
					<img src="${conPath }/mPhotoUp/${m.mphoto}"><br>
				${m.mname }<br>
				(${m.mid })
				</li>
				</c:forEach>
			</c:if>
		</ul>
		<div class="paging">
			<a href="${conPath }/list_view.do?pageNum=1"> &lt;&lt; </a>
			<c:if test="${startPage > BLOCKSIZE }">
				<a href="${conPath }/list_view.do?pageNum=${startPage - 1}"> &lt; </a>
			</c:if>
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<c:if test="${i eq currentPage }">
					<b> ${i } </b>
				</c:if>
				<c:if test="${i != currentPage }">
					<a href="${conPath }/list_view.do?pageNum=${i }"> ${i } </a>
				</c:if>
			</c:forEach>
			<c:if test="${endPage < pageCnt }">
				<a href="${conPath }/list_view.do?pageNum=${endPage + 1}"> > </a>
			</c:if>
			<a href="${conPath }/list_view.do?pageNum=${pageCnt }"> >> </a>
		</div>
	</fieldset>
</body>
</html>