
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/join.css" rel="stylesheet">
	<script>
		window.onload = function () {
			document.querySelector('form').onsubmit = function () {
				var pw = document.querySelector("input[name='pw']");
				var pwChk = document.querySelector("input[name='pwChk']");
				if (pw.value != pwChk.value) {
					alert('비밀번호를 확인하세요');
					pw.value = '';
					pwChk.value = '';
					pw.focus();
					return false;
				}
				var hobby = document.querySelectorAll("input[name='hobby']");
				var hobbyCnt = 0;
				for (var i = 0; i < hobby.length; i++) {
					if (hobby[i].checked) {
						hobbyCnt++;
					}
				}
				if (!hobbyCnt) {
					alert('취미를 하나 이상 선택하세요');
					return false;
				}
				return true;
			};
		};
	</script>
</head>
<body>
	<div id="wrap">
		<div id="title">회원가입</div>
		<form action="joinPro.jsp" name="frm">
		<table>
			<tr>
				<th><label for="name">이름</label></th>
				<td><input type="text" name="name" id="name" class="name" required="required"></td>
			</tr>
			<tr>
				<th><label for="id">아이디</label></th>
				<td><input type="text" name="id" id="id" class="id" required="required"></td>
			</tr>
			<tr>
				<th><label for="pw">비밀번호</label></th>
				<td><input type="password" name="pw" id="pw" class="pw" required="required"></td>
			</tr>
			<tr>
				<th><label for="pwChk">비밀번호확인</label></th>
				<td><input type="password" name="pwChk" id="pwChk" class="pwChk"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="birth" id="birth" class="birth"></td>
			</tr>
			<tr>
				<th>취미</th>
				<td>
					<input type="checkbox" name="hobby" value="독서">독서
					<input type="checkbox" name="hobby" value="요리">요리
					<input type="checkbox" name="hobby" value="운동">운동
					<input type="checkbox" name="hobby" value="취침">취침
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<input type="radio" name="gender" value="m" checked="checked">남자
					<input type="radio" name="gender" value="f">여자
				</td>
			</tr>
			<tr>
				<th><label for="email">이메일</label></th>
				<td><input type="email" name="email" id="email" class="email" required="required"></td>
			</tr>
			<tr>
				<th>메일수신</th>
				<td>
					<select name="mailSend" id="mailSend" class="mailSend" multiple="multiple">
						<option>광고</option>
						<option>배송</option>
						<option>공지</option>
						<option>댓글</option>
					</select>
				</td>
			</tr>
			<tr><td></td></tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="btn" class="btn" value="가입하기">
					<input type="reset" name="btn" class="btn" value="다시하기">
					<input type="button" name="btn" class="btn" value="뒤로가기" onclick="history.go(-1);">
				</td>
			</tr>
		</table>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>