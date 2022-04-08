package com.lec.ex09_super;

public class Baby extends Person {
	
	public Baby() {
		System.out.println("매개변수 없는 Baby 생성자");
	}	
	public Baby(String name, String mind) {
		super(name, mind);
		System.out.println("매개변수 있는 Baby 생성자");
	}
	@Override
	public void intro() {
		System.out.println("응애응애 난 아가야");
		super.intro();
//		System.out.println("응애응애 난 아가야");
	}
}
