package com.lec.ex1_string;

public class Ex05_regex {

	public static void main(String[] args) {
		String str = "010-9999-9999 leekr44@naver.com (02)565-8888 반갑습니다. Hello 920322-1320924 leekr44@clmns.co.kr";
		
//		System.out.println("replace => " + str.replace("0", "홍"));
		/*
		 \d (숫자와 매치, [0-9]와 동일) / \D (숫자가 아닌 것)
		 \s (whitespace : space, 탭 , 엔터)
		 \w (영문자나 숫자, [a-zA-Z0-9]와 동일) \W(영문자나 숫자가 아닌 문자)
		 . (문자 하나)
		 + (1번 이상)
		 * (0번 이상)
		 ? (0~1번 반복)
		 {2,4} (2~4회 반복)
		  전화번호 : .?[0-9]{2,3}.[0-9]{3,4}-[0-9]{4}
		 
		 */
		System.out.println(str.replaceAll("[(]?[0-9]{2,3}\\D[0-9]{3,4}-[0-9]{4}", "**전화번호 지움**"));
		System.out.println(str.replaceAll("\\w+@\\w+(.\\w+){1,2}", "**이메일 지움**"));
		System.out.println(str.replaceAll("[a-zA-Z]", "*"));
		System.out.println(str.replaceAll("[가-힣ㄱ-ㅎ]", ""));
		System.out.println(str.replaceAll("[0-9]{7}", "*******"));
	}
}
