package com.lec.ex4_object;

public class Ex01_SawonTestMain {

	public static void main(String[] args) {
		
		Sawon s1 = new Sawon("a01", "홍길동", Dept.COMPUTER);
		Sawon s2 = new Sawon("a02", "신길동", Dept.HUMANRESOURCES, 2022, 3, 24);
		System.out.println(s1);
		System.out.println(s2);
	}
}
