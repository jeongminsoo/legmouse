package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept {

	public static void main(String[] args) {
		
		String 		driver 	= "oracle.jdbc.driver.OracleDriver";
		String 		url 	= "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			System.out.print("수정할 부서번호는? ");
			int deptno = sc.nextInt();
			System.out.print("수정할 부서명은? ");
			String dname = sc.next();
			System.out.print("수정할 위치는? ");
			String loc = sc.next();
			String sql = String.format("UPDATE DEPT SET DNAME = '%s', LOC = '%s' WHERE DEPTNO = %d", dname, loc, deptno);
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "업데이트 성공" : "업데이트 실패");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
		sc.close();
		
	}
}
