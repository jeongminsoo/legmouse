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

import com.lec.dto.BookDto;

public class BookDao {

	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static BookDao instance = new BookDao();
	
	public static BookDao getInstance() {
		return instance;
	}
	
	private BookDao() {
		
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
	// 책 등록
	public int addBook(BookDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO BOOK (BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)" + 
				" VALUES (BOOK_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBtitle());
			pstmt.setInt(2, dto.getBprice());
			pstmt.setString(3, dto.getBimage1());
			pstmt.setString(4, dto.getBimage2());
			pstmt.setString(5, dto.getBcontent());
			pstmt.setInt(6, dto.getBdiscount());
			
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
	
	// 책목록(전체)
	public ArrayList<BookDto> listBook() {
		ArrayList<BookDto> dtos = new ArrayList<BookDto>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM BOOK ORDER BY BRDATE DESC";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				int bprice = rs.getInt("bprice");
				String bimage1 = rs.getString("bimage1");
				String bimage2 = rs.getString("bimage2");
				String bcontent = rs.getString("bcontent");
				int bdiscount = rs.getInt("bdiscount");
				Date brdate = rs.getDate("brdate");
				
				dtos.add(new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate));
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
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// 책목록 (top-n)
	public ArrayList<BookDto> listBook(int start, int end) {
		ArrayList<BookDto> dtos = new ArrayList<BookDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				int bprice = rs.getInt("bprice");
				String bimage1 = rs.getString("bimage1");
				String bimage2 = rs.getString("bimage2");
				String bcontent = rs.getString("bcontent");
				int bdiscount = rs.getInt("bdiscount");
				Date brdate = rs.getDate("brdate");
				
				dtos.add(new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate));
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
	// 등록된 책 갯수
	public int countBook() {
		int cnt = 0;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) CNT FROM BOOK";
		
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
	
	// 책 상세보기(id로 dto가져오기)
	public BookDto getBook(int bid) {
		BookDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM BOOK WHERE BID = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String btitle = rs.getString("btitle");
				int bprice = rs.getInt("bprice");
				String bimage1 = rs.getString("bimage1");
				String bimage2 = rs.getString("bimage2");
				String bcontent = rs.getString("bcontent");
				int bdiscount = rs.getInt("bdiscount");
				Date brdate = rs.getDate("brdate");
				
				dto = new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate);
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
}
