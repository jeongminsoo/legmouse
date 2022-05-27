<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/join.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="join_wrap">
		<div id="title">
			MUSINSA
		</div>
		<div id="join_input">
			
		  <form action="joinPro.jsp" method="post">
		  	<input type="hidden" name="hiddenParam" value="xx">
			<table>
				<tr>
					<th><label for="name">이름</label></th>
					<td><input type="text" name="name" class="name" id="name" required="required"></td>
				</tr>
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
					<th><label for="birth">생년월일</label></th>
					<td><input type="date" name="birth" class="birth" id="birth" required="required"></td>
				</tr>
				<tr>
					<th>취미</th>
					<td>
						<input type="checkbox" name="hobby" value="독서"> 독서 
						<input type="checkbox" name="hobby" value="요리"> 요리 
						<input type="checkbox" name="hobby" value="운동"> 운동 
						<input type="checkbox" name="hobby" value="취침"> 취침 
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="gender" value="남" checked="checked">남자
						<input type="radio" name="gender" value="여">여자
					</td>
				</tr>
				<tr>
					<th><label for="email">이메일</label></th>
					<td><input type="email" name="email" class="email" id="email" required="required"></td>
				</tr>
				<tr>
					<th>메일수신</th>
					<td>
						<select name="mailSend" multiple="multiple" class="mailSend">
							<option>광고</option>
							<option>배송</option>
							<option>공지</option>
							<option>댓글</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="가입하기" name="btn" class="btn">
						<input type="reset" value="다시하기" name="btn" class="btn">
					</td>
				</tr>
			</table>
		  </form>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>