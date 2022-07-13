package com.lec.ch03.ex1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		String location1 = "classpath:META-INF/ex1/applicationCTX1.xml";
		String location2 = "classpath:META-INF/ex1/applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location1, location2);
		
		Student student = ctx.getBean("student", Student.class);
		Family family = ctx.getBean("family", Family.class);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		
		System.out.println("student : " + student);
		System.out.println("student(info) : " + studentInfo.getStudent());
		
		if (student.equals(studentInfo.getStudent())) {
			System.out.println("두 객체는 같다");
		}
		
		System.out.println("family : " + family);
		ctx.close();
	}

}
