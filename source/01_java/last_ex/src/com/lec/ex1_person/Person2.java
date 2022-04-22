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
		
		String sql2 = "SELECT ROWNUM||'��' \"RANK\", A.*" + 
				" FROM (SELECT PNAME||'('||PNO||'��)' \"NAME\", JNAME, KOR, ENG, MAT, (KOR+ENG+MAT) \"TOTAL\" FROM PERSON P, JOB J" + 
				" WHERE P.JNO = J.JNO ORDER BY TOTAL DESC) A" + 
				" WHERE JNAME = ?";
		
		String sql3 = "SELECT ROWNUM||'��' \"RANK\", NAME, JNAME, KOR, ENG, MAT, TOTAL " + 
				"     FROM (SELECT PNAME||'('||PNO||'��)' \"NAME\", JNAME, KOR, ENG, MAT, (KOR+ENG+MAT) \"TOTAL\"" + 
				" FROM PERSON P, JOB J" + 
				" WHERE P.JNO = J.JNO ORDER BY TOTAL DESC)";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		do {
			System.out.print("���ϴ� �۾� ��ȣ�� �Է��ϼ���. (1.�����ͺ��̽� ���� / 2. ������ ��� / 3. ��ü ��� / 0. ����) : ");
			temp = sc.nextInt();
			
			// 1�� �۾�
			if (temp == 1) {
				
				System.out.print("�̸� : ");
				String pname = sc.next();
				
				System.out.print("���� : ");
				String job = sc.next();
				
				// ���� ���翩�� Ȯ��
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, job);
					rs = pstmt.executeQuery();
					rs.next();
					int result = rs.getInt("cnt");
					if (result > 0) { // ������ ������ ���
						rs.close();
						pstmt.close();
						pstmt = conn.prepareStatement(sql1);
						
						System.out.print("���� ���� : ");
						int kor = sc.nextInt();
						if (kor < 0) { // ���� �Է� Ȯ��
							System.out.println("�߸��� �����Դϴ�.");
							continue;
						}
						System.out.print("���� ���� : ");
						int eng = sc.nextInt();
						if (kor < 0) { // ���� �Է� Ȯ��
							System.out.println("�߸��� �����Դϴ�.");
							continue;
						}
						System.out.print("���� ���� : ");
						int mat = sc.nextInt();
						if (kor < 0) { // ���� �Է� Ȯ��
							System.out.println("�߸��� �����Դϴ�.");
							continue;
						}
						pstmt.setString(1, pname);
						pstmt.setString(2, job);
						pstmt.setInt(3, kor);
						pstmt.setInt(4, eng);
						pstmt.setInt(5, mat);

						System.out.println("���� ����");
						
					} else { // ������ �������� ���� ���
						System.out.println("�������� �ʴ� �����Դϴ�.");
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
				
				
			// 2���۾�
			} else if (temp == 2) {
				System.out.print("���ϴ� ������ �Է��ϼ��� : ");
				String job = sc.next();
				
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, job);
					rs = pstmt.executeQuery();
					rs.next();
					int result = rs.getInt("cnt");
					
					if (result > 0) {  // ������ ������ ���
						rs.close();
						pstmt.close();
						pstmt = conn.prepareStatement(sql2);
						pstmt.setString(1, job);
						rs = pstmt.executeQuery();
						
						System.out.println("���\t�̸�\t\t����\t����\t����\t����\t����");
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
						System.out.println("�������� �ʴ� �����Դϴ�.");
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
				
				
			// 3���۾�
			} else if (temp == 3) {
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql3);
					
					System.out.println("���\t�̸�\t\t����\t����\t����\t����\t����");
					
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
