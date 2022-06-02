<%@page import="com.lec.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
	<script src="<%=conPath %>/js/join.js"></script>
</head>
<body>
	<form action='joinOk.jsp' method="post" name="join_frm">
		<table>
			<caption>회원가입</caption>
			<tr>
				<th><label for="id">아이디</label></th>
				<td><input type="text" id="id" name="id"></td>
			</tr>
			<tr>
				<th><label for="pw">비밀번호</label></th>
				<td><input type="password" id="pw" name="pw"></td>
			</tr>
			<tr>
				<th><label for="pwChk">비밀번호확인</label></th>
				<td><input type="password" id="pwChk" name="pwChk"></td>
			</tr>
			<tr>
				<th><label for="name">이름</label></th>
				<td><input type="text" id="name" name="name"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<select name="phone1">
						<option>010</option>
						<option>031</option>
						<option>02</option>
						<option>032</option>
					</select> - <input type="text" id="phone2" name="phone2" size="2" maxlength="4"> - <input type="text" id="phone3" name="phone3" size="2" maxlength="4">
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<input type="radio" id="gender" name="gender" value="m"> 남
					<input type="radio" id="gender" name="gender" value="f"> 여
				</td>
			</tr>
			<tr>
				<th><label for="email">이메일</label></th>
				<td><input type="email" id="email" name="email"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" id="birth" name="tempbirth"></td>
			</tr>
			<tr>
				<th><label for="address">주소</label></th>
				<td><input type="text" id="address" name="address"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="회원가입" onclick="infoConfirm()">
					<input type="reset" value="취소">
					<input type="button" value="로그인" onclick="location.href='login.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>