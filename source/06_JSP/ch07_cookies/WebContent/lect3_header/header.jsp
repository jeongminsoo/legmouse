<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		header {
			width : 1000px;
			margin : 0 auto;
		}
		header a {
			text-decoration: none;
			color : black;
		}
		
		header #nav ul {
			overflow: hidden;
		}
		header #nav ul li {
			float : right;
			list-style : none;
			padding : 10px 30px;
		}
	</style>
	<script>
		function list() {
			var child = open("cookielist.jsp","","width=300,height=300,left=200,top=200");
		}
	</script>
</head>
<body>
	<%
		String id = null;
		Cookie[] cs = request.getCookies();
		if (cs != null) {
			for (Cookie c : cs) {
				if (c.getName().equals("id")) {
					id = c.getValue();
					break;
				}
			}
		}
	%>
	<header>
		<div id="nav">
		<% if(id == null) { %>
			<ul>
				<li><a href="join.jsp">회원가입</a></li>
				<li><a href="login.jsp">로그인</a></li>
				<li><a href="main.jsp">홈</a></li>
			</ul>
		<%} else {%>
			<ul>
				<li><a href="logout.jsp">로그아웃</a></li>
				<li><a href="" onclick="list();">쿠키리스트</a></li>
				<li><%=id %>님</li>
			</ul>
		<%} %>
		</div>
	</header>
</body>
</html>