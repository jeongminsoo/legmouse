package com.lec.ex8_student;

public class StudentMain {

	public static void main(String[] args) {
		
		Student[] stu = { new Student("정우성", 90, 80, 95),
						  new Student("김하늘", 100, 80, 95),
						  new Student("황정민", 95, 80, 90),
						  new Student("강동원", 95, 90, 99),
						  new Student("유아인", 90, 90, 90) };

		String[] title  = {"번호", "이름", "국어", "영어", "수학", "총점", "평균"};

		int[] tot = new int[5];

		double[] avg = new double[5];
		
		printLine('■');
		System.out.println("\t\t\t성적표");
		printLine('-');
		for (String st : title) {
			System.out.print(st + "\t");
		}
		System.out.println();
		printLine('-');
		for (Student st : stu) {
			st.print();
			tot[0] += st.getKor();
			tot[1] += st.getEng();
			tot[2] += st.getMath();
			tot[3] += st.getTot();
			tot[4] += st.getAvg();
		}
		for(int i = 0; i < avg.length; i++) {
			avg[i] = tot[i] / 5.0;
		}
		printLine('-');
		System.out.print("\t총점");
		for (int t : tot) {
			System.out.print("\t" + t);
		}
		System.out.print("\n\t평균");
		for (double a : avg) {
			System.out.print("\t" + a);
		}
		System.out.println();
		printLine('■');
		
	}
	
	public static void printLine(char c) {
		for (int i = 1; i <= 60; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
}
