<%@page import="com.custom.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.custom.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			width : 800px;
			height : 300px;
			margin : 10px auto;
			background-color : black;
		}
		section table tr {
			background-color : white;
		}
		
		section table tr td a {
			color : black;
			font-weight : normal;
		}
	</style>
</head>
<body>
	<%
		MemberDao dao = MemberDao.getInstance();
		ArrayList<MemberDto> members = dao.listMember();
	%>
	<jsp:include page="../main/header.jsp"/>
	<jsp:include page="../main/nav.jsp"/>
	<section>
		<table>
			<caption>회원 목록조회/수정</caption>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>회원전화</th>
				<th>주소</th>
				<th>가입일</th>
				<th>고객등급</th>
				<th>도시코드</th>
			</tr>
			<%
				for (MemberDto member : members) {
			%>
			<tr>
				<td><a href="<%=conPath%>/member/modifyForm.jsp?custno=<%=member.getCustno()%>"><%=member.getCustno() %></a></td>
				<td><%=member.getCustname() %></td>
				<td><%=member.getPhone() %></td>
				<td><%=member.getAddress() %></td>
				<td><%=member.getJoindate() %></td>
				<td><%=member.getGrade() %></td>
				<td><%=member.getCity() %></td>
			</tr>
			<%		
				}
			%>
		</table>
	</section>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>