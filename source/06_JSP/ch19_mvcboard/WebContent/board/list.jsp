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
	<c:if test="${writeResult eq 1 }">
		<script>
			alert('글쓰기 성공');
		</script>
	</c:if>
	
	<c:if test="${writeResult eq 0 }">
		<script>
			alert('글쓰기 실패');
		</script>
	</c:if>
	
	<c:if test="${modifyResult eq 1 }">
		<script>
			alert('수정 성공');
		</script>
	</c:if>
	
	<c:if test="${modifyResult eq 0 }">
		<script>
			alert('수정 실패');
		</script>
	</c:if>
	
	<c:if test="${deleteResult eq 1 }">
		<script>
			alert('삭제 성공');
		</script>
	</c:if>
	
	<c:if test="${deleteResult eq 0 }">
		<script>
			alert('삭제 실패');
		</script>
	</c:if>
	
	<c:if test="${replyResult eq 1 }">
		<script>
			alert('답글쓰기 성공');
		</script>
	</c:if>
	
	<c:if test="${replyResult eq 0 }">
		<script>
			alert('답글쓰기 실패');
		</script>
	</c:if>
	
	<table>
		<caption>게시판</caption>
		<tr>
			<td colspan="5"><a href="write_view.do">글쓰기</a></td>
		</tr>
	</table>
	<table>
		<tr>
			<th>글번호</th><th>작성자</th><th>글제목</th><th>조회수</th><th>작성일</th>		
		</tr>
		<c:if test="${list.size() eq 0 }">
			<tr><td colspan="5">등록된 글이 없습니다</td></tr>
		</c:if>
		<c:if test="${list.size() != 0 }">
			<c:forEach items="${list }" var="b">
				<tr>
					<td>${b.bid }</td>
					<td>${b.bname }</td>
					<td class="left">
						<c:forEach var="i" begin="1" end="${b.bindent }">
							<c:if test="${i eq b.bindent }">
								└─
							</c:if>
							<c:if test="${i != b.bindent }">
								&nbsp; &nbsp;
							</c:if>
						</c:forEach>
						<a href="${conPath }/content_view.do?bid=${b.bid}&pageNum=${currentPage}">
							${b.btitle }
						</a>
						<c:if test="${b.bhit > 10 }">
							<b> * </b>
						</c:if>
					</td>
					<td>${b.bhit }</td>
					<td>
						<fmt:formatDate value="${b.bdate }" pattern="yyyy년 MM월 dd일(E) a hh:mm"/>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE}">
			<a href="${conPath }/list.do?pageNum=${startPage - 1}"> 이전 </a>
		</c:if>
		<c:forEach var="j" begin="${startPage }" end="${endPage }">
			<c:if test="${j eq currentPage }">
				<b> ${j } </b>
			</c:if>
			<c:if test="${j != currentPage }">
				<a href="${conPath }/list.do?pageNum=${j}"> ${j } </a>
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a href="${conPath }/list.do?pageNum=${endPage + 1}"> 다음 </a>
		</c:if>
	</div>
</body>
</html>