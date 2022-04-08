package com.lec.ex13;

public class Student extends Person {
	
	public static int stuNum = 0;
	private String ban;
	
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		++stuNum;
		setNo("st10" + stuNum);
	}
	@Override
	public void print() {
		super.print();
		System.out.println(" (¹Ý)" + ban);
	}

}
