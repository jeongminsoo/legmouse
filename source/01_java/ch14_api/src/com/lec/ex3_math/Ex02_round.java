package com.lec.ex3_math;

public class Ex02_round {

	public static void main(String[] args) {
		
		System.out.println("�Ҽ������� �ݿø�, �ø�, ����");
		System.out.println("9.15�� �ø� : " + (int)Math.ceil(9.15));
		System.out.println("9.15�� �ݿø� : " + Math.round(9.15));
		System.out.println("9.15�� ���� : " + (int)Math.floor(9.15));
		System.out.println("�Ҽ��� ù��°�ڸ����� �ݿø�, �ø�, ����");
		System.out.println("9.15�� �ø� : " + Math.ceil(9.15*10)/10);
		System.out.println("9.15�� �ݿø� : " + Math.round(9.15*10)/10.0);
		System.out.println("9.15�� ���� : " + Math.floor(9.15*10)/10);
		System.out.println("���� �ڸ����� �ݿø�, �ø�, ����");
		System.out.println("85�� �ø� : " + (int)Math.ceil(85/10.0)*10);
		System.out.println("85�� �ݿø� : " + Math.round(85/10.0)*10);
		System.out.println("85�� ���� : " + (int)Math.floor(85/10.0)*10);
	}
}
