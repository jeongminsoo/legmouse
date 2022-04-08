package example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {

	public static void main(String[] args) {
		
		HashMap<String, Member> members = new HashMap<String, Member>();
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		String tel;
		String address;
		String answer;
		
		while (true) {
			System.out.print("회원가입을 진행하겠습니까? (Y/N)");
			answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				break;
			} else if (answer.equalsIgnoreCase("y")) {
				System.out.print("이름 : ");
				name = sc.next();
				
				// 이름 중복 체크
				Iterator<String> iter0 = members.keySet().iterator();
				boolean ok = false;
				while (iter0.hasNext()) {
					String key = iter0.next();
					if(members.get(key).getName().equals(name)) {
						ok = true;
						break;
					}
				}
				if (ok) {
					System.out.println("중복된 이름입니다. 다시입력하세요.");
					continue;
				}
				
				System.out.print("전화번호 : ");
				tel = sc.next();
				
				// 전화번호 중복 체크
				if (members.get(tel) != null) {
					System.out.println("중복된 전화번호입니다. 다시입력하세요.");
					continue;
				}
				sc.nextLine();
				System.out.print("주소 : ");
				address = sc.nextLine();
				members.put(tel, new Member(name, tel, address));
				}
			}
		
		sc.close();
		if (members.isEmpty()) {
			System.out.println("가입된 회원 정보가 없습니다.");
		} else {
			System.out.println("----------회원가입 목록 ----------");
			Iterator<String> iter = members.keySet().iterator();
		
			while (iter.hasNext()) {
				String key = iter.next();
				System.out.println(members.get(key));
			}
		}
	}
}
