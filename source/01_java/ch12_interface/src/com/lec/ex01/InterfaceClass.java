package com.lec.ex01;

public class InterfaceClass implements InterfaceEx1, InterfaceEx2 {

	@Override
	public String method2() {
		System.out.println("���� ������ implement�� Ŭ�������� �ؿ�. method2");
		return null;
	}

	@Override
	public void method1() {
		System.out.println("���� ������ implements ���� Ŭ�������� �ؿ�. method1");
		
	}

}
