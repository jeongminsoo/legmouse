package com.lec.ex01;

public class InterfaceClass implements InterfaceEx1, InterfaceEx2 {

	@Override
	public String method2() {
		System.out.println("실제 구현은 implement한 클래스에서 해요. method2");
		return null;
	}

	@Override
	public void method1() {
		System.out.println("실제 구현은 implements 받은 클래스에서 해요. method1");
		
	}

}
