package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex2_Select {

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
		
		System.out.print("�˻��� �μ����� ? ");
		String dname = sc.next();
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			rs.next();
			
			int result = rs.getInt("cnt");
			
			if (result != 0) {
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dname);
				rs = pstmt.executeQuery();

			
				System.out.println("���\t�̸�\t��å\t�޿�");
				while(rs.next()) {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int sal = rs.getInt("sal");
					System.out.println(empno + "\t" + ename + "\t" + job + "\t" + sal);
				}
			} else {
				System.out.println("�������� �ʴ� �μ��Դϴ�.");
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
		sc.close();
		
		
		
	}
}
