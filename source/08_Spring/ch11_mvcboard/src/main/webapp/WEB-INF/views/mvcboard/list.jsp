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
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		$(document).ready(function() {
			/* $('tr').click(function(){
				var bid = $(this).children().eq(2).text();
				if (!isNaN(bid)) {
					location.href='${conPath}/mvcboard/content.do?pageNum=${pageNum}&bid=' + bid;
				}
				
			}); */
		});
		
		function trclicked(bid) {
			location.href='${conPath}/mvcboard/content.do?pageNum=${pageNum}&bid=' + bid;
		}
	</script>
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:set var="ordNum" value="${orderNum }"/>
	<c:set var="invNum" value="${inverseNum }"/>
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
	<c:if test="${deleteResult eq 1 }">
		<script>
			alert('글 삭제 성공');
		</script>
	</c:if>
	<c:if test="${deleteResult eq 0 }">
		<script>
			alert('글 삭제 실패');
		</script>
	</c:if>
	<table>
		<tr>
			<td><a href="${conPath }/mvcboard/write.do">글쓰기</a></td>
		</tr>
	</table>
	<table>
		<tr>
			<th>순번</th><th>역순</th><th>글번호</th><th>글쓴이</th><th>글제목</th><th>작성일</th><th>조회수</th>
		</tr>
		<c:if test="${totCnt eq 0 }">
			<tr>
				<td colspan="7">등록된 글이 없습니다</td>
			</tr>
		</c:if>
		<c:if test="${totCnt != 0  }">
			<c:forEach items="${boardList }" var="b">
				<tr onclick="trclicked(${b.bid})">
					<td>${ordNum }</td>
					<td>${invNum }</td>
					<td>${b.bid }</td>
					<td>${b.bname }</td>
					<td class="left">
						<c:if test="${b.bindent != 0 }">
							<c:forEach var="i" begin="1" end="${b.bindent }">
								<c:if test="${i eq b.bindent }">
									└
								</c:if>
								<c:if test="${i != b.bindent }">
									&nbsp; &nbsp; &nbsp;
								</c:if>
							</c:forEach>
						</c:if>
						${b.btitle }
					</td>
					<td>
						<fmt:formatDate value="${b.bdate }" pattern="yy/MM/dd(E) hh:mm:ss(a)"/>
					</td>
					<td><fmt:formatNumber value="${b.bhit }" groupingUsed="true"/></td>
				</tr>
				<c:set var="ordNum" value="${ordNum + 1 }"/>
				<c:set var="invNum" value="${invNum - 1 }"/>
			</c:forEach>
		</c:if>
	</table>
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }">
			<a href="${conPath }/mvcboard/list.do?pageNum=${startPage - 1}">이전</a>
		</c:if>
		<c:forEach var="j" begin="${startPage }" end="${endPage }">
			<c:if test="${j eq pageNum }">
				<b>${j }</b>
			</c:if>
			<c:if test="${j != pageNum }">
				<a href="${conPath }/mvcboard/list.do?pageNum=${j}">${j }</a>
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a href="${conPath }/mvcboard/list.do?pageNum=${endPage + 1}">다음</a>
		</c:if>
	</div>
</body>
</html>