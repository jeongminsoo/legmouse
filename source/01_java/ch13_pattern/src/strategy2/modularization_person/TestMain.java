package strategy2.modularization_person;

public class TestMain {

	public static void main(String[] args) {

		Student std1 = new Student("ST01", "강학생", "영화반");
		Student std2 = new Student("ST01", "강공부", "Java반");
		Lecturer gs1 = new Lecturer("L01", "홍강의", "Java");
		Lecturer gs2 = new Lecturer("L02", "김수업", "DB");
		Staff st = new Staff("A01", "신일해", "취업지원");

		Person[] people = { std1, std2, gs1, gs2, st };

		System.out.println("업무시간이니 다 일합시다");
		System.out.println("-----------------------------------------");
		for (Person p : people) {
			System.out.print(p.getName() + "은(는)");
			p.job();
		}
		System.out.println("-----------------------------------------");
		System.out.println("월말엔 다 지급합니다");
		System.out.println("-----------------------------------------");
		for (Person p : people) {
			System.out.print(p.getName() + "은(는)");
			p.get();
		}
		System.out.println("-----------------------------------------");
		System.out.println("궁금하면 프린트");
		System.out.println("-----------------------------------------");
		for (Person p : people) {
			System.out.print(p.getClass().getName().substring(32) + "입니다. ");
			p.print();
		}
	}
}
