package com.lec.ex1_string;

public class Ex09_StringMomoryWaste {

	public static void main(String[] args) {
		
		String str1 = "Hello";
		String str2 = "Hello";
		
		System.out.println( str1 == str2 ? "같은주소" : "다른주소");
		System.out.println("str1의 해쉬코드 : " + str1.hashCode());
		System.out.println("str2의 해쉬코드 : " + str2.hashCode());
		str1 = "Hello~";
		System.out.println("str1의 해쉬코드 : " + str1.hashCode());
		System.out.println( str1 == str2 ? "같은주소" : "다른주소");
	}
}
