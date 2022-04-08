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
			System.out.print("ȸ�������� �����Ͻðڽ��ϱ�? (Y/N)");
			answer = sc.next();
			
			if (answer.equalsIgnoreCase("n")) {
				break;
			} else if (answer.equalsIgnoreCase("y")) {
				System.out.print("�̸� : ");
				name = sc.next();
				
				// �̸� �ߺ� üũ ��� 1
				boolean nameCheck = false;
				for (int i = 0; i < members.size(); i++)
					if (members.get(i).getName().equals(name)) {
						nameCheck = true;
						break;
					}
				if (nameCheck) {
					System.out.println("�ߺ��� �̸��Դϴ�. �ٽ� �Է��ϼ���.");
					continue;
				}
				// �̸� �ߺ� üũ ��� 2
//				Iterator<Member> iter0 = members.iterator();
//				boolean ok = false;
//				while (iter0.hasNext()) {
//					if(iter0.next().getName().equals(name)) {
//						ok = true;
//						break;
//					}
//				}
//				if (ok) {
//					System.out.println("�ߺ��� �̸��Դϴ�. �ٽ��Է��ϼ���.");
//					continue;
//				}	
				System.out.print("��ȭ��ȣ : ");
				tel = sc.next();
				
				boolean telCheck = false;
				for (int i = 0; i < members.size(); i++)
					if (members.get(i).getTel().equals(tel)) {
						telCheck = true;
						break;
					}
				if (telCheck) {
					System.out.println("�ߺ��� ��ȣ�Դϴ�. �ٽ� �Է��ϼ���.");
					continue;
				}
				
				sc.nextLine();
				System.out.print("�ּ� : ");
				address = sc.nextLine();
						
				members.add(new Member(name, tel, address));
				
				}

			
		} while (!answer.equalsIgnoreCase("n"));
		
		sc.close();
		
			if ( members.isEmpty()) {
				System.out.println("���Ե� ȸ�� ������ �����ϴ�.");
			} else {
				System.out.println("----------ȸ������ ��� ----------");
				for (Member m : members) {
					System.out.println(m);
				}
			}
		
	}
}
