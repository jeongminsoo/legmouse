package com.lec.ex07_friend;

public class Friend {

	private String name;
	private String tel;
	
	public Friend() {
		System.out.println("매개변수 없는 생성자 함수");
	}
	public Friend(String name) {
		this();
		this.name = name;
		System.out.println("매개변수 하나짜리 생성자 함수");
	}
	public Friend(String name, String tel) {
		this(name);
		this.tel = tel;
		System.out.println("매개변수 두개짜리 생성자 함수");
	}
	public String infoString() {
		return "[이름]" + name + "[전화]:" + tel;
	}
}
