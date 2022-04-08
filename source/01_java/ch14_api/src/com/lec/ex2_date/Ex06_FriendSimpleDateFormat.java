package com.lec.ex2_date;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.lec.ex1_string.Friend;

public class Ex06_FriendSimpleDateFormat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Date now = new Date();
		Date now1 = new Date(2022, 5, 22);
		Date now2 = new Date(2022, 9, 22);
		Date now3 = new Date(2022, 8, 22);
		Date now4 = new Date(2022, 4, 22);
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		
		String serchDate;
		
		Friend[] friends = { new Friend("ȫ�浿", "010-9999-9999", (String)sdf.format(now1)),
				 new Friend("�ű浿", "010-8888-8888", (String)sdf.format(now2)),
				 new Friend("���浿", "010-8888-9999", (String)sdf.format(now3)),
				 new Friend("���浿", "010-7777-7777", (String)sdf.format(now4)),
				 new Friend("��浿", "010-6666-7777", (String)sdf.format(now)) };
		
		while (true) {
			System.out.print("�˻��� ������ �Է��Ͻÿ�(��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ�) : ");
			serchDate = sc.next();
			boolean serchOk = false;
			
			for (int idx = 0; idx < friends.length; idx++) {
				String friendPhone = friends[idx].getBirthday();
				if ( serchDate.equals(friendPhone)) {
					System.out.println(friends[idx]);
					serchOk = true;
				}
			}
			if (serchDate.equalsIgnoreCase("x")) {
				break;
			}
			
			if (!serchOk) {
				System.out.println("�ش� ������ ģ���� �����ϴ�.");
			}
		}
		sc.close();
	}
}
