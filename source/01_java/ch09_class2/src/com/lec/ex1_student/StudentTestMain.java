package com.lec.ex1_student;

public class StudentTestMain {

	public static void main(String[] args) {
		
		Student[] stu = { new Student("���켺", 90, 90, 90),
						  new Student("���ϴ�", 90, 90, 91),
						  new Student("Ȳ����", 80, 80, 80),
						  new Student("������", 80, 80, 81),
						  new Student("������", 70, 70, 70) };
		
		String[] title  = {"�̸�", "����", "����", "����", "����", "���"};
		
		printLine('��');
		System.out.println("\t\t\t\t����ǥ");
		printLine('-', 50);
		for (String st : title) {
			System.out.print("\t" + st);
		}
		System.out.println();
		printLine('-', 50);
		for (Student s : stu) {
			s.print();
		}
		printLine('��');
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
