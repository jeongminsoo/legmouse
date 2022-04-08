package com.lec.ex3_set;

public class Student {

	private int grade;
	private String name;
	
	public Student(int grade, String name) {
		this.grade = grade;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return grade + "�г� " + name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Student) {
//			Student tempObj = (Student)obj;
//			boolean checkGrd = grade == tempObj.grade;
//			boolean checkName = name == tempObj.name;
//			return checkGrd && checkName;
			return toString().equals(obj.toString());
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
