package com.lec.ex02_protectedmember;

public class Child extends SuperIJ{

	private int total;
	
//	public Child() {
//		System.out.println("매개변수 없는 Child 생성자 함수");
//	}
	public Child(int i, int j) {
		setI(i);
		setJ(j);
		System.out.println("매개변수 있는 Child 생성자 함수");
	}
	public void sum() {
		total = getI() + getJ();
		System.out.printf("본 객체의 i = %d, j = %d\n", getI(), getJ());
		System.out.printf("본 객체의 total = %d.", total);
	}
}
