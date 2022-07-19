package com.lec.ch12.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lec.ch12.dto.BoardDto;
import com.lec.ch12.util.Constant;
public class BoardDao {
	
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	public JdbcTemplate template;
	
	private static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	private BoardDao() {
		template = Constant.template;
	}

	public ArrayList<BoardDto> boardList() {
		String sql = "SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP";
		
		ArrayList<BoardDto> dtos = (ArrayList<BoardDto>)template.query(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		return dtos;
	}
	
	// 글목록
	public ArrayList<BoardDto> boardList(final int startRow, final int endRow){
		
		ArrayList<BoardDto> dtos = null;
		
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* " + 
									" FROM (SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP) A)" + 
					" WHERE RN BETWEEN ? AND ?";
		
		dtos = (ArrayList<BoardDto>) template.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
			}
		}, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		
		
		return dtos;
	}
	// 글 갯수 
	public int getBoardTotCnt() {
		int totCnt = 0;

		String sql = "SELECT COUNT(*) FROM MVC_BOARD";
		
		totCnt = template.queryForObject(sql, Integer.class);
		
		return totCnt;
	}
	//원글쓰기
	public int write(final BoardDto bDto) {
		int result = FAIL;

		String sql = "INSERT INTO MVC_BOARD "
				+ "(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)" + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, " + 
				"            MVC_BOARD_SEQ.CURRVAL, 0,0, ?)";
		
		result = template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bDto.getBname());
				pstmt.setString(2, bDto.getBtitle());
				pstmt.setString(3, bDto.getBcontent());
				pstmt.setString(4, bDto.getBip());
			}
		});

		return result;
	}
	// hit수 올리기
	private void hitUp(final int bid) {
		String sql = "UPDATE MVC_BOARD SET BHIT = BHIT+1 WHERE BID=" + bid;
		
		template.update(sql);
		
	}
	// 글 상세보기(글 상세볼 때 조회수도 올림)
	public BoardDto contentView(final int bid) {
		hitUp(bid);
		
		BoardDto bDto = null;

		String sql = "SELECT * FROM MVC_BOARD WHERE BID="+bid;
		
		bDto = template.queryForObject(sql, BoardDto.class);

		return bDto;
	}
	// bid로 dto 가져오기 (답글쓰기 + 수정)
	public BoardDto modifyView_replyView(int bid) {
		BoardDto bDto = null;
		
		String sql = "SELECT * FROM MVC_BOARD WHERE BID=" + bid;
		
		bDto = template.queryForObject(sql, BoardDto.class);
		
		return bDto;
	}
	// 글 수정하기
	public int modify(final BoardDto bDto) {
		int result = FAIL;
		
		String sql = "UPDATE MVC_BOARD SET BNAME=?, " + 
				"                    BTITLE = ?, " + 
				"                    BCONTENT = ?, " + 
				"                    BIP = ?" + 
				"        WHERE BID=?";
		
		result = template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bDto.getBname());
				pstmt.setString(2, bDto.getBtitle());
				pstmt.setString(3, bDto.getBcontent());
				pstmt.setString(4, bDto.getBip());
				pstmt.setInt(5, bDto.getBid());
				
			}
		});
		
		return result;
	}
	// 글 삭제
	public int delete(int bid) {
		int result = FAIL;
		
		String sql = "DELETE FROM MVC_BOARD WHERE BID=" + bid;
		
		result = template.update(sql);
		
		return result;
	}
	// 답변글 쓰기 전 작업 : stepA
	private void preReplyStepA(int bgroup, int bstep) {
		String sql = "UPDATE MVC_BOARD SET BSTEP = BSTEP+1 WHERE BGROUP="+ bgroup + " AND BSTEP > " + bstep;
		
		template.update(sql);
	}
	// 답변글 쓰기
	public int reply(final BoardDto bDto) { // bname, btitle, bcontent, bip : 답변글에 대한 정보
		                             // bgroup, bstep, bindent : 원글에 대한 정보
		preReplyStepA(bDto.getBgroup(), bDto.getBstep());
		int result = FAIL;
		
		String sql = "INSERT INTO MVC_BOARD" + 
				" (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP) " + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?,?,?, ?, ?, ?, ?)";
		
		result = template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bDto.getBname());
				pstmt.setString(2, bDto.getBtitle());
				pstmt.setString(3, bDto.getBcontent());
				pstmt.setInt(4, bDto.getBgroup());
				pstmt.setInt(5, bDto.getBstep()+1);
				pstmt.setInt(6, bDto.getBindent()+1);
				pstmt.setString(7, bDto.getBip());
			}
		});
		return result;
	}
}