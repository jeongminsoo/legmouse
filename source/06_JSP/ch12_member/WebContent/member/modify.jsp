<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@page import="com.lec.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String id, name, phone1, phone2, phone3, email, gender, address;
	Timestamp birth;
%>

<%
	String conPath = request.getContextPath();
	MemberDto member = (MemberDto)session.getAttribute("member");
	if (member == null) {
		response.sendRedirect("main.jsp");
	} else {
		id = member.getId();
		name = member.getName();
		phone1 = member.getPhone1();
		phone2 = member.getPhone2();
		phone3 = member.getPhone3();
		email = member.getEmail();
		gender = member.getGender();
		address = member.getAddress();
		birth = member.getBirth();
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
	<script src="<%=conPath%>/js/modify.js"></script>
</head>
<body>
	<form action="modifyOk.jsp" method="post" name="modify_frm">
		<table>
			<caption>회원정보수정</caption>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" id="id" name="id" value="<%=id%>" readonly="readonly">
				</td>
			</tr>
			<tr>
				<th><label for="oldPw">현재비밀번호</label></th>
				<td><input type="password" id="oldPw" name="oldPw"></td>
			</tr>
			<tr>
				<th><label for="pw">새비밀번호</label></th>
				<td><input type="password" id="pw" name="pw"></td>
			</tr>
			<tr>
				<th><label for="pwChk">비밀번호확인</label></th>
				<td><input type="password" id="pwChk" name="pwChk"></td>
			</tr>
			<tr>
				<th><label for="name">이름</label></th>
				<td><input type="text" id="name" name="name" value="<%=name%>" required="required"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<select name="phone1">
						<option <%if ("010".equals(phone1)) out.println("selected=\"selected\"");%>>010</option>
						<option <%if ("031".equals(phone1)) out.println("selected=\"selected\"");%>>031</option>
						<option <%if ("02".equals(phone1)) out.println("selected=\"selected\"");%>>02</option>
						<option <%if ("032".equals(phone1)) out.println("selected=\"selected\"");%>>032</option>
					</select> - <input type="text" id="phone2" name="phone2" size="2" maxlength="4" value='<%=phone2!=null?phone2:""%>'> - <input type="text" id="phone3" name="phone3" size="2" maxlength="4" value='<%=phone3!=null?phone3:""%>'>
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<input type="radio" id="gender" name="gender" value="m" <%if ("m".equals(gender)) out.println("checked=\"chedcked\"");%>> 남
					<input type="radio" id="gender" name="gender" value="f" <%if ("f".equals(gender)) out.println("checked=\"chedcked\"");%>> 여
				</td>
			</tr>
			<tr>
				<th><label for="email">이메일</label></th>
				<td><input type="email" id="email" name="email"value='<%=email!=null?email:""%>'></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="tempbirth" value='<%=birth!=null?birth.toString().substring(0,10):""%>'></td>
			</tr>
			<tr>
				<th><label for="address">주소</label></th>
				<td><input type="text" id="address" name="address" value='<%=address!=null?address:""%>'></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="button" value="취소" onclick="location.href='modify.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>