package com.lec.ex1_string;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Friend[] friends = { new Friend("ȫ�浿", "010-9999-9999", "05-22"),
							 new Friend("�ű浿", "010-8888-8888", "09-22"),
							 new Friend("���浿", "010-8888-9999", "08-22"),
							 new Friend("���浿", "010-7777-7777", "04-22"),
							 new Friend("��浿", "010-6666-7777", "03-22") };
		
		String serchTel;

		while (true) {
			System.out.print("�˻��� ��ȭ��ȣ ���ڸ�(��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ�) : ");
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
				System.out.println("�ش� ��ȭ��ȣ�� ģ���� �����ϴ�.");
			}
		}
		sc.close();
	}
}
