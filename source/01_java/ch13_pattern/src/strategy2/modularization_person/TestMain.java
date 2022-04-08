package strategy2.modularization_person;

public class TestMain {

	public static void main(String[] args) {

		Student std1 = new Student("ST01", "���л�", "��ȭ��");
		Student std2 = new Student("ST01", "������", "Java��");
		Lecturer gs1 = new Lecturer("L01", "ȫ����", "Java");
		Lecturer gs2 = new Lecturer("L02", "�����", "DB");
		Staff st = new Staff("A01", "������", "�������");

		Person[] people = { std1, std2, gs1, gs2, st };

		System.out.println("�����ð��̴� �� ���սô�");
		System.out.println("-----------------------------------------");
		for (Person p : people) {
			System.out.print(p.getName() + "��(��)");
			p.job();
		}
		System.out.println("-----------------------------------------");
		System.out.println("������ �� �����մϴ�");
		System.out.println("-----------------------------------------");
		for (Person p : people) {
			System.out.print(p.getName() + "��(��)");
			p.get();
		}
		System.out.println("-----------------------------------------");
		System.out.println("�ñ��ϸ� ����Ʈ");
		System.out.println("-----------------------------------------");
		for (Person p : people) {
			System.out.print(p.getClass().getName().substring(32) + "�Դϴ�. ");
			p.print();
		}
	}
}
