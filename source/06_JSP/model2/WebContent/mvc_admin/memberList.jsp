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
	<link href="${conPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<c:if test="${admin == null }">
		<script>
			alert('관리자만 이용가능합니다');
			location.href='${conPath}/main/main.jsp'
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div id="list_wrap">
		<table>
			<caption>전체 회원 보기</caption>
			<c:if test="${members.size() eq 0 }">
				<tr>
					<td>등록된 회원이 없습니다</td>
				</tr>
			</c:if>
			<c:if test="${members.size() != 0 }">
				<tr>
					<c:forEach items="${members }" var="m">
						<td>
							<ul>
								<li><img src="${conPath }/mPhotoUp/${m.mphoto}"></li>
								<li>${m.mname }</li>
								<li>(${m.mid })</li>
							</ul>
						</td>
					</c:forEach>
				</tr>
			</c:if>
		</table>
		<div class="paging">
			<a href="${conPath }/memberList.do?pageNum=1"> &lt;&lt; </a>
			<c:if test="${startPage > BLOCKSIZE }">
				<a href="${conPath }/memberList.do?pageNum=${startPage - 1}"> &lt; </a>
			</c:if>
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<c:if test="${i eq currentPage }">
					<b> ${i } </b>
				</c:if>
				<c:if test="${i != currentPage }">
					<a href="${conPath }/memberList.do?pageNum=${i }"> ${i } </a>
				</c:if>
			</c:forEach>
			<c:if test="${endPage < pageCnt }">
				<a href="${conPath }/memberList.do?pageNum=${endPage + 1}"> > </a>
			</c:if>
			<a href="${conPath }/memberList.do?pageNum=${pageCnt }"> >> </a>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>