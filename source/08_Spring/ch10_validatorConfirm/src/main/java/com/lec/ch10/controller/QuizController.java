package com.lec.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch10.dto.Quiz;
import com.lec.ch10.dto.QuizValidator;

@Controller
public class QuizController {

	@RequestMapping(value="quizInputForm", method = RequestMethod.GET)
	public String inputForm2(Model model) {
		model.addAttribute("cnt", 4);
		return "quiz/quizInput";
	}
	
	@RequestMapping(value="quizInput", method = RequestMethod.POST)
	public String input(Quiz quiz, Errors errors, Model model) {
		
		QuizValidator quizVal = new QuizValidator();
		
		quizVal.validate(quiz, errors);
		if (errors.hasErrors()) {
			if (errors.getFieldError("name") != null) {
				model.addAttribute("nameError", "이름은 필수 입력사항입니다");
			}
			if (errors.getFieldError("kor") != null) {
				model.addAttribute("korError", "국어 점수는 자연수입니다.");
			}
			if (errors.getFieldError("eng") != null) {
				model.addAttribute("engError", "영어 점수는 자연수입니다.");
			}
			if (errors.getFieldError("math") != null) {
				model.addAttribute("mathError", "수학 점수는 자연수입니다.");
			}
			return "quiz/quizInput";
		}
		
		int total = quiz.getKor() + quiz.getEng() + quiz.getMath();
		double avg = total / 3.0;
		
		model.addAttribute("total", total);
		model.addAttribute("avg", avg);
		model.addAttribute("cnt", 4);
		return "quiz/quizResult";
	}
}
