package com.custom.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.custom.dto.MemberDto;
import com.custom.dto.MoneyDto;

public class MoneyDao {

	private static MoneyDao instance = new MoneyDao();
	
	public static MoneyDao getInstance() {
		return instance;
	}
	
	private MoneyDao() {
		
	}
	
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "scott", "tiger");
		return con;
	}
	
	// 회원 매출
	public ArrayList<MoneyDto> totalMember() {
		ArrayList<MoneyDto> dtos = new ArrayList<MoneyDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT A.*, CUSTNAME, GNAME" + 
						" FROM (SELECT CUSTNO, SUM(PRICE) TOTAL FROM MONEY GROUP BY CUSTNO ORDER BY TOTAL DESC) A, MEMBER M, MEMBER_LEVEL ML" + 
						" WHERE A.CUSTNO = M.CUSTNO AND M.GRADE = ML.GRADE";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int saleno = 0;
				int custno = rs.getInt("custno");
				int cost = 0;
				int amount = 0;
				int price = 0;
				String pcode = null;
				Date sdate = null;
				String custname = rs.getString("custname");
				String gname = rs.getString("gname");
				int total = rs.getInt("total");
				
				dtos.add(new MoneyDto(saleno, custno, cost, amount, price, pcode, sdate, custname, gname, total));
			}
			
		} catch (Exception e) {
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
	
	// 제품 매출
	public ArrayList<MoneyDto> totalPcode() {
		ArrayList<MoneyDto> dtos = new ArrayList<MoneyDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT PCODE, SUM(PRICE) TOTAL FROM MONEY GROUP BY PCODE ORDER BY TOTAL DESC";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int saleno = 0;
				int custno = 0;
				int cost = 0;
				int amount = 0;
				int price = 0;
				String pcode = rs.getString("pcode");
				Date sdate = null;
				String custname = null;
				String gname = null;
				int total = rs.getInt("total");
				
				dtos.add(new MoneyDto(saleno, custno, cost, amount, price, pcode, sdate, custname, gname, total));
			}
			
		} catch (Exception e) {
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
