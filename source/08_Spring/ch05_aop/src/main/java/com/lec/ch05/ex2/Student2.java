package com.lec.ch05.ex2;

import lombok.Data;

@Data
public class Student2 {

	private String name;
	private int age;
	private int grade;
	private int classNum;
	
	public void getStudentInfo() {  // 호출될 핵심기능
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("학년 : " + grade);
		System.out.println("반 : " + classNum);
	}
}
