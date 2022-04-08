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
			System.out.print("회원가입을 진행하시겠습니까? (Y/N)");
			answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				break;
			} else if (answer.equalsIgnoreCase("y")) {
				System.out.print("이름 : ");
				name = sc.next();
				
				System.out.print("전화번호 : ");
				tel = sc.next();
				
				System.out.print("생일 : ");
				birth = sc.next();
				
				StringTokenizer token = new StringTokenizer(birth, "-");
				if (token.countTokens() == 3) {
					year = Integer.parseInt(token.nextToken());
					month = Integer.parseInt(token.nextToken()) - 1;
					day = Integer.parseInt(token.nextToken());
					
					birthday = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
				} else {
					System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
					continue;
				}
				if (today.equals(birth.substring(birth.indexOf('-')+1))) {
					System.out.println("생일축하합니다.");
				}
				
				sc.nextLine();
				
				System.out.print("주소 : ");
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
			String msg = "이하 " + members.size() + "명 가입";
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
