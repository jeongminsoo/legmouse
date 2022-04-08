package example;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {

	public static void main(String[] args) {
		
		ArrayList<Member> members = new ArrayList<Member>();
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		String tel;
		String address;
		String answer;
		
		do {
			System.out.print("회원가입을 진행하시겠습니까? (Y/N)");
			answer = sc.next();
			
			if (answer.equalsIgnoreCase("n")) {
				break;
			} else if (answer.equalsIgnoreCase("y")) {
				System.out.print("이름 : ");
				name = sc.next();
				
				// 이름 중복 체크 방법 1
				boolean nameCheck = false;
				for (int i = 0; i < members.size(); i++)
					if (members.get(i).getName().equals(name)) {
						nameCheck = true;
						break;
					}
				if (nameCheck) {
					System.out.println("중복된 이름입니다. 다시 입력하세요.");
					continue;
				}
				// 이름 중복 체크 방법 2
//				Iterator<Member> iter0 = members.iterator();
//				boolean ok = false;
//				while (iter0.hasNext()) {
//					if(iter0.next().getName().equals(name)) {
//						ok = true;
//						break;
//					}
//				}
//				if (ok) {
//					System.out.println("중복된 이름입니다. 다시입력하세요.");
//					continue;
//				}	
				System.out.print("전화번호 : ");
				tel = sc.next();
				
				boolean telCheck = false;
				for (int i = 0; i < members.size(); i++)
					if (members.get(i).getTel().equals(tel)) {
						telCheck = true;
						break;
					}
				if (telCheck) {
					System.out.println("중복된 번호입니다. 다시 입력하세요.");
					continue;
				}
				
				sc.nextLine();
				System.out.print("주소 : ");
				address = sc.nextLine();
						
				members.add(new Member(name, tel, address));
				
				}

			
		} while (!answer.equalsIgnoreCase("n"));
		
		sc.close();
		
			if ( members.isEmpty()) {
				System.out.println("가입된 회원 정보가 없습니다.");
			} else {
				System.out.println("----------회원가입 목록 ----------");
				for (Member m : members) {
					System.out.println(m);
				}
			}
		
	}
}
