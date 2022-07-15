package com.lec.ch10.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Student.class.isAssignableFrom(clazz);  // 검증할 객체의 클래스 타입 명시
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Student student = (Student) target;
		
		int id = student.getId();
		String name = student.getName();
		
//		if (name == null || name.trim().isEmpty()) {
//			errors.rejectValue("name", "no");
//		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "no");
		
		if (id <= 0) {
			errors.rejectValue("id", "no");
		}
	}

	
}
