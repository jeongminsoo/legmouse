package com.lec.ch17.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch17.model.Board;
import com.lec.ch17.service.BoardService;
import com.lec.ch17.util.Paging;

@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="list", method = {RequestMethod.GET, RequestMethod.POST})
	public String boardList(String pageNum, Model model) {
		Paging paging = new Paging(boardService.countBoard(), pageNum);
		
		model.addAttribute("boardList", boardService.boardList(pageNum));
		model.addAttribute("paging", paging);
		model.addAttribute("orderNum", paging.getStartRow());
		model.addAttribute("inverseNum", (paging.getTotCnt() - paging.getStartRow() + 1));
		return "board/list";
	}
	
	@RequestMapping(value="content", method = {RequestMethod.GET, RequestMethod.POST})
	public String boardDetail(String pageNum, int bno, Model model) {
		model.addAttribute("content", boardService.boardDetail(bno));
		return "board/content";
	}
	
	@RequestMapping(value="writeView", method = RequestMethod.GET)
	public String boardWriteView() {
		return "board/write";
	}
	
	@RequestMapping(value="write", method = RequestMethod.POST)
	public String boardWrite(Board board, HttpServletRequest request, Model model) {
		model.addAttribute("writeResult", boardService.boardWrite(board, request));
		return "forward:list.do";
	}
	
	@RequestMapping(value="modifyView", method = RequestMethod.GET)
	public String boardUpdateView(int bno, Model model) {
		model.addAttribute("board", boardService.getBoard(bno));
		return "board/modify";
	}
	
	@RequestMapping(value="modify", method = RequestMethod.POST)
	public String boardUpdate(Board board, HttpServletRequest request, Model model) {
		model.addAttribute("modifyResult", boardService.boardUpdate(board, request));
		return "forward:content.do";
	}
	
	@RequestMapping(value="replyView", method = RequestMethod.GET)
	public String boardReplyView(int bno, Model model) {
		model.addAttribute("board", boardService.getBoard(bno));
		return "board/reply";
	}
	
	@RequestMapping(value="reply", method = RequestMethod.POST)
	public String boardReply(Board board, HttpServletRequest request, Model model) {
		model.addAttribute("replyResult", boardService.boardReply(board, request));
		return "forward:list.do";
	}
	
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String boardDelete(int bno, Model model) {
		model.addAttribute("deleteResult", boardService.boardDelete(bno));
		return "forward:list.do";
	}
}
