package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex2_Select2_1 {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		String sql = "SELECT EMPNO, ENAME, JOB, SAL "
					+ "FROM EMP E, DEPT D "
					+ "WHERE E.DEPTNO = D.DEPTNO AND DNAME = UPPER(?)";
		
		String sql1 = "SELECT COUNT(*) CNT FROM DEPT WHERE DNAME = UPPER(?)";
		
		do {
			System.out.print("검색할 부서명은 ? ");
			String dname = sc.next();
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, dname);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					rs.close();
					pstmt.close();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, dname);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("사번\t이름\t직책\t급여");
						while(rs.next()) {
							int empno = rs.getInt("empno");
							String ename = rs.getString("ename");
							String job = rs.getString("job");
							int sal = rs.getInt("sal");
							System.out.println(empno + "\t" + ename + "\t" + job + "\t" + sal);
						}
					} else {
						System.out.println("부서가 존재하지만 사원이 없습니다.");
						continue;
					}
				} else {
					System.out.println("부서가 존재하지 않습니다.");
					continue;
				}
				
				
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
				}
			}
			break;
			
			
		} while(true);

		sc.close();
		
		
	}
}
