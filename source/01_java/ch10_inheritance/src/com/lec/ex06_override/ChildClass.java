package com.lec.ex06_override;

public class ChildClass extends ParentClass {

	public ChildClass() {
		System.out.println("�Ű����� ���� ChildClass ������");
	}
	public ChildClass(int i) {
		System.out.println("�Ű����� �ִ� ChildClass ������");
	}
	public void method3() {
		System.out.println("ChildClass�� method3() �Լ�");
	}
	@Override
	public void method1() {
		System.out.println("ChildClass�� method1() �Լ�");
	}
	@Override
	public boolean equals(Object obj) {
		return true;
	}
//	public void method1() {
//		System.out.println("ChildClass�� method1() �Լ�");
//	}
}
