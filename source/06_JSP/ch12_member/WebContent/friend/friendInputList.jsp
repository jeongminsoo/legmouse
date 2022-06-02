<%@page import="com.lec.friend.FriendDao"%>
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
</head>
<body>
	<%
		String msg = request.getParameter("msg");
		FriendDao dao = FriendDao.getInstance();
		ArrayList<FriendDto> friends = dao.printAll();
	%>
	<form action="friendInputListPro.jsp">
		<table>
			<tr>
				<th>친구이름</th>
				<td><input type="text" name="name"></td>
				<th>전화</th>
				<td><input type="tel" name="phone"></td>
				<td><input type="submit" value="추가"></td>
			</tr>
			<tr>
				<td colspan="5">
					<table>
						<tr>
							<th>순번</th><th>이름</th><th>전화</th>
							<%
								if (friends == null) {
									out.println("<tr><td colspan='5'></td></tr>");
								} else {
									for (FriendDto f : friends) {
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