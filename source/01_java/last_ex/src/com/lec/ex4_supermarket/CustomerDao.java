package com.lec.ex4_supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao {

	private String driver 	= "oracle.jdbc.driver.OracleDriver";
	private String url 		= "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
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
	public CustomerDto selectCid(String cId) {
		CustomerDto customer = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, HIGH-CAMOUNT+1 GAP " + 
				"FROM CUSTOMER C, CSM_LEVEL CL WHERE C.LEVELNO = CL.LEVELNO " + 
				"AND CAMOUNT BETWEEN LOW AND HIGH AND CID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				customer = new CustomerDto();
				customer.setcId(cId);
				customer.setcTel(rs.getString("ctel"));
				customer.setcName(rs.getString("cname"));
				customer.setcPoint(rs.getInt("cpoint"));
				customer.setcAmount(rs.getInt("camount"));
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return customer;
	}
	
}
