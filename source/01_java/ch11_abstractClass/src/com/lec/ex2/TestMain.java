package com.lec.ex2;

public class TestMain {

	public static void main(String[] args) {
		
//		SuperClass s = new SuperClass() {
//			
//			@Override
//			public void method1() {
//				System.out.println("�͸�Ŭ���� ����");
//			}
//		};
//		s.method1();
		
		SuperClass obj = new ChildClass();
		obj.method1();
		obj.method2();
		
	}
}
