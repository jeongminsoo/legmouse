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
	<form action="${conPath }/mvcboard/modify.do" method="post">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="bid" value="${param.bid }">
		<table>
			<caption>${param.bid }번 글 수정</caption>
			<tr>
				<th>제목</th>
				<td><input type="text" name="btitle" value="${bDto.btitle}"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bname" value="${bDto.bname }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="bcontent" rows="5" cols="20">${bDto.bcontent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" class="btn">
					<input type="reset" value="취소" class="btn" onclick="history.back()">
					<input type="button" value="목록" class="btn" onclick="location.href='${conPath}/mvcboard/list.do?pageNum=${param.pageNum }'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>