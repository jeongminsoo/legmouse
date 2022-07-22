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
	<script>
		function deleteBoard(bno) {
			var answer = confirm("정말 " + bno + "번 글을 삭제하시겠습니까?");
			if (answer == true) {
				location.href='${conPath }/board/delete.do?bno=${content.bno }&pageNum=${param.pageNum }';
			} else {
				return false;
			}
		}
	</script>
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${modifyResult eq SUCCESS }">
		<script>
			alert('수정 성공');
		</script>
	</c:if>
	<c:if test="${modifyResult eq FAIL }">
		<script>
			alert('수정 실패');
		</script>
	</c:if>
	<table>
		<caption>상세보기</caption>
		<tr>
			<th>글번호</th>
			<td>
				${content.bno }
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				${content.btitle }
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>
				${content.bname }
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				${content.bcontent }
			</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>
				<fmt:formatDate value="${content.brdate }" pattern="yyyy년 MM월 dd일(E)"/>
			</td>
		</tr>
		<tr>
			<th>IP</th>
			<td>
				${content.bip }
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="location.href='${conPath}/board/modifyView.do?bno=${content.bno }&pageNum=${param.pageNum }'">수정</button>
				<button onclick="deleteBoard(${content.bno})">삭제</button>
				<button onclick="location.href='${conPath }/board/replyView.do?bno=${content.bno }&pageNum=${param.pageNum }'">답글작성</button>
				<button onclick="location.href='${conPath }/board/list.do?pageNum=${param.pageNum }'">목록</button>
			</td>
		</tr>
	</table>
</body>
</html>