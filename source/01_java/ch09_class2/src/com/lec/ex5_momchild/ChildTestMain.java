package com.lec.ex5_momchild;

public class ChildTestMain {

	public static void main(String[] args) {
		
		Child cd1 = new Child("ù°");
		Child cd2 = new Child("��°");
		Child cd3 = new Child("��°");
		
		cd1.takeMoney(500);
		cd2.takeMoney(1000);
		cd3.takeMoney(500);
		System.out.println(Child.momPouch.money); // Ŭ���� �̸� �Ǵ� ��ü�� ���ؼ� ������
	}
}
