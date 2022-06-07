package com.lec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.lec.dto.BoardDto;

public class BoardDao {

	public static final int SCCESS = 1;
	public static final int FAIL = 0;

	private BoardDao() {

	}

	private static BoardDao instance = new BoardDao();

	public static BoardDao getInstance() {

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

	public int getBoardTotalCnt() {
		int totalCnt = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT COUNT(*) FROM BOARD";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			rs.next();
			totalCnt = rs.getInt(1);

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

		return totalCnt;
	}

	public ArrayList<BoardDto> listBoard() {

		ArrayList<BoardDto> dtos = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM BOARD ORDER BY NUM DESC";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String email = rs.getString("email");
				int readcount = rs.getInt("readcount");
				String pw = rs.getString("pw");
				int ref = rs.getInt("ref");
				int re_step = rs.getInt("re_step");
				int re_indent = rs.getInt("re_indent");
				String ip = rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate");

				dtos.add(new BoardDto(num, writer, subject, content, email, readcount, pw, ref, re_step, re_indent, ip,
						rdate));
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

	public ArrayList<BoardDto> listBoard(int startRow, int endRow) {

		ArrayList<BoardDto> dtos = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT  * FROM BOARD ORDER BY REF DESC, RE_STEP) A)" + 
				" WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String email = rs.getString("email");
				int readcount = rs.getInt("readcount");
				String pw = rs.getString("pw");
				int ref = rs.getInt("ref");
				int re_step = rs.getInt("re_step");
				int re_indent = rs.getInt("re_indent");
				String ip = rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate");

				dtos.add(new BoardDto(num, writer, subject, content, email, readcount, pw, ref, re_step, re_indent, ip,
						rdate));
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

	public int insertBoard(BoardDto dto) {
		int result = FAIL;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)"
				+ " VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), ?, ?, ?, ?, ?, (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, ?)";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPw());
			pstmt.setString(6, dto.getIp());
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

	public BoardDto getBoardOneLine(int num) {
		BoardDto dto = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM BOARD WHERE NUM = ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String email = rs.getString("email");
				int readcount = rs.getInt("readcount");
				String pw = rs.getString("pw");
				int ref = rs.getInt("ref");
				int re_step = rs.getInt("re_step");
				int re_indent = rs.getInt("re_indent");
				String ip = rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate");
				dto = new BoardDto(num, writer, subject, content, email, readcount, pw, ref, re_step, re_indent, ip,
						rdate);
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

	public void readcountUp(int num) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE BOARD SET READCOUNT = READCOUNT+1 WHERE NUM = ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
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

	public int modifyBoard(BoardDto dto) {
		int result = FAIL;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE BOARD SET SUBJECT  = ?,  CONTENT = ?, EMAIL = ?, PW = ?, IP = ? WHERE NUM = ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getPw());
			pstmt.setNString(5, dto.getIp());
			pstmt.setInt(6, dto.getNum());

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

	public int deleteBoard(int num, String pw) {
		int result = FAIL;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "DELETE FROM BOARD WHERE NUM = ? AND PW = ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, pw);

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

}
