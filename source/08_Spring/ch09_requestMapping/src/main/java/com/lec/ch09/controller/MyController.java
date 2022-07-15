package com.lec.ch09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@RequestMapping(value="main", method = RequestMethod.GET)
	public String main() {
		return "main";
	}
	
	@RequestMapping(value="student", method = RequestMethod.GET)
	public String studentGet(@ModelAttribute("id") String id, Model model) {
		model.addAttribute("method", "GET");
		return "studentId";
	}
	
	@RequestMapping(value="student", method = RequestMethod.POST)
	public String studentPost(@ModelAttribute("id") String id, Model model) {
		model.addAttribute("method", "POST");
		return "studentId";
	}
	
	@RequestMapping(value="idConfirm", method = RequestMethod.GET)
	public String idConfirm(@ModelAttribute("id") String id, Model model) {
		if (id.equals("aaa")) {
			return "forward:studentOk.do";
		}
		return "redirect:studentNg.do";

	}
	
	@RequestMapping(value="studentOk", method = RequestMethod.GET)
	public String studentOk() {
		return "studentOk";
	}
	
	@RequestMapping(value="studentNg", method = RequestMethod.GET)
	public String studentNg() {
		return "studentNg";
	}
	
	@RequestMapping(value="fullpath", method = RequestMethod.GET)
	public String fullpath() {
		return "redirect:http://www.naver.com";
	}
}
