package com.lec.ex5_person;

public class PersonInfo {

	private String name;
	private int age;
	private char gender;
	
	public PersonInfo() {
	}
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public void print() {
		System.out.printf("이름 = %s, 나이 = %d, 성별 = %c\n", name, age, gender);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
}
