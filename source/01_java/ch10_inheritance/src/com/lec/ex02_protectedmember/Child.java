package com.lec.ex02_protectedmember;

public class Child extends SuperIJ{

	private int total;
	
//	public Child() {
//		System.out.println("�Ű����� ���� Child ������ �Լ�");
//	}
	public Child(int i, int j) {
		setI(i);
		setJ(j);
		System.out.println("�Ű����� �ִ� Child ������ �Լ�");
	}
	public void sum() {
		total = getI() + getJ();
		System.out.printf("�� ��ü�� i = %d, j = %d\n", getI(), getJ());
		System.out.printf("�� ��ü�� total = %d.", total);
	}
}
