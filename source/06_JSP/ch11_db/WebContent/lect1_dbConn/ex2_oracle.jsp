<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "scott";
		String upw = "tiger";
	%>
	<table>
		<%
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM EMP";
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, uid, upw);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					out.println("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						String job = rs.getString("job");
						int mgr = rs.getInt("mgr");
						Date hiredate = rs.getDate("hiredate");
						int sal = rs.getInt("sal");
						int comm = rs.getInt("comm");
						int deptno = rs.getInt("deptno");
						out.println("<tr><td>"+empno+"</td><td>"+ename + "</td><td>"+job+"</td><td>"+mgr+"</td><td>"+hiredate+"</td><td>"+sal+"</td><td>"+comm+"</td><td>"+deptno+"</td></tr>");
						
					} while (rs.next());
						
				} else {
					out.println("<tr><td>입력된 데이터가 없습니다</td></tr>");
				}
			} catch (Exception e) {
				System.out.println("message : " + e.getMessage());
			} finally {
				try {
					if (rs!=null) {
						rs.close();
					}
					if (stmt!=null) {
						stmt.close();
					}
					if (conn!=null) {
						conn.close();
					}
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		%>
	</table>
</body>
</html>