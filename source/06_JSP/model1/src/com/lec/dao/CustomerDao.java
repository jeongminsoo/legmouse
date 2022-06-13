package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.CustomerDto;

public class CustomerDao {

	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public static final int CUSTOMER_EXISTENT = 0;
	public static final int CUSTOMER_NONEXISTENT = 1;
	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_FAIL = 0;
	
	private static CustomerDao instance = new CustomerDao();
	
	private CustomerDao() {
		
	}
	
	public static CustomerDao getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	// 회원가입
		public int joinCustomer(CustomerDto dto) {
			int result = FAIL;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			String sql = "INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH)" + 
					" VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getCid());
				pstmt.setString(2, dto.getCpw());
				pstmt.setString(3, dto.getCname());
				pstmt.setString(4, dto.getCemail());
				pstmt.setString(5, dto.getCtel());
				pstmt.setString(6, dto.getCaddress());
				pstmt.setString(7, dto.getCgender());
				pstmt.setDate(8, dto.getCbirth());
				
				result = pstmt.executeUpdate();
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
					System.out.println(e.getMessage());
				}
			}
			return result;
		}
		// 로그인 체크
		public int loginChk(String id, String pw) {
			int result = LOGIN_FAIL;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "SELECT * FROM CUSTOMER WHERE CID = ? AND CPW = ?";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setNString(2, pw);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					result = LOGIN_SUCCESS;
				} else {
					result = LOGIN_FAIL;
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
			
			return result;
		}
		// Customer 불러오기
		public CustomerDto getCustomer(String id) {
			CustomerDto dto = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "SELECT * FROM CUSTOMER WHERE CID = ?";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					String pw = rs.getString("cpw");
					String name = rs.getString("cname");
					String tel = rs.getString("ctel");
					String email = rs.getString("cemail");
					String address = rs.getString("caddress");
					String gender = rs.getString("cgender");
					Date birth = rs.getDate("cbirth");
					Date rdate = rs.getDate("crdate");
					
					dto = new CustomerDto(id, pw, name, tel, email, address, gender, birth, rdate);
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

			return dto;
		}
		// 정보수정
		public int updateCustomer(CustomerDto dto) {
			int result = FAIL;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			String sql = "UPDATE CUSTOMER SET CPW = ?, CNAME = ?, CTEL = ?, CEMAIL = ?, CADDRESS = ?," + 
					" CGENDER = ?, CBIRTH = ? WHERE CID = ?";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getCpw());
				pstmt.setString(2, dto.getCname());
				pstmt.setString(3, dto.getCtel());
				pstmt.setString(4, dto.getCemail());
				pstmt.setString(5, dto.getCaddress());
				pstmt.setNString(6, dto.getCgender());
				pstmt.setDate(7, dto.getCbirth());
				pstmt.setString(8, dto.getCid());
				
				result = pstmt.executeUpdate();
				
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
					System.out.println(e.getMessage());
				}
			}
			
			return result;
		}
		// 아이디 중복확인
		public int idCheck(String id) {
			int result = CUSTOMER_EXISTENT;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "SELECT * FROM CUSTOMER WHERE CID = ?";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					result = CUSTOMER_EXISTENT;
				} else {
					result = CUSTOMER_NONEXISTENT;
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
			return result;
		}
		// 회원리스트
		public ArrayList<CustomerDto> listCustomer(int start, int end) {
			ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "SELECT * FROM (SELECT ROWNUM RN, CID, CPW, CNAME, CEMAIL, CADDRESS FROM (SELECT * FROM CUSTOMER ORDER BY CID))" + 
					" WHERE RN BETWEEN ? AND ?";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					String id = rs.getString("cid");
					String pw = rs.getString("cpw");
					String name = rs.getString("cname");
					String email = rs.getString("cemail");
					String address = rs.getString("caddress");
					
					dtos.add(new CustomerDto(id, pw, name, email, address));
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
		
		// 회원수
		public int countCustomer() {
			int cnt = 0;
			
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			String sql = "SELECT COUNT(*) CNT FROM CUSTOMER";
			
			try {
				conn = getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				rs.next();
				cnt = rs.getInt("cnt");
				
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
					System.out.println(e.getMessage());
				}
			}
			return cnt;
		}
}
