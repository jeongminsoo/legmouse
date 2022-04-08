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
			System.out.print("ȸ�������� �����ϰڽ��ϱ�? (Y/N)");
			answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				break;
			} else if (answer.equalsIgnoreCase("y")) {
				System.out.print("�̸� : ");
				name = sc.next();
				
				// �̸� �ߺ� üũ
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
					System.out.println("�ߺ��� �̸��Դϴ�. �ٽ��Է��ϼ���.");
					continue;
				}
				
				System.out.print("��ȭ��ȣ : ");
				tel = sc.next();
				
				// ��ȭ��ȣ �ߺ� üũ
				if (members.get(tel) != null) {
					System.out.println("�ߺ��� ��ȭ��ȣ�Դϴ�. �ٽ��Է��ϼ���.");
					continue;
				}
				sc.nextLine();
				System.out.print("�ּ� : ");
				address = sc.nextLine();
				members.put(tel, new Member(name, tel, address));
				}
			}
		
		sc.close();
		if (members.isEmpty()) {
			System.out.println("���Ե� ȸ�� ������ �����ϴ�.");
		} else {
			System.out.println("----------ȸ������ ��� ----------");
			Iterator<String> iter = members.keySet().iterator();
		
			while (iter.hasNext()) {
				String key = iter.next();
				System.out.println(members.get(key));
			}
		}
	}
}
