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
	</script>
</head>
<body>
	<c:if test="${updateResult != null }">
		<script>
			alert('${updateResult}');
		</script>
	</c:if>
	<form action="${conPath }/update.do" method="post">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="empno" value="${detail.empno }">
		<table>
			<caption>직원정보</caption>
			<tr>
				<th>사번</th>
				<td>${detail.empno }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="ename" value="${detail.ename }"></td>
			</tr>
			<tr>
				<th>업무</th>
				<td><input type="text" name="job" value="${detail.job }"></td>
			</tr>
			<tr>
				<th>급여</th>
				<td><input type="number" name="sal" value="${detail.sal }"></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><input type="date" name="hiredate" value="${detail.hiredate }"></td>
			</tr>
			<tr>
				<th>보너스</th>
				<td><input type="number" name="comm" value="${detail.comm }"></td>
			</tr>
			<tr>
				<th>관리자사번</th>
				<td><select name="mgr">
						<c:forEach items="${managerList }" var="manager">
							<option value="${manager.empno }"
							<c:if test="${detail.mgr eq manager.empno }">
								selected="selected"
							</c:if>
							>${manager.ename }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>부서코드</th>
				<td><select name="deptno">
						<c:forEach items="${deptList }" var="dept">
							<option value="${dept.deptno }"
							<c:if test="${detail.deptno eq dept.deptno }">
								selected="selected"
							</c:if>
							>${dept.dname }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정"></td>
			</tr>
		</table>
	</form>
</body>
</html>