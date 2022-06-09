<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/exam/css/join.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="join_wrap">
		<div id="title">
			<h2>회원가입</h2>
		</div>
		<div id="join_input">
			<form action="joinPro.jsp" method="post">
			<table>
				<tr>
					<th><label for="id">아이디</label></th>
					<td><input type="text" name="id" class="id" id="id" required="required"></td>
				</tr>
				<tr>
					<th><label for="pw">비밀번호</label></th>
					<td><input type="password" name="pw" class="pw" id="pw" required="required"></td>
				</tr>
				<tr>
					<th><label for="pwChk">비밀번호확인</label></th>
					<td><input type="password" name="pwChk" class="pwChk" id="pwChk"></td>
				</tr>
				<tr>
					<th><label for="name">이름</label></th>
					<td><input type="text" name="name" class="name" id="name" required="required"></td>
				</tr>
				<tr>
					<th><label for="tel">전화</label></th>
					<td><input type="text" name="tel" class="tel" id="tel" required="required"></td>
				</tr>
				<tr>
					<th><label for="email">이메일</label></th>
					<td><input type="text" name="email" class="email" id="email"></td>
				</tr>
				<tr>
					<th><label for="address">주소</label></th>
					<td><input type="text" name="address" class="address" id="address"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="date" name="tempbirth" class="tempbirth" id="tempbirth" required="required"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="gender" class="gender" id="gender" value="m" checked="checked"> 남자
						<input type="radio" name="gender" class="gender" id="gender" value="f"> 여자
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="가입하기" class="btn">
						<input type="reset" value="다시하기" class="btn">
						<input type="button" value="로그인"  class="btn" onclick="location.href='login.jsp'">
					</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>