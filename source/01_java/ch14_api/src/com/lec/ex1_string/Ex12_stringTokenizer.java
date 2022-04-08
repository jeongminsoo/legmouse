package com.lec.ex1_string;

import java.util.StringTokenizer;

public class Ex12_stringTokenizer {

	public static void main(String[] args) {
	
		String str1 = "박보검 설현 수지 고소영 장동건";
		String str2 = "2022/03/28";
		StringTokenizer tokenizer1 = new StringTokenizer(str1);
		System.out.println(tokenizer1.nextToken());
		System.out.println(tokenizer1.nextToken());
		System.out.println(tokenizer1.nextToken());
		System.out.println("tokenizer1의 토큰 갯수 : " + tokenizer1.countTokens());
		
		while (tokenizer1.hasMoreTokens()) {
			System.out.println(tokenizer1.nextToken());
		}
		
		StringTokenizer tokenizer2 = new StringTokenizer(str2, "/");
		System.out.println("tokenizer2의 토큰 갯수 : " + tokenizer2.countTokens());
		while (tokenizer2.hasMoreTokens()) {
			System.out.println(tokenizer2.nextToken());
		}
	}
}
