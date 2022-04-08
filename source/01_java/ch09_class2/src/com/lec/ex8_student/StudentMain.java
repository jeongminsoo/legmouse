package com.lec.ex8_student;

public class StudentMain {

	public static void main(String[] args) {
		
		Student[] stu = { new Student("���켺", 90, 80, 95),
						  new Student("���ϴ�", 100, 80, 95),
						  new Student("Ȳ����", 95, 80, 90),
						  new Student("������", 95, 90, 99),
						  new Student("������", 90, 90, 90) };

		String[] title  = {"��ȣ", "�̸�", "����", "����", "����", "����", "���"};

		int[] tot = new int[5];

		double[] avg = new double[5];
		
		printLine('��');
		System.out.println("\t\t\t����ǥ");
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
		for (int i = 1; i <= 60; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
}
