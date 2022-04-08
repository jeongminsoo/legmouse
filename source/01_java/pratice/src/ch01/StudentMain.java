package ch01;

public class StudentMain {

	public static void main(String[] args) {
		
		Student[] student = { new Student("정우성", 90, 80, 95),
							  new Student("김하늘", 100, 80, 95),
							  new Student("황정민", 95, 80, 90),
							  new Student("강동원", 95, 90, 99),
							  new Student("유아인", 90, 90, 90) };
		
		String[] title = {"번호", "이름", "국어", "영어", "수학", "총점", "평균"};
		
		int[] total = new int[5];
		int[] average = new int[5];
		
		printLine('■');
		System.out.println("\t\t\t\t성  적  표");
		printLine('-');
		for (String t : title) {
			System.out.print(t + "\t");
		}
		System.out.println();
		printLine('-');
		for (int i = 0; i < student.length; i++) {
			student[i].print();
			total[0] += student[i].getKor();
			total[1] += student[i].getEng();
			total[2] += student[i].getMath();
			total[3] += student[i].getTotal();
			total[4] += student[i].getAvg();
		}
		for (int i = 0; i < total.length; i++) {
			average[i] = total[i] / 5;
		}
		printLine('-');
		System.out.print("\t총점\t");
		for (int t : total) {
			System.out.print(t + "\t");
		}
		System.out.println();
		System.out.print("\t평균\t");
		for (int av : average) {
			System.out.print(av + "\t");
		}
		
	}


	public static void printLine(char c) {
		for (int i = 1; i <= 55; i++) {
			System.out.print(c);
		}
		System.out.println();
	}


}