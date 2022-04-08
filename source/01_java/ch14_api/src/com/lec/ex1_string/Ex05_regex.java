package com.lec.ex1_string;

public class Ex05_regex {

	public static void main(String[] args) {
		String str = "010-9999-9999 leekr44@naver.com (02)565-8888 �ݰ����ϴ�. Hello 920322-1320924 leekr44@clmns.co.kr";
		
//		System.out.println("replace => " + str.replace("0", "ȫ"));
		/*
		 \d (���ڿ� ��ġ, [0-9]�� ����) / \D (���ڰ� �ƴ� ��)
		 \s (whitespace : space, �� , ����)
		 \w (�����ڳ� ����, [a-zA-Z0-9]�� ����) \W(�����ڳ� ���ڰ� �ƴ� ����)
		 . (���� �ϳ�)
		 + (1�� �̻�)
		 * (0�� �̻�)
		 ? (0~1�� �ݺ�)
		 {2,4} (2~4ȸ �ݺ�)
		  ��ȭ��ȣ : .?[0-9]{2,3}.[0-9]{3,4}-[0-9]{4}
		 
		 */
		System.out.println(str.replaceAll("[(]?[0-9]{2,3}\\D[0-9]{3,4}-[0-9]{4}", "**��ȭ��ȣ ����**"));
		System.out.println(str.replaceAll("\\w+@\\w+(.\\w+){1,2}", "**�̸��� ����**"));
		System.out.println(str.replaceAll("[a-zA-Z]", "*"));
		System.out.println(str.replaceAll("[��-�R��-��]", ""));
		System.out.println(str.replaceAll("[0-9]{7}", "*******"));
	}
}
