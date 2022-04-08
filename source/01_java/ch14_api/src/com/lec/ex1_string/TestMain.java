package com.lec.ex1_string;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Friend[] friends = { new Friend("홍길동", "010-9999-9999", "05-22"),
							 new Friend("신길동", "010-8888-8888", "09-22"),
							 new Friend("마길동", "010-8888-9999", "08-22"),
							 new Friend("윤길동", "010-7777-7777", "04-22"),
							 new Friend("김길동", "010-6666-7777", "03-22") };
		
		String serchTel;

		while (true) {
			System.out.print("검색할 전화번호 뒷자리(단, 종료를 원하시면 x를 입력하시오) : ");
			serchTel = sc.next();
			boolean serchOk = false;
			
			for (int idx = 0; idx < friends.length; idx++) {
				String friendPhone = friends[idx].getPhone().substring(friends[idx].getPhone().lastIndexOf('-')+1);
				if ( serchTel.equals(friendPhone)) {
					System.out.println(friends[idx]);
					serchOk = true;
				}
			}
			if (serchTel.equalsIgnoreCase("x")) {
				break;
			}
			
			if (!serchOk) {
				System.out.println("해당 전화번호의 친구는 없습니다.");
			}
		}
		sc.close();
	}
}
