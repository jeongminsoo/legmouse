package com.lec.ex2selectwhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/* 1. 사용자에게 부서명을 입력 받음
 *	1-1. 부서가 존재하는 경우 : 부서정보와 사원정보(사번, 이름, 급여, 급여등급)
 *	1-2. 부서가 존재하지 않는 경우 : 없다고 출력
 */
public class Ex3_SelectDnameEmp {

	public static void main(String[] args) {
		String 		driver 	= "oracle.jdbc.driver.OracleDriver";
		String 		url 	= "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection 	conn 	= null;
		Statement 	stmt 	= null;
		ResultSet 	rs 		= null;
		Scanner 	sc 		= new Scanner(System.in);
		System.out.print("원하는 부서명은 ?");
		String dname = sc.next();
		
		String sql1 = "SELECT * FROM DEPT WHERE DNAME = UPPER('" + dname + "')";
		String sql2 = "SELECT EMPNO, ENAME, SAL, GRADE "
						+ "FROM EMP E, SALGRADE, DEPT D "
						+ "WHERE SAL BETWEEN LOSAL AND HISAL "
						+ "AND E.DEPTNO = D.DEPTNO AND DNAME = UPPER('" + dname + "')";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			
			if (rs.next()) {
				System.out.println("부서번호 : " + rs.getInt("deptno"));
				System.out.println("부서이름 : " + rs.getString("dname"));
				System.out.println("부서위치 : " + rs.getString("loc"));
				rs.close();
				rs = stmt.executeQuery(sql2);
				
				if (rs.next()) {
					System.out.println("사번\t이름\t급여\t등급");
					do {
						int		empno	= rs.getInt("empno");
						String	ename	= rs.getString("ename");
						int		sal		= rs.getInt("sal");
						int		grade	= rs.getInt("grade");
						System.out.println(empno + "\t" + ename + "\t" + sal + "\t" + grade);
					} while (rs.next());
				} else {
					System.out.println(dname + "부서의 사원이 없습니다.");
				}
			} else {
				System.out.println(dname + "부서는 없습니다.");
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
