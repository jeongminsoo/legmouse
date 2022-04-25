package com.lec.ex2_person_dtodao;

import java.util.ArrayList;
import java.util.Vector;

public class TestMain {

	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
		
		PersonDto dto = new PersonDto("홍길동", "배우", 60, 80, 70);
		
		int result = dao.insertPerson(dto);
		
		// 1번
		System.out.println(result == PersonDao.SUCCESS ? "입력성공" : "입력실패");
		
		System.out.println("--------------------------------------------------");
		// 2번
		ArrayList<PersonDto> dtos = dao.selectJname("배우");
		
		if (dtos.isEmpty()) {
			System.out.println("해당 직업의 사람이 등록되지 않았습니다");
		} else {
			for (PersonDto d : dtos) {
				System.out.println(d);
			}
			
		}
		System.out.println("--------------------------------------------------");
		// 3번
		dtos = dao.selectAll();
		
		if (dtos.isEmpty()) {
			System.out.println("해당 자료는 없습니다.");
		} else {
			for (PersonDto d : dtos) {
				System.out.println(d);
			}
		}
		System.out.println("--------------------------------------------------");
		// 4번
		
		Vector<String> jnames = dao.jnameList();
		System.out.println(jnames);
	}
}
