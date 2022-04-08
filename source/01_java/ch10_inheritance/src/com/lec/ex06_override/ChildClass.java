package com.lec.ex06_override;

public class ChildClass extends ParentClass {

	public ChildClass() {
		System.out.println("매개변수 없는 ChildClass 생성자");
	}
	public ChildClass(int i) {
		System.out.println("매개변수 있는 ChildClass 생성자");
	}
	public void method3() {
		System.out.println("ChildClass의 method3() 함수");
	}
	@Override
	public void method1() {
		System.out.println("ChildClass의 method1() 함수");
	}
	@Override
	public boolean equals(Object obj) {
		return true;
	}
//	public void method1() {
//		System.out.println("ChildClass의 method1() 함수");
//	}
}
