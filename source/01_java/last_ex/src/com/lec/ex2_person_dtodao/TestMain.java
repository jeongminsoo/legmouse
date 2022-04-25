package com.lec.ex2_person_dtodao;

import java.util.ArrayList;
import java.util.Vector;

public class TestMain {

	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
		
		PersonDto dto = new PersonDto("ȫ�浿", "���", 60, 80, 70);
		
		int result = dao.insertPerson(dto);
		
		// 1��
		System.out.println(result == PersonDao.SUCCESS ? "�Է¼���" : "�Է½���");
		
		System.out.println("--------------------------------------------------");
		// 2��
		ArrayList<PersonDto> dtos = dao.selectJname("���");
		
		if (dtos.isEmpty()) {
			System.out.println("�ش� ������ ����� ��ϵ��� �ʾҽ��ϴ�");
		} else {
			for (PersonDto d : dtos) {
				System.out.println(d);
			}
			
		}
		System.out.println("--------------------------------------------------");
		// 3��
		dtos = dao.selectAll();
		
		if (dtos.isEmpty()) {
			System.out.println("�ش� �ڷ�� �����ϴ�.");
		} else {
			for (PersonDto d : dtos) {
				System.out.println(d);
			}
		}
		System.out.println("--------------------------------------------------");
		// 4��
		
		Vector<String> jnames = dao.jnameList();
		System.out.println(jnames);
	}
}
