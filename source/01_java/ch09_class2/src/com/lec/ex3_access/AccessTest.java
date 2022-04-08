package com.lec.ex3_access;

public class AccessTest {

	private int privateMember; // 같은 클래스내에서만 사용
	int defaultMember; // 디폴트 : 같은 패키지에서만 사용
	protected int protectedMember; // 같은패키지나 상속받은 하위클래스에서만 사용
	public int publicMember;
	private void privateMethod() {
		System.out.println("private 메소드");
	}
	
	void defaultMethod() {
		System.out.println("디폴트 메소드");
	}
	
	protected void protectedMethod() {
		System.out.println("protected 메소드");
	}
	
	public void publicMethod() {
		System.out.println("public 메소드");
	}
}
