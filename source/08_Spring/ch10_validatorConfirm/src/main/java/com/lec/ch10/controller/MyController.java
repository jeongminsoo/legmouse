package com.lec.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch10.dto.Student;
import com.lec.ch10.dto.StudentValidator;

@Controller
public class MyController {

	@RequestMapping(value="inputForm", method = RequestMethod.GET)
	public String inputForm() {
		return "ex/inputForm";
	}
	
	@RequestMapping(value="input", method = RequestMethod.GET)
	public String input(Student student, Errors errors, Model model) {
		
		StudentValidator studentVal = new StudentValidator();
		
		studentVal.validate(student, errors);
		if (errors.hasErrors()) {
			if (errors.getFieldError("name") != null) {
				model.addAttribute("nameError", "name은 필수 입력 사항");
			}
			if (errors.getFieldError("id") != null) {
				model.addAttribute("idError", "id는 자연수입니다");
			}
			return "ex/inputForm";
		}
		
		return "ex/inputResult";
	}
}
