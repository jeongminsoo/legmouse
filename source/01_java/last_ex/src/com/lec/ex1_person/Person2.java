package com.lec.ex1_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Person2 {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		int temp = 0;
		
		String sql = "SELECT COUNT(*) CNT FROM JOB WHERE jNAME = ?";
		
		String sql1 = "INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, ?, "
						+ "(SELECT JNO FROM JOB WHERE JNAME = ?), ?, ?, ?)";
		
		String sql2 = "SELECT ROWNUM||'등' \"RANK\", A.*" + 
				" FROM (SELECT PNAME||'('||PNO||'번)' \"NAME\", JNAME, KOR, ENG, MAT, (KOR+ENG+MAT) \"TOTAL\" FROM PERSON P, JOB J" + 
				" WHERE P.JNO = J.JNO ORDER BY TOTAL DESC) A" + 
				" WHERE JNAME = ?";
		
		String sql3 = "SELECT ROWNUM||'등' \"RANK\", NAME, JNAME, KOR, ENG, MAT, TOTAL " + 
				"     FROM (SELECT PNAME||'('||PNO||'번)' \"NAME\", JNAME, KOR, ENG, MAT, (KOR+ENG+MAT) \"TOTAL\"" + 
				" FROM PERSON P, JOB J" + 
				" WHERE P.JNO = J.JNO ORDER BY TOTAL DESC)";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		do {
			System.out.print("원하는 작업 번호를 입력하세요. (1.데이터베이스 삽입 / 2. 직업별 등수 / 3. 전체 등수 / 0. 종료) : ");
			temp = sc.nextInt();
			
			// 1번 작업
			if (temp == 1) {
				
				System.out.print("이름 : ");
				String pname = sc.next();
				
				System.out.print("직업 : ");
				String job = sc.next();
				
				// 직업 존재여부 확인
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, job);
					rs = pstmt.executeQuery();
					rs.next();
					int result = rs.getInt("cnt");
					if (result > 0) { // 직업이 존재할 경우
						rs.close();
						pstmt.close();
						pstmt = conn.prepareStatement(sql1);
						
						System.out.print("국어 점수 : ");
						int kor = sc.nextInt();
						if (kor < 0) { // 음수 입력 확인
							System.out.println("잘못된 점수입니다.");
							continue;
						}
						System.out.print("영어 점수 : ");
						int eng = sc.nextInt();
						if (kor < 0) { // 음수 입력 확인
							System.out.println("잘못된 점수입니다.");
							continue;
						}
						System.out.print("수학 점수 : ");
						int mat = sc.nextInt();
						if (kor < 0) { // 음수 입력 확인
							System.out.println("잘못된 점수입니다.");
							continue;
						}
						pstmt.setString(1, pname);
						pstmt.setString(2, job);
						pstmt.setInt(3, kor);
						pstmt.setInt(4, eng);
						pstmt.setInt(5, mat);

						System.out.println("삽입 성공");
						
					} else { // 직업이 존재하지 않을 경우
						System.out.println("존재하지 않는 직업입니다.");
						continue;
					}
					
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
				
				
			// 2번작업
			} else if (temp == 2) {
				System.out.print("원하는 직업을 입력하세요 : ");
				String job = sc.next();
				
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, job);
					rs = pstmt.executeQuery();
					rs.next();
					int result = rs.getInt("cnt");
					
					if (result > 0) {  // 직업이 존재할 경우
						rs.close();
						pstmt.close();
						pstmt = conn.prepareStatement(sql2);
						pstmt.setString(1, job);
						rs = pstmt.executeQuery();
						
						System.out.println("등수\t이름\t\t직업\t국어\t영어\t수학\t총점");
						while (rs.next()) {
							String rank = rs.getString("rank");
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
						continue;
					}
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
				
				
			// 3번작업
			} else if (temp == 3) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql3);
					
					System.out.println("등수\t이름\t\t직업\t국어\t영어\t수학\t총점");
					
					while (rs.next()) {
						String rank = rs.getString("rank");
						String name = rs.getString("name");
						String jname = rs.getString("jname");
						int kor = rs.getInt("kor");
						int eng = rs.getInt("eng");
						int mat = rs.getInt("mat");
						int total = rs.getInt("total");
						System.out.println(rank + "\t" + name + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + total);
					}

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
				
			} else if (temp == 0) {
				break;
			}
		} while (true);
		sc.close();
	}
}
