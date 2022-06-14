<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table {
			text-align : center;
		}
		td {
			width : 40px;
		}
		input:not(.btn) {
			width : 100%;
		}
		h3 {
			color : red;
		}
	</style>
</head>
<body>
	<form action="">
	<table>
		<tr>
			<td>
				<input type="text" name="num1" value="<%=(int)(Math.random()*9)+1%>" readonly="readonly">
			</td>
			<td>*</td>
			<td>
				<input type="text" name="num2" value="<%=(int)(Math.random()*9)+1%>" readonly="readonly">
			</td>
			<td>=</td>
			<td><input type="number" name="answer"></td>
		</tr>
		<tr>
			<td colspan="5">
				<input type="submit" value="확인" class="btn">
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<h3>${param.num1 } * ${param.num2 } = ${param.answer}는 ${param.num1 * param.num2 eq param.answer ? "true 정답" : false }</h3>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>