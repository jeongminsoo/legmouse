package com.lec.ex01_parentchild;

public class TestMain {

	public static void main(String[] args) {
		
		ChildClass cd1 = new ChildClass();
		ParentClass cd2 = new ChildClass();
		
		cd1.getMamaName();
		cd1.getPapaName();
		System.out.println(cd1.pStr);
		System.out.println((cd1.cStr));
		
		cd2.getMamaName();
		cd2.getPapaName();
		System.out.println(cd2.pStr);
//		System.out.println(cd2.cStr);
	}
}
