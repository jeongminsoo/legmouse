package com.lec.ex1_string;

public class Ex10_StringBuffer {

	public static void main(String[] args) {
		
		String str = "abc";
		StringBuilder strBuilder = new StringBuilder("abc");
		System.out.println("�ؽ��ڵ� ��� : " +strBuilder.hashCode());
		System.out.println("strBuilder : " + strBuilder);
		strBuilder.append("def");
		System.out.println("strBuilder : " + strBuilder);
		strBuilder.insert(3,  "AAA");
		System.out.println("strBuilder : " + strBuilder);
		strBuilder.delete(3, 5);
		System.out.println("strBuilder : " + strBuilder);
		strBuilder.deleteCharAt(3);
		System.out.println("strBuilder : " + strBuilder);
		System.out.println("�ؽ��ڵ� ��� : " +strBuilder.hashCode());
	}
}
