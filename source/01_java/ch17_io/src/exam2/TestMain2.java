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

			System.out.print("ȸ�������� �����Ͻðڽ��ϱ�? (Y/N)");
			answer = sc.next();

			if (answer.equalsIgnoreCase("n")) {
				break;
			} else if (answer.equalsIgnoreCase("y")) {
				System.out.print("�̸� : ");
				name = sc.next();

				System.out.print("��ȭ��ȣ : ");
				phone = sc.next();
				sc.nextLine();

				System.out.print("�ּ� : ");
				address = sc.nextLine();

				customers.put(phone, new Customer(name, phone, address));
			}

		} while (true);

		sc.close();

		Iterator<String> iter = customers.keySet().iterator();

		if (customers.isEmpty()) {
			System.out.println("ȸ������ ������ �����ϴ�.");
		} else {
			while (iter.hasNext()) {
				String key = iter.next();
				System.out.print(customers.get(key));
			}
		}

		System.out.println("\t . . . . .");
	}
}
