package com.lec.ex4_supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class CustomerDao {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

	public static CustomerDao INSTANCE;

	public static CustomerDao getIntance() {
		if (INSTANCE == null) {
			INSTANCE = new CustomerDao();
		}
		return INSTANCE;
	}

	public static int SUCCESS = 1;
	public static int FAIL = 0;

	public CustomerDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// 아이디 검색
	public CustomerDto selectCid(int cId) {
		CustomerDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO != 3) GAP "
				+ "FROM CUSTOMER C, CSM_LEVEL CL WHERE C.LEVELNO = CL.LEVELNO "
				+ "AND CAMOUNT BETWEEN LOW AND HIGH AND CID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new CustomerDto();
				dto.setcId(rs.getInt("cid"));
				dto.setcTel(rs.getString("ctel"));
				dto.setcName(rs.getString("cname"));
				dto.setcPoint(rs.getInt("cpoint"));
				dto.setcAmount(rs.getInt("camount"));
				dto.setLevelName(rs.getString("levelname"));
				dto.setGap(rs.getInt("gap"));
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

	// 전화번호 검색
	public ArrayList<CustomerDto> selectTel(String tel) {
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO != 3) GAP "
				+ "FROM CUSTOMER C, CSM_LEVEL CL WHERE C.LEVELNO = CL.LEVELNO "
				+ "AND CAMOUNT BETWEEN LOW AND HIGH AND CTEL LIKE '%'||? ORDER BY CAMOUNT DESC";
		try {

			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tel);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("cid");
				tel = rs.getString("ctel");
				String name = rs.getString("cname");
				int point = rs.getInt("cpoint");
				int amount = rs.getInt("camount");
				String levelName = rs.getString("levelname");
				int gap = rs.getInt("gap");
				customers.add(new CustomerDto(id, tel, name, point, amount, levelName, gap));
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
		return customers;
	}

	// 이름검색
	public ArrayList<CustomerDto> selectCName(String cName) {
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO != 3) GAP "
				+ "FROM CUSTOMER C, CSM_LEVEL CL WHERE C.LEVELNO = CL.LEVELNO "
				+ "AND CAMOUNT BETWEEN LOW AND HIGH AND CNAME = ? ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cName);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("cid");
				String tel = rs.getString("ctel");
				cName = rs.getString("cname");
				int point = rs.getInt("cpoint");
				int amount = rs.getInt("camount");
				String levelName = rs.getString("levelname");
				int gap = rs.getInt("gap");
				customers.add(new CustomerDto(id, tel, cName, point, amount, levelName, gap));
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
		return customers;
	}

	// 포인트로 구매
	public int updatePoint(int id, int price) {
		int result = FAIL;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CPOINT = CPOINT - ? WHERE CID = ?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, id);
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

	// 물품구매
	public int updateBuy(int id, int price) {
		int result = FAIL;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CAMOUNT = CAMOUNT + ?, CPOINT = CPOINT + (?*0.05), "
				+ "LEVELNO = (SELECT L.LEVELNO FROM CUSTOMER C, CSM_LEVEL L WHERE CAMOUNT+? BETWEEN LOW AND HIGH AND CID = ?) "
				+ "WHERE CID = ?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, price);
			pstmt.setInt(3, price);
			pstmt.setInt(4, id);
			pstmt.setInt(5, id);
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

	// 등급별 출력
	public ArrayList<CustomerDto> selectLevel(String levelName) {
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO != 3) GAP "
				+ "FROM CUSTOMER C, CSM_LEVEL CL WHERE C.LEVELNO = CL.LEVELNO "
				+ "AND CAMOUNT BETWEEN LOW AND HIGH AND LEVELNAME = ? ORDER BY CAMOUNT DESC";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelName);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("cid");
				String tel = rs.getString("ctel");
				String name = rs.getString("cname");
				int point = rs.getInt("cpoint");
				int amount = rs.getInt("camount");
				levelName = rs.getString("levelname");
				int gap = rs.getInt("gap");
				customers.add(new CustomerDto(id, tel, name, point, amount, levelName, gap));
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
		return customers;
	}

	// 전체출력
	public ArrayList<CustomerDto> selectAll() {
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		;

		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO != 3) GAP "
				+ "FROM CUSTOMER C, CSM_LEVEL CL WHERE C.LEVELNO = CL.LEVELNO "
				+ "AND CAMOUNT BETWEEN LOW AND HIGH ORDER BY CAMOUNT DESC";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("cid");
				String tel = rs.getString("ctel");
				String name = rs.getString("cname");
				int point = rs.getInt("cpoint");
				int amount = rs.getInt("camount");
				String levelName = rs.getString("levelname");
				int gap = rs.getInt("gap");
				customers.add(new CustomerDto(id, tel, name, point, amount, levelName, gap));
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
		return customers;
	}

	// 회원가입
	public int insertCustomer(String tel, String cName) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (CID, CTEL, CNAME) VALUES (CUSTOMER_SQ.NEXTVAL, ?, ?)";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tel);
			pstmt.setString(2, cName);
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

	// 전화번호 수정
	public int updateTel(String tel, int id) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CTEL = ? WHERE CID = ?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tel);
			pstmt.setInt(2, id);
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

	// 회원 탈퇴
	public int deleteCustomer(String tel) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM CUSTOMER WHERE CTEL = ?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tel);
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

	// 레벨 리스트
	public Vector<String> levelList() {
		Vector<String> level = new Vector<String>();
		level.add("");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT LEVELNAME FROM CSM_LEVEL";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				level.add(rs.getString("levelname"));
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

		return level;
	}
}
