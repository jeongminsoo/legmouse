package com.lec.ex06_override;

public class ParentClass {

	public ParentClass() {
		System.out.println("매개변수 없는 ParentClass 생성자");
	}
	public ParentClass(int i) {
		System.out.println("매개변수 있는 ParentClass 생성자");
	}
	public void method1() {
		System.out.println("ParentClass의 method1() 함수");
	}
	public void method2() {
		System.out.println("ParentClass의 method2() 함수");
	}
}
