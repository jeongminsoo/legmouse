package exam2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {

	public static void main(String[] args) {

		HashMap<String, Customer> customers = new HashMap<String, Customer>();

		Scanner sc = new Scanner(System.in);

		String answer;
		String name;
		String phone;
		String address;

		do {

			System.out.print("회원가입을 진행하시겠습니까? (Y/N)");
			answer = sc.next();

			if (answer.equalsIgnoreCase("n")) {
				break;
			} else if (answer.equalsIgnoreCase("y")) {
				System.out.print("이름 : ");
				name = sc.next();

				System.out.print("전화번호 : ");
				phone = sc.next();
				sc.nextLine();

				System.out.print("주소 : ");
				address = sc.nextLine();

				customers.put(phone, new Customer(name, phone, address));
			}

		} while (true);

		sc.close();

		Iterator<String> iter = customers.keySet().iterator();

		if (customers.isEmpty()) {
			System.out.println("회원가입 정보가 없습니다.");
		} else {
			while (iter.hasNext()) {
				String key = iter.next();
				System.out.print(customers.get(key));
			}
		}

		System.out.println("\t . . . . .");
	}
}
