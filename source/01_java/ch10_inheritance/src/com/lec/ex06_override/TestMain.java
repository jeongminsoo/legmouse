package com.lec.ex06_override;

public class TestMain {

	public static void main(String[] args) {
		
		ParentClass pObj1 = new ParentClass();
		ParentClass pObj2 = new ParentClass();
		System.out.println("-----------------------");
		if (pObj1.equals(pObj2)) {
			System.out.println("두 객체는 같다");
		} else {
			System.out.println("두 객체는 다르다");
		}
		System.out.println("-----------------------");
		ChildClass cObj1 = new ChildClass();
		System.out.println("-----------------------");
		if (cObj1.equals(pObj2)) {
			System.out.println("무조건 true");
		}
		System.out.println("-----------------------");
		pObj1.method1();
		pObj1.method2();
		System.out.println("-----------------------");
		cObj1.method1();
		cObj1.method2();
		cObj1.method3();
		System.out.println("-----------------------");
		ParentClass cObj2 = new ChildClass();
		
		cObj2.method1();
		cObj2.method2();
		if (cObj2 instanceof ChildClass) {
			((ChildClass)cObj2).method3();
		}
	}
}
