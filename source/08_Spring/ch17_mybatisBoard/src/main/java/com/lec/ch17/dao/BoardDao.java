package com.lec.ch17.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch17.model.Board;

@Mapper
public interface BoardDao {

	public List<Board> boardList(Board board);
	
	public Board boardDetail(int bno);
	
	public int countBoard();
	
	public int boardWrite(Board board);
	
	public int boardReply(Board board);
	
	public int boardUpdate(Board board);
	
	public int hitup(int bno);
	
	public int beforestepA(Board board);
	
	public int boardDelete(int bno);
	
	public Board getBoard(int bno);
}
