<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	</script>
</head>
<body>
	<div id="wrap">
		<form action="${conPath }/emp.do" method="post">
		<p>
			사원명 <input type="text" name="ename" value="${schEmp.ename }"> 
			직책 <input type="text" name="job" value="${schEmp.job }"> 
			부서 
			<select name="deptno">
				<option value="0">모든부서</option>
				<c:forEach items="${deptList }" var="d">
					<option value="${d.deptno }"
						<c:if test="${schEmp.deptno eq d.deptno }">
							selected="selected"
						</c:if>
					>${d.dname }</option>
				</c:forEach>
			</select>
			<input type="submit" value="검색">
		</p>
		</form>
		<table>
			<tr>
				<th>사원번호</th>
				<th>이름</th>
				<th>직책</th>
				<th>관리자</th>
				<th>입사일</th>
				<th>급여</th>
				<th>상여</th>
				<th>부서번호</th>
			</tr>
			<c:if test="${empList.size() eq 0 }">
				<tr>
					<td colspan="8">등록된 회원이 없습니다</td>
				</tr>
			</c:if>
			<c:if test="${empList.size() != 0 }">
				<c:forEach items="${empList }" var="e">
					<tr>
						<td>${e.empno }</td>
						<td>${e.ename }</td>
						<td>${e.job }</td>
						<td>${e.mgr }</td>
						<td><fmt:formatDate value="${e.hiredate }" pattern="yy년MM월dd일"/></td>
						<td><fmt:formatNumber value="${e.sal }" groupingUsed="true"/></td>
						<td>
							<c:if test="${e.comm eq null }">
								0
							</c:if>
							<c:if test="${e.comm != null }">
								<fmt:formatNumber value="${e.comm }" groupingUsed="true"/>
							</c:if>
						</td>
						<td>${e.deptno }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</body>
</html>