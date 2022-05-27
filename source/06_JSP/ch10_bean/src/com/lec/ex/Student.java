package com.lec.ex;

public class Student {

	private String stNum;
	private String name;
	private int grade;
	private String major;
	private int score;
	
	public Student() {
	}
	
	public Student(String stNum, String name, int grade, String major, int score) {
		this.stNum = stNum;
		this.name = name;
		this.grade = grade;
		this.major = major;
		this.score = score;
	}

	public String getStNum() {
		return stNum;
	}

	public void setStNum(String stNum) {
		this.stNum = stNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
