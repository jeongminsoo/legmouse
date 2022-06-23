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
	<jsp:include page="../main/header.jsp"/>
	<table>
		<caption>게시판</caption>
		<tr>
			<c:if test="${member != null }">
				<td colspan="6"><a href="write_view.do">글쓰기</a></td>
			</c:if>
			<c:if test="${member == null }">
				<td colspan="6">글쓰기는 사용자 로그인 이후에만 가능합니다</td>
			</c:if>
		</tr>
	</table>
	<table>
		<tr>
			<th>글번호</th><th>작성자</th><th>글제목</th><th>조회수</th><th>작성일</th><th>IP</th>		
		</tr>
		<c:if test="${list.size() eq 0 }">
			<tr><td colspan="6">등록된 글이 없습니다</td></tr>
		</c:if>
		<c:if test="${list.size() != 0 }">
			<c:forEach items="${list }" var="f">
				<tr>
					<td>${f.fid }</td>
					<td>${f.mname }</td>
					<td class="left">
						<c:forEach var="i" begin="1" end="${f.findent }">
							<c:if test="${i eq f.findent }">
								└─
							</c:if>
							<c:if test="${i != f.findent }">
								&nbsp; &nbsp;
							</c:if>
						</c:forEach>
						<a href="${conPath }/detail.do?fid=${f.fid}&pageNum=${currentPage}">
							${f.ftitle }
						</a>
						<c:if test="${f.fhit > 10 }">
							<b> * </b>
						</c:if>
					</td>
					<td>${f.fhit }</td>
					<td>
						<fmt:formatDate value="${f.frdate }" pattern="yy. MM. dd"/>
					</td>
					<td>${f.fip }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE}">
			<a href="${conPath }/fileboardList.do?pageNum=${startPage - 1}"> &lt; </a>
		</c:if>
		<c:forEach var="j" begin="${startPage }" end="${endPage }">
			<c:if test="${j eq currentPage }">
				<b> ${j } </b>
			</c:if>
			<c:if test="${j != currentPage }">
				<a href="${conPath }/fileboardList.do?pageNum=${j}"> ${j } </a>
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a href="${conPath }/fileboardList.do?pageNum=${endPage + 1}"> > </a>
		</c:if>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>