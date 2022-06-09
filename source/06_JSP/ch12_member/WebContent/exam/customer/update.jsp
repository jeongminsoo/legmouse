<%@page import="com.lec.customer.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath();
	CustomerDto customer = (CustomerDto)session.getAttribute("customer");
	if (customer == null) {
		response.sendRedirect("main.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/exam/css/update.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="update_wrap">
		<div id="title">
			<h2>정보수정</h2>
		</div>
		<div id="update_input">
			<form action="updatePro.jsp" method="post">
			<table>
				<tr>
					<th><label for="id">아이디</label></th>
					<td><input type="text" name="id" class="id" id="id" value="<%=customer.getId() %>" readonly="readonly"></td>
				</tr>
				<tr>
					<th><label for="oldPw">현재비밀번호</label></th>
					<td><input type="password" name="oldPw" class="oldPw" id="oldPw" required="required"></td>
				</tr>
				<tr>
					<th><label for="pw">새비밀번호</label></th>
					<td><input type="password" name="pw" class="pw" id="pw"></td>
				</tr>
				<tr>
					<th><label for="pwChk">새비밀번호확인</label></th>
					<td><input type="password" name="pwChk" class="pwChk" id="pwChk"></td>
				</tr>
				<tr>
					<th><label for="name">이름</label></th>
					<td><input type="text" name="name" class="name" id="name" value='<%=customer.getName() %>' required="required"></td>
				</tr>
				<tr>
					<th><label for="tel">전화</label></th>
					<td><input type="text" name="tel" class="tel" id="tel" value='<%=customer.getTel() %>' required="required"></td>
				</tr>
				<tr>
					<th><label for="email">이메일</label></th>
					<td><input type="text" name="email" class="email" id="email" value='<%=customer.getEmail() == null ? "" : customer.getEmail() %>'></td>
				</tr>
				<tr>
					<th><label for="address">주소</label></th>
					<td><input type="text" name="address" class="address" id="address" value='<%=customer.getAddress() == null ? "" : customer.getAddress()%>'></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="date" name="tempbirth" class="tempbirth" id="tempbirth" value="<%=customer.getBirth()%>"required="required"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="gender" class="gender" id="gender" value="m" <%if (customer.getGender().equals("m")) out.println("checked='checked'"); %>> 남자
						<input type="radio" name="gender" class="gender" id="gender" value="f" <%if (customer.getGender().equals("f")) out.println("checked='checked'"); %>> 여자
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정하기" class="btn">
						<input type="reset" value="다시하기" class="btn">
						<input type="button" value="메인으로"  class="btn" onclick="location.href='main.jsp'">
					</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>