package com.lec.ex2selectwhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڿ��� ���ϴ� �μ���ȣ�� �Է¹޾� �μ� ���� ���
public class Ex1_SelectDeptno {

	public static void main(String[] args) {
		
		String 		driver 	= "oracle.jdbc.driver.OracleDriver";
		String 		url 	= "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection 	conn 	= null;
		Statement 	stmt 	= null;
		ResultSet 	rs 		= null;
		Scanner 	sc 		= new Scanner(System.in);
		System.out.print("���ϴ� �μ���ȣ�� ?");
		int deptno = sc.nextInt();
		String 		sql1 	= "SELECT * FROM DEPT WHERE DEPTNO = " + deptno;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			
			if (rs.next()) {
				System.out.println("�μ��̸� : " + rs.getString("dname"));
				System.out.println("�μ���ġ : " + rs.getString("loc"));
			} else {
				System.out.println(deptno + "�� �μ��� �����ϴ�.");
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
