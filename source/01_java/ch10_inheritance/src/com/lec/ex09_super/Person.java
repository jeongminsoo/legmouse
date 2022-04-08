package com.lec.ex09_super;

public class Person {

	private String name;
	private String mind;
	
	public Person() {
		System.out.println("매개변수=파라미터=인자가 없는 Person 생성자");
	}
	public Person(String name, String mind) {
		this.name = name;
		this.mind = mind;
		System.out.println("매개변수 2개짜리 Person 생성자");
	}
	public void intro() {
		System.out.println(name + "은(는) " + mind);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMind() {
		return mind;
	}
	public void setMind(String mind) {
		this.mind = mind;
	}
	
}
