package ch01;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		int su = 5;
		System.out.println(su % 2 == 0 ? "¦��" : "Ȧ��");
		
		Scanner sc = new Scanner(System.in);
		
		int su1;
		int su2;
		System.out.print("ù��° ���� �Է��ϼ��� : ");
		su1 = sc.nextInt();
		System.out.print("�ι�° ���� �Է��ϼ��� : ");
		su2 = sc.nextInt();
		
		System.out.println(su1 == su2 ? "O" : "X");
		System.out.println(su1 > su2 ? "O" : "X");
		
		
		int age;
		System.out.print("���̸� �Է��ϼ��� : ");
		age = sc.nextInt();
		System.out.println(age >= 65 ? "��ο��" : "�Ϲ�");
		
		
		
		
		sc.close();
	}
}
