package com.lec.ch10.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class QuizValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Quiz.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Quiz person = (Quiz) target;
		
		String name = person.getName();
		int kor = person.getKor();
		int eng = person.getEng();
		int math = person.getMath();
		
		if (name == null || name.trim().isEmpty()) {
			errors.rejectValue("name", "no");
		}
		
		if (kor <= 0) {
			errors.rejectValue("kor", "no");
		}
		if (eng <= 0) {
			errors.rejectValue("eng", "no");
		}
		if (math <= 0) {
			errors.rejectValue("math", "no");
		}
	}

}
