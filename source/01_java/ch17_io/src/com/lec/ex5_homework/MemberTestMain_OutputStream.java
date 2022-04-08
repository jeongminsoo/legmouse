package com.lec.ex5_homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain_OutputStream {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Member> members = new ArrayList<Member>();
		
		String answer;
		String name;
		String tel;
		String birth;
		String address;
		
		int year;
		int month;
		int day;
		
		Date birthday;
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(now);
		
		do {
			System.out.print("ȸ�������� �����Ͻðڽ��ϱ�? (Y/N)");
			answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				break;
			} else if (answer.equalsIgnoreCase("y")) {
				System.out.print("�̸� : ");
				name = sc.next();
				
				System.out.print("��ȭ��ȣ : ");
				tel = sc.next();
				
				System.out.print("���� : ");
				birth = sc.next();
				
				StringTokenizer token = new StringTokenizer(birth, "-");
				if (token.countTokens() == 3) {
					year = Integer.parseInt(token.nextToken());
					month = Integer.parseInt(token.nextToken()) - 1;
					day = Integer.parseInt(token.nextToken());
					
					birthday = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
				} else {
					System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
					continue;
				}
				if (today.equals(birth.substring(birth.indexOf('-')+1))) {
					System.out.println("���������մϴ�.");
				}
				
				sc.nextLine();
				
				System.out.print("�ּ� : ");
				address = sc.nextLine();
	
				members.add(new Member(name, tel, birthday, address));
			}
		} while(true);
		
		sc.close();
		
		OutputStream os = null;
		
		try {
			os = new FileOutputStream("src/com/lec/ex5_homework/member.txt");
			
			for (Member m : members) {
				System.out.print(m);
				os.write(m.toString().getBytes());
			}
			String msg = "���� " + members.size() + "�� ����";
			System.out.println(msg);
			os.write(msg.getBytes());
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
			}
		}
	}
}
