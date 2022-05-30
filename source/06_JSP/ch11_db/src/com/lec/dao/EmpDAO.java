package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.dto.EmpDTO;

public class EmpDAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static EmpDAO instance = null;
	
	public static EmpDAO getInstance() {
		if (instance == null) {
			instance = new EmpDAO();
		}
		return instance;
	}
	
	private EmpDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<EmpDTO> serchName(String str) {
		ArrayList<EmpDTO> dtos = new ArrayList<EmpDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM EMP WHERE ENAME LIKE '%'||UPPER(?)||'%'";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
				dtos.add(new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno));
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
		return dtos;
	}
	
	public ArrayList<EmpDTO> searchDeptno(int deptno) {
ArrayList<EmpDTO> dtos = new ArrayList<EmpDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM EMP WHERE DEPTNO = ?";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				
				dtos.add(new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno));
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
		return dtos;
	}
	
}
