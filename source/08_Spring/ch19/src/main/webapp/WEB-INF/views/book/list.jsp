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
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<style>
		#content {width: 800px; height:350px;margin: 50px auto; }
		img{width: 100px;}
		a {text-decoration: none; color:black;}
		b {color:red;}
	</style>
	
</head>
<body>
	<c:if test="${addResult eq 1 }">
		<script>
			alert('책 등록 성공');
		</script>
	</c:if>
	<c:if test="${addResult eq 0 }">
		<script>
			alert('책 등록 실패');
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<table>
			<caption>도서 LIST</caption>
			<c:if test="${empty books }">
				<tr>
					<td colspan="3">등록된 도서가 없습니다</td>
				</tr>
			</c:if>
			<c:if test="${not empty books }">
				<tr>
					<c:forEach items="${books }" var="book">
						<td>
							${book.btitle }<br>
							<a href="${conPath }/book.do?method=detail&bno=${book.bno}&pageNum=${paging.currentPage}">
							<img src="${conPath }/bookImgFileUpload/${book.bimg1}"></a><br>
							${book.bwriter } 著 <br>
							출판일 : ${book.brdate }
						</td>
					</c:forEach>
				</tr>
			</c:if>
		</table>
		<div class="paging">
			<c:if test="${paging.startPage > paging.blockSize }">
				[ <a href="${conPath }/book.do?method=list&pageNum=${paging.startPage - 1}">이전</a> ]
			</c:if>
			<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }">
				<c:if test="${i eq paging.currentPage }">
					<span class="curr">[ <b>${i }</b> ]</span>
				</c:if>
				<c:if test="${i != paging.currentPage }">
					[ <a href="${conPath }/book.do?method=list&pageNum=${i}">${i }</a> ]
				</c:if>
			</c:forEach>
			<c:if test="${paging.endPage < pageCnt }">
				[ <a href="${conPath }/book.do?method=list&pageNum=${paging.endPage + 1}">다음</a> ]
			</c:if>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>