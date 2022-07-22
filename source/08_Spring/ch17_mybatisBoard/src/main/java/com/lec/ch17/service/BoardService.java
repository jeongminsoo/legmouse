package com.lec.ch17.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lec.ch17.model.Board;

public interface BoardService {

	public List<Board> boardList(String pageNum);
	
	public Board boardDetail(int bno);
	
	public int countBoard();
	
	public int boardWrite(Board board, HttpServletRequest request);
	
	public int boardReply(Board board, HttpServletRequest request);
	
	public int boardUpdate(Board board, HttpServletRequest request);
	
	public int hitup(int bno);
	
	public int beforestepA(Board board);
	
	public int boardDelete(int bno);
	
	public Board getBoard(int bno);
}
