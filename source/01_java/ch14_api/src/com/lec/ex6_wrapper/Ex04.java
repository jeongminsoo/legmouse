package com.lec.ex6_wrapper;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Á¤¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä : ");
		String numStr = sc.nextLine();
		System.out.println("ÀÔ·ÂÇÑ Á¤¼ö´Â " + numStr);
		numStr = numStr.trim();
		numStr = numStr.replaceAll("[a-zA-Z°¡-ÆR]", "");
		int num = Integer.parseInt(numStr);
		System.out.println("º¯ÇüµÈ Á¤¼ö´Â " + num);
	}
}
