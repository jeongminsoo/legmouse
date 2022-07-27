package com.lec.ch19.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.dto.Member;
import com.lec.ch19.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(params = "method=joinForm", method = RequestMethod.GET)
	public String joinForm() {
		return "member/join";
	}
	
	@RequestMapping(params = "method=idConfirm", method = RequestMethod.GET)
	public String idConfirm(String mid, Model model) {
		model.addAttribute("result", memberService.idCheck(mid));
		return "member/idConfirm";
	}
	
	@RequestMapping(params = "method=join", method = RequestMethod.POST)
	public String join(@ModelAttribute("member") Member member, Model model) {
		model.addAttribute("joinResult", memberService.join(member));
		return "forward:member.do?method=loginForm";
	}
	
	@RequestMapping(params = "method=loginForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		return "member/login";
	}
	
	@RequestMapping(params = "method=login", method = RequestMethod.POST)
	public String login(String mid, String mpw, HttpSession session,Model model) {
		String result = memberService.loginCheck(mid, mpw, session);
		if (result.equals("로그인 성공")) {
			return "forward:main.do";
		} else {
			model.addAttribute("mid", mid);
			model.addAttribute("mpw", mpw);
			model.addAttribute("result", result);
			return "forward:member.do?method=loginForm";
		}
	}
	
	@RequestMapping(params = "method=logout", method = RequestMethod.GET)
	public String logout() {
		return "member/logout";
	}
	
	@RequestMapping(params = "method=modifyForm", method = RequestMethod.GET)
	public String modifyForm() {
		return "member/modify";
	}
	
	@RequestMapping(params = "method=modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute("member") Member member, HttpSession session, Model model) {
		int result = memberService.modify(session, member);
		if (result == 1) {
			model.addAttribute("modifyResult", result);
			return "forward:main.do";
		} else {
			model.addAttribute("modifyResult", result);
			return "forward:member.do?method=modifyForm";
		}
		
	}
}
