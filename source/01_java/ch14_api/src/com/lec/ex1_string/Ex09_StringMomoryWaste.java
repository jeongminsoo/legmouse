package com.lec.ex1_string;

public class Ex09_StringMomoryWaste {

	public static void main(String[] args) {
		
		String str1 = "Hello";
		String str2 = "Hello";
		
		System.out.println( str1 == str2 ? "�����ּ�" : "�ٸ��ּ�");
		System.out.println("str1�� �ؽ��ڵ� : " + str1.hashCode());
		System.out.println("str2�� �ؽ��ڵ� : " + str2.hashCode());
		str1 = "Hello~";
		System.out.println("str1�� �ؽ��ڵ� : " + str1.hashCode());
		System.out.println( str1 == str2 ? "�����ּ�" : "�ٸ��ּ�");
	}
}
