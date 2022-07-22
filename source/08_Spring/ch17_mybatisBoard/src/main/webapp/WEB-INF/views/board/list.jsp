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
	<script>
		function trclicked(bno) {
			location.href='${conPath}/board/content.do?pageNum=${paging.currentPage}&bno=' + bno;
		}
	</script>
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${writeResult eq SUCCESS }">
		<script>
			alert('글쓰기 성공');
		</script>
	</c:if>
	<c:if test="${writeResult eq FAIL }">
		<script>
			alert('글쓰기 실패');
		</script>
	</c:if>
	<c:if test="${replyResult eq SUCCESS }">
		<script>
			alert('답글쓰기 성공');
		</script>
	</c:if>
	<c:if test="${replyResult eq FAIL }">
		<script>
			alert('답글쓰기 실패');
		</script>
	</c:if>
	<c:if test="${deleteResult eq SUCCESS }">
		<script>
			alert('글 삭제 성공');
		</script>
	</c:if>
	<c:if test="${deleteResult eq FAIL }">
		<script>
			alert('글 삭제 실패');
		</script>
	</c:if>
	<c:set var="oNum" value="${orderNum  }"/>
	<c:set var="iNum" value="${inverseNum }"/>
	<table>
		<tr>
			<td><a href="${conPath }/board/writeView.do">글쓰기</a></td>
		</tr>
	</table>
	<table>
		<tr>
			<th>순번</th><th>역순</th><th>글번호</th><th>글쓴이</th><th>글제목</th><th>작성일</th><th>조회수</th>
		</tr>
		<c:if test="${boardList.size() eq 0 }">
			<tr>
				<td colspan="7">등록된 글이 없습니다</td>
			</tr>
		</c:if>
		<c:if test="${boardList.size() != 0  }">
			<c:forEach items="${boardList }" var="board">
				<tr onclick="trclicked(${board.bno})">
					<td>${oNum }</td>
					<td>${iNum }</td>
					<td>${board.bno }</td>
					<td>${board.bname }</td>
					<td class="left">
						<c:if test="${board.bindent != 0 }">
							<c:forEach var="i" begin="1" end="${board.bindent }">
								<c:if test="${i eq board.bindent }">
									└
								</c:if>
								<c:if test="${i != board.bindent }">
									&nbsp; &nbsp; &nbsp;
								</c:if>
							</c:forEach>
						</c:if>
						${board.btitle }
					</td>
					<td>
						<fmt:formatDate value="${board.brdate }" pattern="yy/MM/dd(E)"/>
					</td>
					<td><fmt:formatNumber value="${board.bhit }" groupingUsed="true"/></td>
				</tr>
				<c:set var="oNum" value="${oNum + 1 }"/>
				<c:set var="iNum" value="${iNum - 1 }"/>
			</c:forEach>
		</c:if>
	</table>
	<div class="paging">
		<c:if test="${paging.startPage > paging.blockSize }">
			[ <a href="${conPath }/board/list.do?pageNum=${paging.startPage - 1}">이전</a> ]
		</c:if>
		<c:forEach var="j" begin="${paging.startPage }" end="${paging.endPage }">
			<c:if test="${j eq pageNum }">
				[ <b>${j }</b> ]
			</c:if>
			<c:if test="${j != pageNum }">
				[ <a href="${conPath }/board/list.do?pageNum=${j}">${j }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${paging.endPage < paging.pageCnt }">
			[ <a href="${conPath }/board/list.do?pageNum=${paging.endPage + 1}">다음</a> ]
		</c:if>
	</div>
</body>
</html>