package com.lec.ex1_string;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		
		int i = 10;
//		
		String str1 = "Java";
		String str2 = "Java";
		String str3 = new String("Java");
//		
//		if (str1 == str2) {
//			System.out.println("str1과 str2는 같은 주소값이 있음");
//		} else {
//			System.out.println("str1과 str2는 다른 주소값이 있음");
//		}
//		if (str1.equals(str2)) {
//			System.out.println("같은 문자열");
//		}
		System.out.println( str1 == str3 ? "str1과 3은 같은 주소" : "str1과 3은 다른주소");
		System.out.println( str1.equals(str3) ? "같은 스트링" : "다른 문자열");
	}
}
