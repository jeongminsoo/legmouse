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
		String sql2 = "SELECT ROWNUM||'등' \"RANK\", A.*" + 
				" FROM (SELECT PNAME||'('||PNO||'번)' \"NAME\", JNAME, KOR, ENG, MAT, (KOR+ENG+MAT) \"TOTAL\" FROM PERSON P, JOB J" + 
				" WHERE P.JNO = J.JNO ORDER BY TOTAL DESC) A" + 
				" WHERE JNAME = ?";
		
		System.out.print("원하는 직업을 입력하세요 : ");
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
			
			if (result > 0) {  // 직업이 존재할 경우
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, job);
				rs = pstmt.executeQuery();
				
				System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
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
				System.out.println("존재하지 않는 직업입니다.");
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
