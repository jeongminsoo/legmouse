package com.lec.ch03.ex3;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.ch03.ex1.Family;

public class SingletonTestMain {

	public static void main(String[] args) {
		
		String location = "classpath:META-INF/ex3/applicationCTX.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(location);
		
		Family family1 = ctx.getBean("family", Family.class);
		
		Family family2 = ctx.getBean("family", Family.class);
		
		family1.setPapa("정아빠");
		family1.setMama("정엄마");
		
		System.out.println(family1);
		System.out.println(family2);
		
		Family family3 = ctx.getBean("familyPrototype", Family.class);
		Family family4 = ctx.getBean("familyPrototype", Family.class);
		
		family3.setBrother("정아들");
		family3.setSister("정딸");
		System.out.println(family3);
		
		System.out.println(family4);
		ctx.close();
		
	}

}
