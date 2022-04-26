package com.lec.ex3_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class StudentDao {

	private String driver 	= "oracle.jdbc.driver.OracleDriver";
	private String url 		= "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	public static StudentDao INSTANCE;
	
	public static int SUCCESS = 1;
	public static int FAIL = 0;
	
	public static StudentDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new StudentDao();
		}
		return INSTANCE;
	}
	
	public StudentDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 학번검색
	public StudentDto selectSno(int sno) {
		StudentDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M WHERE S.MNO = M.MNO AND SNO = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = new StudentDto();
				dto.setSno(sno);
				dto.setsName(rs.getString("sname"));
				dto.setmName(rs.getString("mname"));
				dto.setScore(rs.getInt("score"));
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
	
	// 이름검색
	public ArrayList<StudentDto> selectSName(String sName) {
		ArrayList<StudentDto> students = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNO, MNAME, SCORE FROM STUDENT S, MAJOR M WHERE S.MNO = M.MNO AND SNAME = ?";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sName);
			rs = pstmt.executeQuery();
			

				while(rs.next()) {
					StudentDto dto = new StudentDto();
					dto.setSno(rs.getInt("sno"));
					dto.setsName(sName);
					dto.setmName(rs.getString("mname"));
					dto.setScore(rs.getInt("score"));
					students.add(dto);
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
		return students;
	}
	
	// 전공검색
	public ArrayList<StudentDto> selectMName(String mName) {
		ArrayList<StudentDto> students = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM||'등' \"RANK\", NAME, SMNAME, SCORE" + 
				" FROM (SELECT SNAME||'('||S.SNO||')' \"NAME\", MNAME||'('||S.MNO||')' \"SMNAME\", SCORE "
				+ "FROM STUDENT S, MAJOR M WHERE S.MNO = M.MNO AND MNAME = ? ORDER BY SCORE DESC)";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mName);
			rs = pstmt.executeQuery();
			
				while(rs.next()) {
					StudentDto dto = new StudentDto();
					dto.setRank(rs.getString("rank"));
					dto.setsName(rs.getString("name"));
					dto.setmName(rs.getString("smname"));
					dto.setScore(rs.getInt("score"));
					students.add(dto);
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
		return students;
	}
	// 학생입력
	public int insertStudent(StudentDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT VALUES (EXTRACT(YEAR FROM SYSDATE)||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), ?, (SELECT MNO FROM MAJOR WHERE MNAME = ?), ?, 0)";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getsName());
			pstmt.setString(2, dto.getmName());
			pstmt.setInt(3, dto.getScore());
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
	// 학생수정
	public int updateStudent(StudentDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET SCORE = ?, SNAME = ?, MNO = (SELECT MNO FROM MAJOR WHERE MNAME = ?) WHERE SNO = ?";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getScore());
			pstmt.setString(2, dto.getsName());
			pstmt.setString(3, dto.getmName());
			pstmt.setInt(4, dto.getSno());
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
	// 학생출력
	public ArrayList<StudentDto> selectAll() {
		ArrayList<StudentDto> students = new ArrayList<StudentDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM||'등' \"RANK\", NAME, SMNAME, SCORE" + 
				" FROM (SELECT SNAME||'('||S.SNO||')' \"NAME\", MNAME||'('||S.MNO||')' \"SMNAME\", SCORE "
				+ "FROM STUDENT S, MAJOR M WHERE S.MNO = M.MNO AND EXPEL != 1 ORDER BY SCORE DESC)";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String rank = rs.getString("rank");
				String sName = rs.getString("name");
				String mName = rs.getString("smname");
				int score = rs.getInt("score");
				students.add(new StudentDto(rank, sName, mName, score));
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
		return students;
	}
	
	public int updateExpel(int sno) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET EXPEL = 1 WHERE SNO = ?";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
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
	// 제적자출력
	public ArrayList<StudentDto> selectExpel() {
		ArrayList<StudentDto> expel = new ArrayList<StudentDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ROWNUM||'등' \"RANK\", NAME, SMNAME, SCORE" + 
				" FROM (SELECT SNAME||'('||S.SNO||')' \"NAME\", MNAME||'('||S.MNO||')' \"SMNAME\", SCORE "
				+ "FROM STUDENT S, MAJOR M WHERE S.MNO = M.MNO AND EXPEL = 1 ORDER BY SCORE DESC)";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			

				while(rs.next()) {
					String rank = rs.getString("rank");
					String sName = rs.getString("name");
					String mName = rs.getString("smname");
					int score = rs.getInt("score");
					StudentDto dto = new StudentDto(rank, sName, mName, score, 1);
					expel.add(dto);
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

		return expel;
	}
	
	public Vector<String> majorList() {
		Vector<String> major = new Vector<String>();
		major.add("");
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT MNAME FROM MAJOR";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				major.add(rs.getString("mname"));
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
		
		
		
		return major;
	}
}
