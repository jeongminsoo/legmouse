package com.lec.ex1_string;

public class Ex05_regex {

	public static void main(String[] args) {
		String str = "010-9999-9999 leekr44@naver.com (02)565-8888 ¹İ°©½À´Ï´Ù. Hello 920322-1320924 leekr44@clmns.co.kr";
		
//		System.out.println("replace => " + str.replace("0", "È«"));
		/*
		 \d (¼ıÀÚ¿Í ¸ÅÄ¡, [0-9]¿Í µ¿ÀÏ) / \D (¼ıÀÚ°¡ ¾Æ´Ñ °Í)
		 \s (whitespace : space, ÅÇ , ¿£ÅÍ)
		 \w (¿µ¹®ÀÚ³ª ¼ıÀÚ, [a-zA-Z0-9]¿Í µ¿ÀÏ) \W(¿µ¹®ÀÚ³ª ¼ıÀÚ°¡ ¾Æ´Ñ ¹®ÀÚ)
		 . (¹®ÀÚ ÇÏ³ª)
		 + (1¹ø ÀÌ»ó)
		 * (0¹ø ÀÌ»ó)
		 ? (0~1¹ø ¹İº¹)
		 {2,4} (2~4È¸ ¹İº¹)
		  ÀüÈ­¹øÈ£ : .?[0-9]{2,3}.[0-9]{3,4}-[0-9]{4}
		 
		 */
		System.out.println(str.replaceAll("[(]?[0-9]{2,3}\\D[0-9]{3,4}-[0-9]{4}", "**ÀüÈ­¹øÈ£ Áö¿ò**"));
		System.out.println(str.replaceAll("\\w+@\\w+(.\\w+){1,2}", "**ÀÌ¸ŞÀÏ Áö¿ò**"));
		System.out.println(str.replaceAll("[a-zA-Z]", "*"));
		System.out.println(str.replaceAll("[°¡-ÆR¤¡-¤¾]", ""));
		System.out.println(str.replaceAll("[0-9]{7}", "*******"));
	}
}
