package com.lec.ex1_student;

public class StudentTestMain2 {

	public static void main(String[] args) {
		
		Student[] stu = { new Student("���켺", 90, 90, 90),
						  new Student("���ϴ�", 90, 90, 91),
						  new Student("Ȳ����", 80, 80, 80),
						  new Student("������", 80, 80, 81),
						  new Student("������", 70, 70, 70) };
		
		String[] title  = {"�̸�", "����", "����", "����", "����", "���"};
		
		int[] tot = new int[5];
		
		double[] avg = new double[5];
		
		printLine('��');
		System.out.println("\t\t\t\t����ǥ");
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
		System.out.print("\t����");
		for (int t : tot) {
			System.out.print("\t" + t);
		}
		System.out.print("\n\t���");
		for (double a : avg) {
			System.out.print("\t" + a);
		}
		System.out.println();
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
