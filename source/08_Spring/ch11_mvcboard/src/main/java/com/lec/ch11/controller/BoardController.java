package com.lec.ch11.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch11.dto.BoardDto;
import com.lec.ch11.service.BContentService;
import com.lec.ch11.service.BDeleteService;
import com.lec.ch11.service.BListService;
import com.lec.ch11.service.BModifyReplyViewService;
import com.lec.ch11.service.BModifyService;
import com.lec.ch11.service.BReplyService;
import com.lec.ch11.service.BWriteService;
import com.lec.ch11.service.Service;

@Controller
@RequestMapping("mvcboard")
public class BoardController {

	private Service service;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String listGet(String pageNum, Model model) {
		model.addAttribute("pageNum", pageNum);
		service = new BListService();
		service.execute(model);
		return "mvcboard/list";
	}
	
	@RequestMapping(value="list", method = RequestMethod.POST)
	public String listPost(String pageNum, Model model) {
		model.addAttribute("pageNum", pageNum);
		service = new BListService();
		service.execute(model);
		return "mvcboard/list";
	}
	
	@RequestMapping(value="content", method = RequestMethod.GET)
	public String contentGet(String pageNum, String bid, Model model) {
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("bid", bid);
		service = new BContentService();
		service.execute(model);
		return "mvcboard/content";
	}
	
	@RequestMapping(value="content", method = RequestMethod.POST)
	public String contentPost(String pageNum, String bid, Model model) {
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("bid", bid);
		service = new BContentService();
		service.execute(model);
		return "mvcboard/content";
	}
	
	@RequestMapping(value="write", method = RequestMethod.GET)
	public String writeView() {
		return "mvcboard/write";
	}
	
	@RequestMapping(value="write", method = RequestMethod.POST)
	public String write(@ModelAttribute("dto") BoardDto xx, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		service = new BWriteService();
		service.execute(model);
		return "forward:list.do";
	}
	
	@RequestMapping(value="modify", method = RequestMethod.GET)
	public String modifyView(String bid, String pageNum, Model model) {
		model.addAttribute("bid", bid);
		model.addAttribute("pageNum", pageNum);
		service = new BModifyReplyViewService();
		service.execute(model);
		return "mvcboard/modify";
	}
	
	@RequestMapping(value="modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute("dto") BoardDto dto, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		service = new BModifyService();
		service.execute(model);
		return "forward:content.do";
	}
	
	@RequestMapping(value="reply", method = RequestMethod.GET)
	public String replyView(String bid, String pageNum, Model model) {
		model.addAttribute("bid", bid);
		model.addAttribute("pageNum", pageNum);
		service = new BModifyReplyViewService();
		service.execute(model);
		return "mvcboard/reply";
	}
	
	@RequestMapping(value="reply", method = RequestMethod.POST)
	public String reply(@ModelAttribute("dto") BoardDto dto, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		service = new BReplyService();
		service.execute(model);
		return "forward:list.do";
	}
	
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String delete(String bid, String pageNum, Model model) {
		model.addAttribute("bid", bid);
		model.addAttribute("pageNum", pageNum);
		service = new BDeleteService();
		service.execute(model);
		return "forward:list.do";
	}
}
