package com.lec.ch02.ex5_exam;

import lombok.Data;

@Data
public class ExamImpl implements Exam {

	private String name;
	private int kor;
	private int eng;
	private int math;
	private int computer;
	
	public int total() {
		
		int total = kor + eng + math + computer;
		
		return total;
	}

	public double avg() {
		
		double avg = total()/4.0;
		
		return avg;
	}
}
