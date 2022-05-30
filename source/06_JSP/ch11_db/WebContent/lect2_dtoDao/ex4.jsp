<%@page import="com.lec.dto.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.EmpDAO"%>
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
	String name = request.getParameter("name");
	if (name == null) {
		name = "";
	}
	
%>
	<form action="">
		이름
		<input type="text" name="name" value="<%=name%>">
		<input type="submit" value="검색">
	</form>
	<table>
		<tr>
			<th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th>
		</tr>
		<%
			EmpDAO dao = EmpDAO.getInstance();
			ArrayList<EmpDTO> dtos = dao.serchName(name);
			
			if (!dtos.isEmpty()) {
				for (EmpDTO dto : dtos) {
					out.println("<tr><td>" + dto.getEmpno() + "</td><td>" + dto.getEname() + "</td><td>" + dto.getJob() + "</td><td>" + dto.getMgr() + "</td><td>" + dto.getHiredate() + "</td><td>" + dto.getSal() + "</td><td>" + dto.getComm() + "</td><td>" + dto.getDeptno() + "</td></tr>");
				}
				
			} else {
				out.println("<tr><td colspan='8'>사원이 없습니다</td></tr>");
			}
			
			
		%>
	</table>
</body>
</html>