package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class StudentHashSet {

	public static void main(String[] args) {
		
		HashSet<Student> students = new HashSet<Student>();
		
		students.add(new Student(2, "홍길동"));
		students.add(new Student(3, "신길동"));
		
		System.out.println(students);
		students.add(new Student(3, "신길동"));
		students.add(new Student(2, "홍길동"));
		System.out.println(students);
		
		Iterator<Student> iter = students.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next().hashCode());
		}
	}
}
