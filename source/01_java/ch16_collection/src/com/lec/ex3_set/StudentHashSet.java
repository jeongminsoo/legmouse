package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class StudentHashSet {

	public static void main(String[] args) {
		
		HashSet<Student> students = new HashSet<Student>();
		
		students.add(new Student(2, "ȫ�浿"));
		students.add(new Student(3, "�ű浿"));
		
		System.out.println(students);
		students.add(new Student(3, "�ű浿"));
		students.add(new Student(2, "ȫ�浿"));
		System.out.println(students);
		
		Iterator<Student> iter = students.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next().hashCode());
		}
	}
}
