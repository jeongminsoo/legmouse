package com.lec.ex09_super;

public class Baby extends Person {
	
	public Baby() {
		System.out.println("�Ű����� ���� Baby ������");
	}	
	public Baby(String name, String mind) {
		super(name, mind);
		System.out.println("�Ű����� �ִ� Baby ������");
	}
	@Override
	public void intro() {
		System.out.println("�������� �� �ư���");
		super.intro();
//		System.out.println("�������� �� �ư���");
	}
}
