package com.lec.ex5_momchild;

public class ChildTestMain {

	public static void main(String[] args) {
		
		Child cd1 = new Child("첫째");
		Child cd2 = new Child("둘째");
		Child cd3 = new Child("셋째");
		
		cd1.takeMoney(500);
		cd2.takeMoney(1000);
		cd3.takeMoney(500);
		System.out.println(Child.momPouch.money); // 클래스 이름 또는 객체를 통해서 엑세스
	}
}
