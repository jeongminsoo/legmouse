package com.lec.ch08.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.ch08.vo.MemberDto;


@Controller
@RequestMapping("member")
public class MemberController {

	@ModelAttribute("cnt")
	public int cnt() {
		return 5;
	}
	
	@ModelAttribute("list")
	public ArrayList<String> list() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		return list;
	}
	
	@RequestMapping(value="join1")
	public String join1(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		
		return "member/result1";
	}
	
	@RequestMapping(value="join2")
	public String join2(@RequestParam("id") String memberId, @RequestParam("pw") String memberPw,
			@RequestParam("name") String memberName,
			@RequestParam("age") int memberAge,
			@RequestParam("email") String memberEmail,
			@RequestParam("address") String memberAddress, Model model) {
		
		model.addAttribute("id", memberId);
		model.addAttribute("pw", memberPw);
		model.addAttribute("name", memberName);
		model.addAttribute("age", memberAge);
		model.addAttribute("email", memberEmail);
		model.addAttribute("address", memberAddress);
		
		return "member/result1";
	}
	
	@RequestMapping(value="join3")
	public String join3(String id, String pw, String name, int age, String email, String address, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		
		return "member/result1";
	}
	
	@RequestMapping(value="join4")
	public String join4(MemberDto memberDto, Model model) {
		model.addAttribute("member", memberDto);
		return "member/result4";
	}
	
	@RequestMapping(value="join5")
	public String join5(MemberDto memberDto) {
		return "member/result5";
	}
	
	@RequestMapping(value="join6")
	public String join6(@ModelAttribute("member") MemberDto member) {
		return "member/result4";
	}
}
