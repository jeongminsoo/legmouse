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
		<tr>
			<th>번호</th><th>아이디</th><th>비밀번호</th><th>이름</th><th>생일</th><th>가입일</th>
		</tr>
		<c:if test="${memberList.size() eq 0 }">
			<td colspan="6">등록된 회원이 없습니다</td>
		</c:if>
		<c:set var="idx" value="1"/>
		<c:if test="${memberList.size() != 0 }">
			<c:forEach items="${memberList }" var="m">
			<tr>
				<td>${idx }</td>
				<td>${m.id }</td>
				<td>${m.pw }</td>
				<td>${m.name }</td>
				<td>
					<fmt:formatDate value="${m.birth }" pattern="MM월 dd일"/>
				</td>
				<td>${m.rdate }</td>
			</tr>
				<c:set var="idx" value="${idx + 1 }"/>
			</c:forEach>
		</c:if>
		<tr>
			<td colspan="6">
				<input type="button" value="메인" class="btn" onclick="location.href='${conPath}/index.jsp'">
				<input type="button" value="회원가입" class="btn" onclick="location.href='${conPath}/memberJoin_view.do'">
			</td>
		</tr>
	</table>
</body>
</html>