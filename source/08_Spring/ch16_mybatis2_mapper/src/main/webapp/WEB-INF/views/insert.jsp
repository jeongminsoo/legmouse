<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(document).ready(function() {
		$('form').submit(function(){
			var msg = $('span').text();
			if (!msg) {
				alert('중복확인을 확인하세요')
				return false;
			} else if (msg != '사용가능한 사번입니다') {
				alert('중복된 사번입니다. 수정하세요');
				frm.empno.focus();
				return false;
			}
		});
		
	});
	
	function chk() {
		if (!frm.empno.value) {
			alert('사번을 입력하세요');
			frm.empno.focus();
		} else {
			var empno = frm.empno.value;
			var ename = frm.ename.value;
			var job = frm.job.value;
			var sal = frm.sal.value;
			var hiredate = frm.hiredate.value;
			if (!hiredate) {
				hiredate = '<%=new Date(System.currentTimeMillis()) %>';
			}
			var comm = frm.comm.value;
			var mgr = frm.mgr.value;
			var deptno = frm.deptno.value;
			
			location.href='confirmNo.do?empno=' + empno + "&ename=" + ename + "&job=" + job + "&sal=" + sal
					+ "&hiredate=" + hiredate + "&comm=" + comm + "&mar=" + mgr + "&deptno=" + deptno;
		}
	}
</script>
</head>
<body>
	<c:if test="${insertResult != null }">
		<script>
			alert('${insertResult}');
		</script>
	</c:if>
	<form action="${conPath }/insert.do" method="post" name="frm">
		<table>
			<caption>직원정보</caption>
			<tr>
				<th>사번</th>
				<td>
					<input type="number" name="empno" maxlength="4" value="${emp.empno }">
					<input type="button" value="중복확인" onclick="chk()"><br>
					<span>
						<c:if test="${not empty msg }">${msg }</c:if>
					</span>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="ename" value="${emp.ename }"></td>
			</tr>
			<tr>
				<th>업무</th>
				<td><input type="text" name="job" value="${emp.job }"></td>
			</tr>
			<tr>
				<th>급여</th>
				<td><input type="number" name="sal" value="${emp.sal }"></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><input type="date" name="hiredate" value="${emp.hiredate }"></td>
			</tr>
			<tr>
				<th>보너스</th>
				<td><input type="number" name="comm" value="${emp.comm }"></td>
			</tr>
			<tr>
				<th>관리자사번</th>
				<td><select name="mgr">
						<c:forEach items="${managerList }" var="manager">
							<option value="${manager.empno }"
							<c:if test="${emp.mgr eq manager.empno }">seleted="selected"</c:if>
							>${manager.ename }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>부서코드</th>
				<td><select name="deptno">
						<c:forEach items="${deptList }" var="dept">
							<option value="${dept.deptno }"
							<c:if test="${emp.deptno eq dept.deptno }">seleted="selected"</c:if>
							>${dept.dname }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록"></td>
			</tr>
		</table>
	</form>
</body>
</html>