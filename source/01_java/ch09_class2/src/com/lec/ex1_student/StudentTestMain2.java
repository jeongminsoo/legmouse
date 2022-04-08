package com.lec.ex1_student;

public class StudentTestMain2 {

	public static void main(String[] args) {
		
		Student[] stu = { new Student("정우성", 90, 90, 90),
						  new Student("김하늘", 90, 90, 91),
						  new Student("황정민", 80, 80, 80),
						  new Student("강동원", 80, 80, 81),
						  new Student("유아인", 70, 70, 70) };
		
		String[] title  = {"이름", "국어", "영어", "수학", "총점", "평균"};
		
		int[] tot = new int[5];
		
		double[] avg = new double[5];
		
		printLine('■');
		System.out.println("\t\t\t\t성적표");
		printLine('-', 50);
		for (String st : title) {
			System.out.print("\t" + st);
		}
		System.out.println();
		printLine('-', 50);
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
		printLine('-', 50);
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
		for (int i = 1; i <= 65; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	public static void printLine(char c, int num) {
		System.out.print("\t");
		for (int i = 1; i <= num; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	
}
