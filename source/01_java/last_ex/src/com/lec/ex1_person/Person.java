package com.lec.ex1_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Person {

	public static void main(String[] args) {
		
		String driver 	= "oracle.jdbc.driver.OracleDriver";
		String url 		= "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Connection 			conn  = null;
		PreparedStatement 	pstmt = null;
		Statement 			stmt  = null;
		ResultSet 			rs 	  = null;
		
		Scanner sc = new Scanner(System.in);

		String fn, sql;
		
		try {
			Class.forName(driver);
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		do {
			System.out.print("1.�Է� || 2.������ ��ȸ || 3.��ü��ȸ || �׿�.����");
			fn = sc.next();
			switch(fn) {
			case "1" :
				sql = "INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME =?), ?, ?, ?)";
				
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					
					System.out.print("�̸� : ");
					pstmt.setString(1, sc.next());
					
					System.out.print("���� : ");
					pstmt.setString(2, sc.next());
					
					System.out.print("���� : ");
					pstmt.setInt(3, sc.nextInt());
					
					System.out.print("���� : ");
					pstmt.setInt(4, sc.nextInt());
					
					System.out.print("���� : ");
					pstmt.setInt(5, sc.nextInt(0));
					
					int result = pstmt.executeUpdate();
					
					System.out.println(result > 0 ? "���� ����" : "���� ����");
					
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
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
			case "2" :
				sql = "SELECT ROWNUM||'��' \"RANK\", A.*" + 
						" FROM (SELECT PNAME||'('||PNO||'��)' \"NAME\", JNAME, KOR, ENG, MAT, (KOR+ENG+MAT) \"TOTAL\" FROM PERSON P, JOB J" + 
						" WHERE P.JNO = J.JNO ORDER BY TOTAL DESC) A" + 
						" WHERE JNAME =?";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					
					
					System.out.print("���� : ");
					pstmt.setString(1, sc.next());
					
					rs = pstmt.executeQuery();
					
					
					if (rs.next()) {
						
						System.out.println("���\t�̸�\t\t����\t����\t����\t����\t����");
						
						do {
							String rank = rs.getString("rank");
							String name = rs.getString("name");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int total = rs.getInt("total");
							System.out.println(rank + "\t" + name + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + total);
							
						} while(rs.next());
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
					}
					
				}
				
				break;
			case "3" : 
				sql = "SELECT ROWNUM||'��' \"RANK\", NAME, JNAME, KOR, ENG, MAT, TOTAL " + 
						"     FROM (SELECT PNAME||'('||PNO||'��)' \"NAME\", JNAME, KOR, ENG, MAT, (KOR+ENG+MAT) \"TOTAL\"" + 
						" FROM PERSON P, JOB J" + 
						" WHERE P.JNO = J.JNO ORDER BY TOTAL DESC)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);

					if (rs.next()) {
						
						System.out.println("���\t�̸�\t\t����\t����\t����\t����\t����");
						
						do {
							String rank = rs.getString("rank");
							String name = rs.getString("name");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int total = rs.getInt("total");
							System.out.println(rank + "\t" + name + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + total);
							
						} while(rs.next());
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
				break;
				
			}
		} while (fn.equals("1")||fn.equals("2")||fn.equals("3"));
		sc.close();
		System.out.println("BYE");
	}
}
