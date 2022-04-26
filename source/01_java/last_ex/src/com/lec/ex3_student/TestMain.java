package com.lec.ex3_student;

import java.util.ArrayList;
import java.util.Vector;

public class TestMain {

	public static void main(String[] args) {
		ArrayList<StudentDto> students = null;
		StudentDao dao = StudentDao.getInstance();
		StudentDto dto = new StudentDto("홍석천", "컴퓨터공학", 55);

		
//		int result = dao.insertStudent(dto);
//		System.out.println(result == StudentDao.SUCCESS ? "입력 성공" : "입력 실패");
//		System.out.println("--------------------------------------------------");
//		
//		StudentDto studentNo = dao.selectSno(2022003);
//		System.out.println("학번 : " + studentNo.getSno());
//		System.out.println("이름 : " + studentNo.getsName());
//		System.out.println("전공 : " + studentNo.getmName());
//		System.out.println("점수 : " + studentNo.getScore());
//		System.out.println("제적상태 : " + studentNo.getExpel());
//		
//		System.out.println("--------------------------------------------------");
		
		students = dao.selectSName("홍길동");
		
		if (students.isEmpty()) {
			System.out.println("해당 이름의 학생은 없습니다.");
		} else {
			for (StudentDto d : students) {
				System.out.println(d);
			}
		}
		System.out.println("--------------------------------------------------");
		
		students = dao.selectMName("응용물리학");
		
		if(students.isEmpty()) {
			System.out.println("해당 전공의 학생은 없습니다.");
		} else {
			for (StudentDto d : students) {
				System.out.println(d);
			}
		}
//		System.out.println("--------------------------------------------------");
//		dto.setSno(2022005);
//		dto.setmName("경영정보학");
//		dto.setsName("이오리");
//		dto.setScore(60);
//		int result = dao.updateStudent(dto);
//		System.out.println(result == StudentDao.SUCCESS ? "수정완료" : "수정실패");
		
		System.out.println("--------------------------------------------------");
		
		students = dao.selectAll();
		if(students.isEmpty()) {
			System.out.println("해당 전공의 학생은 없습니다.");
		} else {
			for (StudentDto d : students) {
				System.out.println(d);
			}
		}
//		System.out.println("--------------------------------------------------");
//		dto.setSno(2022004);
//		dto.setsName("배수지");
//		dto.setmName("컴퓨터공학");
//		dto.setScore(20);
//		
//		int result = dao.updateExpel(dto);
//		System.out.println(result == StudentDao.SUCCESS ? "제적처리완료" : "제적처리실패");
		
		System.out.println("--------------------------------------------------");
		
		students = dao.selectExpel();
		
		
		if(students.isEmpty()) {
			System.out.println("해당 전공의 학생은 없습니다.");
		} else {
			for (StudentDto d : students) {
				System.out.println(d);
			}
		}
		Vector<String> major = dao.majorList();
		
		for (String m : major) {
			System.out.println(m);
		}
	}
}
