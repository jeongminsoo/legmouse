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
		#content {
			width: 800px; height:350px;
			margin: 50px auto;
		}
		img{width: 100px;}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<table>
			<caption>책 상세보기</caption>
			<col style="width : 150px;">
			<col style="width : 50px;">
			<col style="width : 100px;">
			<tr>
				<td rowspan="5">
					<img src="${conPath }/bookImgFileUpload/${book.bimg1}">
				</td>
			</tr>
			<tr>
				<th>책제목</th>
				<td>${book.btitle }</td>
			</tr>
			<tr>
				<th>저자</th>
				<td>${book.bwriter }</td>
			</tr>
			<tr>
				<th>출판일</th>
				<td>${book.brdate }</td>
			</tr>
			<tr>
				<th>책소개</th>
				<td>${book.binfo }</td>
			</tr>
		</table>
		<div>
			<button onclick="location.href='${conPath }/book.do?method=updateForm&bno=${book.bno}&pageNum=${param.pageNum }'">수정</button>
			<button onclick="location.href='${conPath}/book.do?method=list&pageNum=${param.pageNum}'">목록</button>
		</div>
	</div>
	
	<jsp:include page="../main/footer.jsp"/>
	
</body>
</html>

