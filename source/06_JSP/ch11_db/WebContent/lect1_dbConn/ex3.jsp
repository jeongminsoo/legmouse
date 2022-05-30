<%@page import="java.sql.Timestamp"%>
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
	String deptnoStr = request.getParameter("deptno");
	if (deptnoStr == null) {
		deptnoStr = "0";
	}
	int deptno = Integer.parseInt(deptnoStr);
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String upw = "tiger";
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String sql1 = "SELECT * FROM DEPT";
	String sql2 = "SELECT * FROM EMP WHERE DEPTNO = " + deptno;
%>
<form action="">
		부서번호
		<select name="deptno">
			<option value="0"></option>
<%
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, uid, upw);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql1);
		
		while (rs.next()) {
			int deptnoDB = rs.getInt("deptno");
			String dname = rs.getString("dname");
			
			if (deptnoDB != deptno) {
				out.println("<option value='" + deptnoDB+"'>" + deptnoDB + " - " +dname +"</option>");
				
			} else {
				out.println("<option value='" + deptnoDB+"'"+ "selected='selected'>" + deptnoDB + " - " +dname +"</option>");
			}
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	} finally {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
%>
	
		</select>
		<input type="submit">
		<table>
			<tr>
				<th>사번</th><th>이름</th><th>직책</th><th>상사사번</th><th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th>
				<%
					try {
						conn = DriverManager.getConnection(url, uid, upw);
						stmt = conn.createStatement();
						rs = stmt.executeQuery(sql2);
						
						if (rs.next()) {
							do {
								int empno = rs.getInt("empno");
								String ename = rs.getString("ename");
								String job = rs.getString("job");
								int mgr = rs.getInt("mgr");
								Timestamp hiredate = rs.getTimestamp("hiredate");
								int sal = rs.getInt("sal");;
								int comm = rs.getInt("comm");
								
								out.println("<tr><td>" + empno + "</td><td>" + ename + "</td><td>" + job + "</td><td>" + mgr + "</td><td>" + hiredate + "</td><td>" + sal + "</td><td>" + comm + "</td><td>" + deptno + "</td></tr>");
							} while(rs.next());
						} else {
							out.println("<tr><td>사원이 없습니다</td></tr>");
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					} finally {
						try {
							if (rs != null) {
								rs.close();
							}
							if (stmt != null) {
								stmt.close();
							}
							if (conn != null) {
								conn.close();
							}
						} catch (Exception e1) {
							System.out.println(e1.getMessage());
						}
					}
				%>
			</tr>
		</table>
	</form>
</body>
</html>