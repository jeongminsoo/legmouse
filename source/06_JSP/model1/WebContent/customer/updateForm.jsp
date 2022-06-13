<%@page import="com.lec.dto.CustomerDto"%>
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
	<link href="<%=conPath %>/css/join.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="joinForm_wrap">
		<div id="join_title">정보수정</div>
		<form action="updatePro.jsp" method="post">
			<table>
				<tr>
					<th><label for="cid">아이디</label></th>
					<td><input type="text" name="cid" class="cid" id="cid" value="<%=customer.getCid() %>" readonly="readonly"></td>
				</tr>
				<tr>
					<th><label for="oldPw">현재비밀번호</label></th>
					<td><input type="password" name="oldPw" class="oldPw" id="oldPw" required="required"></td>
				</tr>
				<tr>
					<th><label for="cpw">새비밀번호</label></th>
					<td><input type="password" name="cpw" class="cpw" id="cpw"></td>
				</tr>
				<tr>
					<th><label for="pwChk">새비밀번호확인</label></th>
					<td><input type="password" name="cpwChk" class="cpwChk" id="cpwChk"></td>
				</tr>
				<tr>
					<th><label for="name">이름</label></th>
					<td><input type="text" name="cname" class="cname" id="cname" value='<%=customer.getCname() %>' required="required"></td>
				</tr>
				<tr>
					<th><label for="ctel">전화</label></th>
					<td><input type="text" name="ctel" class="ctel" id="ctel" value='<%=customer.getCtel() %>' required="required"></td>
				</tr>
				<tr>
					<th><label for="cemail">이메일</label></th>
					<td><input type="text" name="cemail" class="cemail" id="cemail" value='<%=customer.getCemail() == null ? "" : customer.getCemail() %>'></td>
				</tr>
				<tr>
					<th><label for="caddress">주소</label></th>
					<td><input type="text" name="caddress" class="caddress" id="caddress" value='<%=customer.getCaddress() == null ? "" : customer.getCaddress()%>'></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="date" name="tempbirth" class="tempbirth" id="tempbirth" value="<%=customer.getCbirth()%>"required="required"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="cgender" class="cgender" value="m" <%if (customer.getCgender().equals("m")) out.println("checked='checked'"); %>> 남자
						<input type="radio" name="cgender" class="cgender" value="f" <%if (customer.getCgender().equals("f")) out.println("checked='checked'"); %>> 여자
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정하기" class="joinBtn_style">
						<input type="reset" value="다시하기" class="joinBtn_style">
						<input type="button" value="메인으로"  class="joinBtn_style" onclick="location.href='main.jsp'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>