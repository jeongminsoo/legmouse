package com.lec.ex2_person_dtodao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class PersonDao {
	
	private String driver 	= "oracle.jdbc.driver.OracleDriver";
	private String url 		= "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	private static PersonDao INSTANCE;
	
	public static int SUCCESS = 1;
	public static int FAIL = 0;
	
	public static PersonDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonDao();
		}
		return INSTANCE;
	}

	private PersonDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// 1번 INSERT (매개변수 dto, return SUCCESS/FAIL)
	
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME =?), ?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
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
			}
		}
		
		return result;
	}
	
	// 2번 직업별조회 (매개변수 jname, return PersonDto ArrayList<PersonDto>)
	public ArrayList<PersonDto> selectJname(String jname) {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM||'등' \"RANK\", A.*" + 
				" FROM (SELECT PNAME||'('||PNO||'번)' \"NAME\", JNAME, KOR, ENG, MAT, (KOR+ENG+MAT) \"TOTAL\" FROM PERSON P, JOB J" + 
				" WHERE P.JNO = J.JNO ORDER BY TOTAL DESC) A" + 
				" WHERE JNAME =?";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String rank = rs.getString("rank");
				String pname = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int total = rs.getInt("total");
				dtos.add(new PersonDto(rank, pname, jname, kor, eng, mat, total));
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
			}
		}
		
		
		return dtos;
	}
	// 3번 전체조회 (return ArrayList<PersonDto>)
	public ArrayList<PersonDto> selectAll() {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM||'등' \"RANK\", NAME, JNAME, KOR, ENG, MAT, TOTAL" + 
				" FROM (SELECT PNAME||'('||PNO||'번)' \"NAME\", JNAME, KOR, ENG, MAT, (KOR+ENG+MAT) \"TOTAL\"" + 
				" FROM PERSON P, JOB J" + 
				" WHERE P.JNO = J.JNO ORDER BY TOTAL DESC)";
		try {
			
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				PersonDto dto = new PersonDto();
				dto.setRank(rs.getString("rank"));
				dto.setPname(rs.getString("name"));
				dto.setJname(rs.getString("jname"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTotal(rs.getInt("total"));
				dtos.add(dto);
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
		return dtos;
	}
	
	// 4번 직업리스트 조회 (return Vector<String>)
	public Vector<String> jnameList() {
		Vector<String> jnames = new Vector<String>();
		jnames.add("");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT JNAME FROM JOB";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
			jnames.add(rs.getString("jname"));
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
		
		return jnames;
	}
	
}
