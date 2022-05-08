package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept {

	public static void main(String[] args) {
		
		String 		driver 	= "oracle.jdbc.driver.OracleDriver";
		String 		url 	= "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("입력할 부서번호는 ? ");
		int deptno = sc.nextInt();
		String selectSQL1 = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO = " + deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSQL1);
			rs.next();
			int cnt1 = rs.getInt("cnt");
			if (cnt1 != 0) {
				System.out.println("이미 입력된 부서입니다.");
			} else {
				System.out.print("입력할 부서명은 ? ");
				String dname = sc.next();
				rs.close();
				String selectSQL2 = "SELECT COUNT(*) CNT FROM DEPT WHERE DNAME = UPPER('" + dname + "')";
				rs = stmt.executeQuery(selectSQL2);
				rs.next();
				int cnt2 = rs.getInt("cnt");
				if (cnt2 != 0) {
					System.out.println("이미 입력된 부서입니다.");
				} else {
					System.out.print("입력할 부서위치는 ? ");
					String loc = sc.next();
					String sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
					int result = stmt.executeUpdate(sql);
					System.out.println(result > 0 ? "입력성공" : "입력실패");
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
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
			} catch (SQLException e) {
			}
		}
		sc.close();
		
	}
}
