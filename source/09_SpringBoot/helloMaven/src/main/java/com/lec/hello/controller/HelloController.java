package com.lec.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // 메세지 출력
public class HelloController {
	
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="/home")
	public String home(Model model) {
		log.info("첫 로그 메세지");
		model.addAttribute("greeting", "아니영, Spring Boot!");
		return "home";  // resources/templates/home.html
	}
}
