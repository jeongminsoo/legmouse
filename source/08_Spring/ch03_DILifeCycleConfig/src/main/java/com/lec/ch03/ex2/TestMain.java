package com.lec.ch03.ex2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		
		// IOC컨테이너생성(cf.환경설정)
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		// 파싱
		ctx.load("classpath:META-INF/ex2/applicationCTX.xml");
		
		// bean 생성
		ctx.refresh();
		
		System.out.println("-----------------------------");
		
		Person person = ctx.getBean("person", Person.class);
		
		System.out.println(person);
		
		OtherPerson otherPerson = ctx.getBean("otherPerson", OtherPerson.class);
		System.out.println(otherPerson);
		System.out.println("-----------------------------");
		ctx.close();
		System.out.println("bean 소멸");
	}

}

