package com.lec.ch02.ex5_exam;

import lombok.Data;

@Data
public class ExamImpl2 implements Exam {

	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public String getName() {
		return name;
	}

	public int total() {
		return kor+eng+math;
	}

	public double avg() {
		return total() / 3.0;
	}

}
