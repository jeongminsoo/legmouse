package com.lec.ex2_human.main;

import com.lec.ex2_human.*;
// 불필요한 package import 삭제 : ctrl + shift + o
public class TestMain {

	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		
		if (i == j) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		String name = "홍길동";
		String name2 = "홍길동";
		
		System.out.println(name.equals(name2));
		
		Woman she1 = new Woman();
		Woman she2 = new Woman();
		
		System.out.println(she1.equals(she2));
		
		Man he1 = new Man(31, 181, 80.0);
		Man he2 = new Man(30, 180, 79.0);
		Man he3; // 레퍼런스 변수만 선언
		
		he3 = he2;
		
		Man he4 = new Man(30, 180, 79.0);
		
		if ( he2.equals(he3)) {
			System.out.println("같다(같은주소)");
		}
		if ( !he2.equals(he4)) {
			System.out.println("다르다(다른주소)");
		}
		
		he1.setHeight(185);
		he1.setWeight(75.5);
		
		if (he1.calculateBMI() > 30) {
			System.out.println("건강하세요");
		} else {
			System.out.println("건강하겠네요");
		}
	}

}
