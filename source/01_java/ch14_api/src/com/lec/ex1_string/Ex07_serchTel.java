package com.lec.ex1_string;

import java.util.Scanner;

public class Ex07_serchTel {

	public static void main(String[] args) {
		
		String[] tel = {"010-9999-9999", "02-8888-8888", "010-7777-8888"};
		
		Scanner sc = new Scanner(System.in);
		String serchTel;
		System.out.println("전화번호 뒷자리를 입력하세요 : ");
		
		serchTel = sc.next();
	
		boolean serchOk = false;
		
		for (int idx = 0; idx < tel.length; idx++) {
			if ( serchTel.equals(tel[idx].substring(tel[idx].lastIndexOf('-')+1))) {
				System.out.println("검색한 전화번호는 " + tel[idx] + " 입니다.");
				serchOk = true;
			}
		}
		if (!serchOk) {
			System.out.println("검색한 전화번호는 없습니다.");
		}
	}
}
