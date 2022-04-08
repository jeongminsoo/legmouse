package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주소를 입력하세요 : ");
		String address = sc.nextLine();
		System.out.println("입력한 주소는 : " + address);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
		System.out.println("입력한 이름은 : " + name);
	}
}
