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
			System.out.print("1. 입력 || 2. 직업별조회 || 3. 전체조회 || 그외 종료");
			fn = sc.next();
			switch (fn) {
			case "1" :
				System.out.print("이름 : ");
				String pname = sc.next();
				System.out.print("직업 : ");
				String job = sc.next();
				System.out.print("국어 : ");
				int kor = sc.nextInt();
				System.out.print("영어 : ");
				int eng = sc.nextInt();
				System.out.print("수학 : ");
				int mat = sc.nextInt();
				
				int result = dao.insertPerson(new PersonDto(pname, job, kor, eng, mat));
				System.out.println(result == PersonDao.SUCCESS ? "입력성공" : "입력실패");
				break;
			case "2" :
				System.out.println("직업 : ");
				job = sc.next();
				dtos = dao.selectJname(job);
				if (dtos.isEmpty()) {
					System.out.println("해당 직업의 사람이 없습니다");
				} else {
					System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
					for (PersonDto d : dtos) {
						System.out.println(d);
					}
				}
				break;
			case "3" : 
				dtos = dao.selectAll();
				if (dtos.isEmpty()) {
					System.out.println("해당 직업의 사람이 없습니다");
				} else {
					System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
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
