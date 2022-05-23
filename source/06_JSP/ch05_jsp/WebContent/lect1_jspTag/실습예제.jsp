<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String numStr = request.getParameter("number");
	%>
	<form action="">
		<fieldset>
			<legend>숫자입력</legend>
			<p>숫자 <input type="number" name="number" min="1" value="<%if(numStr!=null) out.println(numStr);%>"> <input type="submit" value="누적"></p>
		</fieldset>
	</form>
	<%
		
		if (numStr != null && numStr == "") {
			int num = Integer.parseInt(numStr);
			int total = 0;
			for (int i = 1; i <= num; i++) {
				total += i;
			}
			out.println("<h2>" + total + "</h2>");
		}

	%>
</body>
</html>