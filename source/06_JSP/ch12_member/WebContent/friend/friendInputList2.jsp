<%@page import="com.lec.friend.FriendDaoSearch"%>
<%@page import="com.lec.friend.FriendDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
	<script>
		function search() {
			var name = frm.name.value;
			var phone = frm.phone.value;
			location.href = 'friendInputList2.jsp?name='+name+'&phone='+phone;
		}
	</script>
</head>
<body>
	<%
		String msg = request.getParameter("msg");
		FriendDaoSearch dao = FriendDaoSearch.getInstance();
	%>
	<form action="friendInputListPro.jsp" name="frm" method="post">
		<table>
			<tr>
				<th>친구이름</th>
				<td><input type="text" name="name"></td>
				<th>전화</th>
				<td><input type="tel" name="phone"></td>
				<td><input type="button" value="검색" onclick="search()"></td>
				<td><input type="submit" value="추가"></td>
			</tr>
			<tr>
				<td colspan="6">
					<table>
						<tr>
							<th>순번</th><th>이름</th><th>전화</th>
							<%
								String name = request.getParameter("name");
								String phone = request.getParameter("phone");
								ArrayList<FriendDto> SearchFull = dao.SearchFull(name, phone);
								if (SearchFull.isEmpty()) {
									out.println("<tr><td colspan='6'>검색 결과가 없습니다</td></tr>");
								} else {
									for (FriendDto f : SearchFull) {
										out.println("<tr><td>" + f.getNo() + "</td><td>" + f.getName() + "</td><td>" + f.getPhone());
									}
								}
							%>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>