<%@page import="com.custom.dto.MemberDto"%>
<%@page import="com.custom.dao.MemberDao"%>
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
		int custno = Integer.parseInt(request.getParameter("custno"));
		MemberDao dao = MemberDao.getInstance();
		MemberDto member = dao.getMember(custno);
	%>
	<jsp:include page="../main/header.jsp"/>
	<jsp:include page="../main/nav.jsp"/>
	<section>
		<form action="<%=conPath %>/member/modify.jsp" method="post">
			<table>
				<caption>홈쇼핑 회원 정보 수정</caption>
				<tr>
					<th>회원번호(자동발생)</th>
					<td><input type="text" name="custno" value="<%=member.getCustno()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" name="custname" value="<%=member.getCustname()%>"></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" name="phone" value="<%=member.getPhone()%>"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type="text" name="address" value="<%=member.getAddress()%>"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="date" name="tempdate"
						value="<%=member.getJoindate()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>고객등급<br>(A:VIP,B:일반,C:직원)
					</th>
					<td><input type="text" name="grade" value="<%=member.getGrade()%>"></td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type="text" name="city" value="<%=member.getCity()%>"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정" class="btn"> <input
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