package com.lec.ex1selectall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllOracle {
	
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null; // DB ���� ��ü ����
		Statement stmt = null;  // SQL ���� ��ü ����
		ResultSet rs = null;  // SELECT�� ��� �޴� ��ü ����
		String query = "SELECT * FROM EMP";
		try {
			Class.forName(driver);  // 1. ����̹� �ε�
			conn = DriverManager.getConnection(url, "scott", "tiger");  // 2. DB ����
			stmt = conn.createStatement(); // 3. SQL�� ���� ��ü ����
			rs = stmt.executeQuery(query);  // 4. SQL ���� + 5. SQL ���� ��� �ޱ�
			// 6. ����� �޾� ���ϴ� ���� ����
			System.out.println("���\t�̸�\t��å\t�����\t�Ի���\t�޿�\t��\t�μ���ȣ");
			while (rs.next()) {
				int empno 			= rs.getInt("empno");
				String ename 		= rs.getString("ename");
				String job 			= rs.getString("job");
				int mgr 			= rs.getInt("mgr");
//				 Date hiredate = rs.getDate("hiredate");
//				String hiredate = rs.getString("hiredate");
				Timestamp hiredate  = rs.getTimestamp("hiredate");
				int sal 			= rs.getInt("sal");
				int comm 			= rs.getInt("comm");
				int deptno			= rs.getInt("deptno");
				System.out.printf("%d\t%s\t%s\t%d\t%TF\t%d\t%d\t%d\n",
						empno, ename, job, mgr, hiredate, sal, comm, deptno);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { // 7. ���� ����
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
