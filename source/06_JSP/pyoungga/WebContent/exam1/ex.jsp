<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table { text-align : center; width : 350px;
				height : 250px; 	 margin : 30px auto;
				border : 1px solid black;
			  }
		input { width : 50px; height : 50px; }
		#msg { width : 300px; 		margin : 0 auto;
			   text-align : center; color : red;
			   font-weight : bold;
			 }
	</style>
</head>
<body>
	<table>
		<caption>동전 위치 맞추기</caption>
		<tr>
			<td>
				<form action="exPro.jsp">
					<input type="submit" name="num" value="1">
				</form>
			</td>
			<td>
				<form action="exPro.jsp">
					<input type="submit" name="num" value="2">
				</form>
			</td>
			<td>
				<form action="exPro.jsp">
					<input type="submit" name="num" value="3">
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<div id="msg">
					<%
						String msg = request.getParameter("msg");
						if (msg != null) {
							out.print(msg);
						}
					%>
				</div>
			</td>
		</tr>
	</table>
	
</body>
</html>