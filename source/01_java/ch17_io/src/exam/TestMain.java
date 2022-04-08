package exam;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {

		Friend[] friends = { new Friend("홍길동", "010-9999-1234", "서울특별시 용산구", "05-22"),
							 new Friend("김길동", "010-8888-1234", "서울특별시 강남구", "04-22") };

		Scanner sc = new Scanner(System.in);

		String answer;

		do {
			System.out.print("검색할 주소 앞 글자 2자리 (단, 종료를 원하시면 x를 입력하시오) : ");
			answer = sc.next();
			if (answer.equalsIgnoreCase("x")) {
				break;
			}
			if (answer.length() == 2) {
				for (Friend f : friends) {
					if (answer.equals(f.getAddress().substring(0, 2))) {
						System.out.print(f.toString());
					} else {
						System.out.println("존재하지 않는 친구입니다.");
						break;
					}
				}
			} else {
				System.out.println("잘못 입력하였습니다. 확인해주세요.");
				continue;
			}

		} while (true);
		sc.close();
	}
}
