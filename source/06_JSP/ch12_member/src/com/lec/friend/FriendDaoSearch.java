package com.lec.friend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FriendDaoSearch {

	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	public FriendDaoSearch() {
		
	}
	
	private static FriendDaoSearch instance;
	
	public static FriendDaoSearch getInstance() {
		if (instance == null) {
			instance = new FriendDaoSearch();
		}
		
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
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
	
	public int addFriend(String name, String phone) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO FRIEND (NO, NAME, PHONE) VALUES (FRIEND_SEQ.NEXTVAL, ?, ?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			result = pstmt.executeUpdate();
			
			System.out.println(result == SUCCESS?"친구 추가 성공":"친구 추가 실패");
			
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

	public ArrayList<FriendDto> printAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<FriendDto> friends = new ArrayList<FriendDto>();
		
		String sql = "SELECT * FROM FRIEND";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				friends.add(new FriendDto(no, name, phone));
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
		
		return friends;
	}
	
	public int checkName(String name) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM FRIEND WHERE NAME = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = FAIL;
			} else {
				result = SUCCESS;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}  finally {
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
	public int checkPhone(String phone) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM FRIEND WHERE PHONE = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = FAIL;
			} else {
				result = SUCCESS;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}  finally {
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
	public ArrayList<FriendDto> SearchPhone(String phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<FriendDto> friends = new ArrayList<FriendDto>();
		
		String sql = "SELECT * FROM FRIEND WHERE PHONE LIKE '%'||?||'%'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					int no = rs.getInt("no");
					String name = rs.getString("name");
					phone = rs.getString("phone");
					
					friends.add(new FriendDto(no, name, phone));
				} while (rs.next());
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
		
		return friends;
	}
	
	public ArrayList<FriendDto> SearchName(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<FriendDto> friends = new ArrayList<FriendDto>();
		
		String sql = "SELECT * FROM FRIEND WHERE NAME LIKE '%'||?||'%'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					int no = rs.getInt("no");
					name = rs.getString("name");
					String phone = rs.getString("phone");
					
					friends.add(new FriendDto(no, name, phone));
				} while (rs.next());
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
		
		return friends;
	}
	
	public ArrayList<FriendDto> SearchFull(String name, String phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<FriendDto> friends = new ArrayList<FriendDto>();
		
		String sql = "SELECT * FROM FRIEND WHERE NAME LIKE '%'||?||'%' AND PHONE LIKE '%'||?||'%'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					int no = rs.getInt("no");
					name = rs.getString("name");
					phone = rs.getString("phone");
					
					friends.add(new FriendDto(no, name, phone));
				} while (rs.next());
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
		
		return friends;
	}
}
