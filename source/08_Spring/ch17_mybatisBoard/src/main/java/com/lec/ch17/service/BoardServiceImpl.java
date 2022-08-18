package com.lec.ch17.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch17.dao.BoardDao;
import com.lec.ch17.model.Board;
import com.lec.ch17.util.Paging;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> boardList(String pageNum) {
		Paging paging = new Paging(boardDao.countBoard(), pageNum);
		Board board = new Board();
		board.setStartRow(paging.getStartRow());
		board.setEndRow(paging.getEndRow());
		return boardDao.boardList(board);
	}

	@Override
	public Board boardDetail(int bno) {
		hitup(bno);
		return boardDao.boardDetail(bno);
	}

	@Override
	public int countBoard() {
		return boardDao.countBoard();
	}

	@Override
	public int boardWrite(Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		return boardDao.boardWrite(board);
	}

	@Override
	public int boardReply(Board board, HttpServletRequest request) {
		beforestepA(board);
		board.setBip(request.getRemoteAddr());
		return boardDao.boardReply(board);
	}

	@Override
	public int boardUpdate(Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		return boardDao.boardUpdate(board);
	}

	@Override
	public void hitup(int bno) {
		boardDao.hitup(bno);
	}

	@Override
	public int beforestepA(Board board) {
		return boardDao.beforestepA(board);
	}

	@Override
	public int boardDelete(int bno) {
		return boardDao.boardDelete(bno);
	}

	@Override
	public Board getBoard(int bno) {
		return boardDao.getBoard(bno);
	}

}
