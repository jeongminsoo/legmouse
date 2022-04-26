package com.lec.ex3_student;

import java.util.ArrayList;
import java.util.Vector;

public class TestMain {

	public static void main(String[] args) {
		ArrayList<StudentDto> students = null;
		StudentDao dao = StudentDao.getInstance();
		StudentDto dto = new StudentDto("ȫ��õ", "��ǻ�Ͱ���", 55);

		
//		int result = dao.insertStudent(dto);
//		System.out.println(result == StudentDao.SUCCESS ? "�Է� ����" : "�Է� ����");
//		System.out.println("--------------------------------------------------");
//		
//		StudentDto studentNo = dao.selectSno(2022003);
//		System.out.println("�й� : " + studentNo.getSno());
//		System.out.println("�̸� : " + studentNo.getsName());
//		System.out.println("���� : " + studentNo.getmName());
//		System.out.println("���� : " + studentNo.getScore());
//		System.out.println("�������� : " + studentNo.getExpel());
//		
//		System.out.println("--------------------------------------------------");
		
		students = dao.selectSName("ȫ�浿");
		
		if (students.isEmpty()) {
			System.out.println("�ش� �̸��� �л��� �����ϴ�.");
		} else {
			for (StudentDto d : students) {
				System.out.println(d);
			}
		}
		System.out.println("--------------------------------------------------");
		
		students = dao.selectMName("���빰����");
		
		if(students.isEmpty()) {
			System.out.println("�ش� ������ �л��� �����ϴ�.");
		} else {
			for (StudentDto d : students) {
				System.out.println(d);
			}
		}
//		System.out.println("--------------------------------------------------");
//		dto.setSno(2022005);
//		dto.setmName("�濵������");
//		dto.setsName("�̿���");
//		dto.setScore(60);
//		int result = dao.updateStudent(dto);
//		System.out.println(result == StudentDao.SUCCESS ? "�����Ϸ�" : "��������");
		
		System.out.println("--------------------------------------------------");
		
		students = dao.selectAll();
		if(students.isEmpty()) {
			System.out.println("�ش� ������ �л��� �����ϴ�.");
		} else {
			for (StudentDto d : students) {
				System.out.println(d);
			}
		}
//		System.out.println("--------------------------------------------------");
//		dto.setSno(2022004);
//		dto.setsName("�����");
//		dto.setmName("��ǻ�Ͱ���");
//		dto.setScore(20);
//		
//		int result = dao.updateExpel(dto);
//		System.out.println(result == StudentDao.SUCCESS ? "����ó���Ϸ�" : "����ó������");
		
		System.out.println("--------------------------------------------------");
		
		students = dao.selectExpel();
		
		
		if(students.isEmpty()) {
			System.out.println("�ش� ������ �л��� �����ϴ�.");
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
