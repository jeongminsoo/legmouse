package com.lec.ex13;

public class Gangsa extends Person {

	public static int gaNum = 0;
	private String subject;
	
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		++gaNum;
		setNo("lec" + gaNum);
	}
	@Override
	public void print() {
		super.print();
		System.out.println(" (°ú¸ñ)" + subject);
	}
}
