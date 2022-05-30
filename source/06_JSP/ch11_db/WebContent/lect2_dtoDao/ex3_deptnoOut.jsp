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
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		EmpDAO dao = EmpDAO.getInstance();
		
		ArrayList<EmpDTO> dtos = dao.searchDeptno(deptno);
		out.println("<table>");
		if (!dtos.isEmpty()) {
			out.println("<tr><th>사번</th><th>이름</th><th>입사일</th><th>부서번호</th></tr>");
			for (EmpDTO dto : dtos) {
				out.println("<tr><td>"+dto.getEmpno() + "</td><td>" + dto.getEname() + "</td><td>" + dto.getHiredate() + "</td><td>" + dto.getDeptno() + "</td></tr>");
			}
		} else {
			out.println("<tr><td>사원이 없습니다</td></tr>");
		}
			
			out.println("</table>");
	%>
</body>
</html>