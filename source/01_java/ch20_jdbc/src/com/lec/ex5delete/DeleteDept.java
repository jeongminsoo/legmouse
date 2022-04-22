package com.lec.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteDept {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Connection conn = null;
		java.sql.Statement stmt = null;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();


			

		System.out.print("������ �μ���ȣ�� ? ");
		int deptno = sc.nextInt();
		String sql = "DELETE FROM DEPT WHERE DEPTNO = " + deptno;
		int result = stmt.executeUpdate(sql);
		System.out.println(result > 0 ? "���� ����" : "���� ����");
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ���� : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL ���� : " + e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
			sc.close();
			
			
			
			
		
		
	}
}
