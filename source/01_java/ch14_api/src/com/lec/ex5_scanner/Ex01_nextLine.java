package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex01_nextLine {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.println("입력하신 나이는 : " + age);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
		System.out.println("입력하신 이름은 : " + name);
		System.out.print("주소를 입력하세요 : ");
		sc.nextLine();
		String address = sc.nextLine();
		System.out.println("입력하신 주소는 : " + address);
		sc.close();
	}
}
