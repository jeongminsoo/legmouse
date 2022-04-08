package exam;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {

		Friend[] friends = { new Friend("ȫ�浿", "010-9999-1234", "����Ư���� ��걸", "05-22"),
							 new Friend("��浿", "010-8888-1234", "����Ư���� ������", "04-22") };

		Scanner sc = new Scanner(System.in);

		String answer;

		do {
			System.out.print("�˻��� �ּ� �� ���� 2�ڸ� (��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ�) : ");
			answer = sc.next();
			if (answer.equalsIgnoreCase("x")) {
				break;
			}
			if (answer.length() == 2) {
				for (Friend f : friends) {
					if (answer.equals(f.getAddress().substring(0, 2))) {
						System.out.print(f.toString());
					} else {
						System.out.println("�������� �ʴ� ģ���Դϴ�.");
						break;
					}
				}
			} else {
				System.out.println("�߸� �Է��Ͽ����ϴ�. Ȯ�����ּ���.");
				continue;
			}

		} while (true);
		sc.close();
	}
}
