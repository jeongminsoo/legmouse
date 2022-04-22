package com.lec.ex1_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		String sql = "SELECT COUNT(*) CNT FROM JOB WHERE JNAME = ?";
		String sql2 = "SELECT ROWNUM||'��' \"RANK\", A.*" + 
				" FROM (SELECT PNAME||'('||PNO||'��)' \"NAME\", JNAME, KOR, ENG, MAT, (KOR+ENG+MAT) \"TOTAL\" FROM PERSON P, JOB J" + 
				" WHERE P.JNO = J.JNO ORDER BY TOTAL DESC) A" + 
				" WHERE JNAME = ?";
		
		System.out.print("���ϴ� ������ �Է��ϼ��� : ");
		String job = sc.next();
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, job);
			rs = pstmt.executeQuery();
			rs.next();
			int result = rs.getInt("cnt");
			System.out.println(result);
			
			if (result > 0) {  // ������ ������ ���
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, job);
				rs = pstmt.executeQuery();
				
				System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
				while (rs.next()) {
					int rank = rs.getInt("rank");
					String name = rs.getString("name");
					String jname = rs.getString("jname");
					int kor = rs.getInt("kor");
					int eng = rs.getInt("eng");
					int mat = rs.getInt("mat");
					int total = rs.getInt("total");
					System.out.println(rank + "\t" + name + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + total);
				}
			} else {
				System.out.println("�������� �ʴ� �����Դϴ�.");
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
				System.out.println(e.getMessage());
			}
		}
	}
}
