package com.lec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.FileBoardDto;

public class FileBoardDao {
	
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;

	private static FileBoardDao instance = new FileBoardDao();
	
	public static FileBoardDao getInstance() {
		return instance;
	}
	private FileBoardDao() {
		
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
	// 글 목록
	public ArrayList<FileBoardDto> listFileBoard(int start, int end) {
		ArrayList<FileBoardDto> dtos = new ArrayList<FileBoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C WHERE F.CID = C.CID ORDER BY FREF DESC, FRE_STEP) A)" + 
				" WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int fnum = rs.getInt("fnum");
				String cid = rs.getString("cid");
				String fsubject = rs.getString("fsubject");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				String fpw = rs.getString("fpw");
				int fhit = rs.getInt("fhit");
				int fref = rs.getInt("fref");
				int fre_step = rs.getInt("fre_step");
				int fre_level = rs.getInt("fre_level");
				String fip = rs.getString("fip");
				Timestamp frdate = rs.getTimestamp("frdate");
				String cname = rs.getString("cname");
				String cemail = rs.getString("cemail");
				
				dtos.add(new FileBoardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, fhit, fref, fre_step, fre_level, fip, frdate, cname, cemail));
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
	// 원글 쓰기
	public int insertFileBoard(FileBoardDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRE_STEP, FRE_LEVEL, FIP)" + 
				" VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, FILEBOARD_SEQ.CURRVAL, 0, 0, ?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getFsubject());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfilename());
			pstmt.setString(5, dto.getFpw());
			pstmt.setString(6, dto.getFip());
			
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
	
	//답변글 쓰기
	public int replyFileBoard(FileBoardDto dto) {
		stepA(dto.getFref(), dto.getFre_step());
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRE_STEP, FRE_LEVEL, FIP)" + 
				" VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getFsubject());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfilename());
			pstmt.setString(5, dto.getFpw());
			pstmt.setInt(6, dto.getFref());
			pstmt.setInt(7, dto.getFre_step() + 1);
			pstmt.setInt(8, dto.getFre_level() + 1);
			pstmt.setNString(9, dto.getFip());
			
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
	
	// 답변글 step a
	public void stepA(int ref, int re_step) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE BOARD SET RE_STEP = RE_STEP + 1 WHERE REF = ? AND RE_STEP > ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, re_step);
			pstmt.executeUpdate();
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
	}
	
	// 글 수
	public int count() {
		int cnt = 0;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) CNT FROM FILEBOARD";
		
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
	
	// 글 상세보기
	public FileBoardDto detail(int fnum) {
		FileBoardDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C WHERE F.CID = C.CID AND FNUM = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String cid = rs.getString("cid");
				String fsubject = rs.getString("fsubject");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				String fpw = rs.getString("fpw");
				int fhit = rs.getInt("fhit");
				int fref = rs.getInt("fref");
				int fre_step = rs.getInt("fre_step");
				int fre_level = rs.getInt("fre_level");
				String fip = rs.getString("fip");
				Timestamp frdate = rs.getTimestamp("frdate");
				String cname = rs.getString("cname");
				String cemail = rs.getString("cemail");
				dto = new FileBoardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, fhit, fref, fre_step, fre_level, fip, frdate, cname, cemail);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dto;
	}
	
	// 글 수정
	public int update(FileBoardDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE FILEBOARD SET FSUBJECT = ?, FCONTENT = ?, FFILENAME = ?, FPW = ?, FIP = ? WHERE FNUM = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFsubject());
			pstmt.setString(2, dto.getFcontent());
			pstmt.setString(3, dto.getFfilename());
			pstmt.setString(4, dto.getFpw());
			pstmt.setString(5, dto.getFip());
			pstmt.setInt(6, dto.getFnum());
			
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
	
	// 글삭제
	public int deleteFileBoard(int fnum, String fpw) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM FILEBOARD WHERE FNUM = ? AND FPW = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.setString(2, fpw);
			
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
	
	// 조회수 올리기
	public void hitUp(int fnum) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE FILEBOARD SET FHIT = FHIT + 1 WHERE FNUM = ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.executeUpdate();
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
	}
}
