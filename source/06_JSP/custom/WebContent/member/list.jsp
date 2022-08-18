<%@page import="com.custom.dto.MoneyDto"%>
<%@page import="com.custom.dao.MoneyDao"%>
<%@page import="java.util.ArrayList"%>
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
			width : 800px;
			height : 150px;
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
		MoneyDao dao = MoneyDao.getInstance();
		ArrayList<MoneyDto> moneys = dao.totalMember();
		ArrayList<MoneyDto> pcodes = dao.totalPcode();
	%>
	<jsp:include page="../main/header.jsp"/>
	<jsp:include page="../main/nav.jsp"/>
	<section>
		<table>
			<caption>회원 매출 조회</caption>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>고객등급</th>
				<th>매출</th>
			</tr>
			<%
				for (MoneyDto money : moneys) {
			%>
			<tr>
				<td><%=money.getCustno() %></td>
				<td><%=money.getCustname() %></td>
				<td><%=money.getGname() %></td>
				<td><%=money.getTotal() %></td>
			</tr>
			<%		
				}
			%>
		</table>
		<table>
			<caption>제품 매출 조회</caption>
			<tr>
				<th>제품코드</th>
				<th>매출</th>
			</tr>
			<%
				for (MoneyDto pcode : pcodes) {
			%>
			<tr>
				<td><%=pcode.getPcode() %></td>
				<td><%=pcode.getTotal() %></td>
			</tr>
			<%		
				}
			%>
		</table>
	</section>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>