package com.lec.ex2_person_dtodao;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		PersonDao dao = PersonDao.getInstance();
		String fn;
		ArrayList<PersonDto> dtos;
		do {
			System.out.print("1. �Է� || 2. ��������ȸ || 3. ��ü��ȸ || �׿� ����");
			fn = sc.next();
			switch (fn) {
			case "1" :
				System.out.print("�̸� : ");
				String pname = sc.next();
				System.out.print("���� : ");
				String job = sc.next();
				System.out.print("���� : ");
				int kor = sc.nextInt();
				System.out.print("���� : ");
				int eng = sc.nextInt();
				System.out.print("���� : ");
				int mat = sc.nextInt();
				
				int result = dao.insertPerson(new PersonDto(pname, job, kor, eng, mat));
				System.out.println(result == PersonDao.SUCCESS ? "�Է¼���" : "�Է½���");
				break;
			case "2" :
				System.out.println("���� : ");
				job = sc.next();
				dtos = dao.selectJname(job);
				if (dtos.isEmpty()) {
					System.out.println("�ش� ������ ����� �����ϴ�");
				} else {
					System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
					for (PersonDto d : dtos) {
						System.out.println(d);
					}
				}
				break;
			case "3" : 
				dtos = dao.selectAll();
				if (dtos.isEmpty()) {
					System.out.println("�ش� ������ ����� �����ϴ�");
				} else {
					System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
					for (PersonDto d : dtos) {
						System.out.println(d);
					}
					break;
				}
			}
		} while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		sc.close();
		System.out.println("BYE");
		
	}
}
