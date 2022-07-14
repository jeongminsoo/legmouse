package com.lec.ch07.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch07.dto.Member;

@Controller
@RequestMapping("board")  // 공통요청경로
public class BoardController {
	@RequestMapping("write")
	public String write() {
		return "board/write";
	}
	
	@RequestMapping(value="content", method=RequestMethod.GET)
	public String content(Model model) {
		model.addAttribute("id", "aaa");
		model.addAttribute("pw", "111");
		Member member = new Member("bbb", "222");
		model.addAttribute("member", member);
		return "board/content";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		Member member = new Member("ccc", "111");
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(member);
		mav.addObject("list", list);
		mav.setViewName("board/list");
		return mav;
	}
	
	@RequestMapping("reply")
	public ModelAndView reply() {
		ModelAndView mav = new ModelAndView();
		Member member = new Member("ddd", "111");
		mav.addObject("member", member);
		mav.setViewName("board/reply");
		return mav;
	}
}
