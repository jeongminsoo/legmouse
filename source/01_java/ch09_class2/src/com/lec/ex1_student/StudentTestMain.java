package com.lec.ex1_student;

public class StudentTestMain {

	public static void main(String[] args) {
		
		Student[] stu = { new Student("정우성", 90, 90, 90),
						  new Student("김하늘", 90, 90, 91),
						  new Student("황정민", 80, 80, 80),
						  new Student("강동원", 80, 80, 81),
						  new Student("유아인", 70, 70, 70) };
		
		String[] title  = {"이름", "국어", "영어", "수학", "총점", "평균"};
		
		printLine('■');
		System.out.println("\t\t\t\t성적표");
		printLine('-', 50);
		for (String st : title) {
			System.out.print("\t" + st);
		}
		System.out.println();
		printLine('-', 50);
		for (Student s : stu) {
			s.print();
		}
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
