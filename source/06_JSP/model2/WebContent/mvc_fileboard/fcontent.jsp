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
	<table>
		<caption>상세보기</caption>
		<tr>
			<th>글번호</th>
			<td>
				${content.fid }
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				${content.ftitle }
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>
				${content.fname }
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				${content.fcontent }
			</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>
				<fmt:formatDate value="${content.frdate }" pattern="yy. MM. dd"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="location.href='${conPath}/update_view.do?fid=${param.fid }&pageNum=${param.pageNum }'">수정</button>
				<button onclick="location.href='delete.do?fid=${param.fid }&pageNum=${param.pageNum }'">삭제</button>
				<button onclick="location.href='reply_view.do?fid=${param.fid }&pageNum=${param.pageNum }'">답글작성</button>
				<button onclick="location.href='list.do?pageNum=${param.pageNum }'">목록</button>
			</td>
		</tr>
	</table>
</body>
</html>