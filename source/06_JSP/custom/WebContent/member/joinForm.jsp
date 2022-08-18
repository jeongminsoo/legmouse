<%@page import="com.custom.dao.MemberDao"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function checkName() {
		var custnameVal = frm.custname.value;
		if (custnameVal == '' || custnameVal == null) {
			alert('회원성명은 필수 입력사항입니다');
			frm.custname.focus();
			return false;
		} else {
			return true;
		}
	}
</script>
<style>
	section {
			text-align : center;
			width : 1000px;
			height : 400px;
			margin : 0 auto;
	}
	section table {
		width : 600px;
		height : 300px;
		margin : 10px auto;
	}
	section table tr {
		background-color : lightgray;
	}
	input:not(.btn) {
		width : 95%;
	}
</style>
</head>
<body>
	<%
		MemberDao dao = MemberDao.getInstance();
		int custno = dao.getCustno();
	%>
	<jsp:include page="../main/header.jsp"/>
	<jsp:include page="../main/nav.jsp"/>
	<section>
		<form action="<%=conPath %>/member/joinPro.jsp" method="post" name="frm" onsubmit="return checkName()">
			<table>
				<caption>홈쇼핑 회원 등록</caption>
				<tr>
					<th>회원번호(자동발생)</th>
					<td><input type="text" name="custno" value="<%=custno + 1 %>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" name="custname"></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="date" name="tempdate"
						value="<%=new Date(System.currentTimeMillis())%>"></td>
				</tr>
				<tr>
					<th>고객등급<br>(A:VIP,B:일반,C:직원)
					</th>
					<td><input type="text" name="grade"></td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type="text" name="city"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="등록" class="btn"> <input
						type="button" value="조회"
						onclick="location.href='<%=conPath%>/member/listAndModify.jsp'" class="btn">
					</td>
				</tr>
			</table>
		</form>
	</section>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>