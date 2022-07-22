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
	<script>
		$(document).ready(function() {
			
		});
		
		function trclick(empno) {
			location.href='${conPath}/detail.do?empno=' + empno + "&pageNum=${paging.currentPage}";
		}
	</script>
</head>
<body>
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
	<c:if test="${updateResult != null }">
		<script>
			alert('수정 성공');
		</script>
	</c:if>
	<c:if test="${insertResult eq 1 }">
		<script>
			alert('등록 성공');
		</script>
	</c:if>
	<c:if test="${insertResult eq 0 }">
		<script>
			alert('등록 실패');
			history.back();
		</script>
	</c:if>
	<c:set var="num" value="${paging.totCnt - paging.startRow + 1 }"></c:set>
	<table>
		<caption>직원목록</caption>
		<tr><td colspan="6" align="right"><a href="${conPath }/insertView.do">직원등록</a></td></tr>
		<tr>
			<th>번호</th>
			<th>사번</th>
			<th>이름</th>
			<th>업무</th>
			<th>부서명</th>
			<th>근무지</th>
		</tr>
		<c:if test="${empDeptList.size() eq 0 }">
			<tr><td colspan="6">등록된 사원이 없습니다</td></tr>
		</c:if>
		<c:if test="${empDeptList.size() != 0 }">
			<c:forEach items="${empDeptList }" var="emp">
				<tr onclick="trclick(${emp.empno})">
					<td>${num }</td>
					<td>${emp.empno }</td>
					<td>${emp.ename }</td>
					<td>${emp.job }</td>
					<td>${emp.dname }</td>
					<td>${emp.loc }</td>
				</tr>
				<c:set var="num" value="${num - 1 }"/>
			</c:forEach>
		</c:if>
	</table>
	<c:if test="${paging.startPage > paging.blockSize }">
		[ <a href="${conPath }/empDeptList.do?pageNum=${paging.startPage - 1}">이전</a> ]
	</c:if>
	<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }">
		<c:if test="${i eq paging.currentPage }">
			[ <b>${i }</b> ]
		</c:if>
		<c:if test="${i != paging.currentPage }">
			[ <a href="${conPath}/empDeptList.do?pageNum=${i}">${i }</a> ]
		</c:if>
	</c:forEach>
	<c:if test="${paging.endPage < paging.pageCnt }">
		[ <a href="${conPath }/empDeptList.do?pageNum=${paging.endPage + 1}">다음</a> ]
	</c:if>
</body>
</html>