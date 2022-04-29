package exam_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDao {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	public static CustomerDao INSTANCE = new CustomerDao();
	
	public static int SUCCESS = 1;
	public static int FAIL = 0;
	
	
	public static CustomerDao getInstance() {
		return INSTANCE;
	}
	
	public CustomerDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 가입
	public int join(String phone, String name, int point) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER VALUES (?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			pstmt.setString(2, name);
			pstmt.setInt(3, point);
			
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
	
	// 폰조회
	public ArrayList<CustomerDto> searchphone(String phone) {
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE phone LIKE '%'||? ORDER BY POINT DESC";
		
		try {
			
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				phone = rs.getString("phone");
				String name = rs.getString("name");
				int point = rs.getInt("point");
				customers.add(new CustomerDto(phone, name, point));
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
	
	// 출력
	public ArrayList<CustomerDto> outputAll() {
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER ORDER BY POINT DESC";
		
		try {
			
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String phone = rs.getString("phone");
				String name = rs.getString("name");
				int point = rs.getInt("point");
				customers.add(new CustomerDto(phone, name, point));
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
	
}
