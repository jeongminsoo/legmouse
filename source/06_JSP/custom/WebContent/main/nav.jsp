<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		a {
			text-decoration : none;
			font-weight : bold;
			color : black;
		}
		li {
			list-style : none;
		}
		nav {
			width : 100%;
			min-width : 1000px;
			background-color : lightgreen;
		}
		nav ul {
			overflow : hidden;
			width : 1000px;
			margin : 0 auto;
		}
		nav ul li {
			float : left;
			text-align : center;
			margin : 0 75px;
		}
	</style>
</head>
<body>
	<nav>
		<ul>
			<li><a href="<%=conPath%>/member/joinForm.jsp">회원등록</a></li>
			<li><a href="<%=conPath%>/member/listAndModify.jsp">회원조회/수정</a></li>
			<li><a href="<%=conPath%>/member/list.jsp">매출조회(회원/제품)</a></li>
			<li><a href="<%=conPath%>/main/main.jsp">홈으로</a></li>
		</ul>
	</nav>
</body>
</html>