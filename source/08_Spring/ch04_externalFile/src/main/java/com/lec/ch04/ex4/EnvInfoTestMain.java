package com.lec.ch04.ex4;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class EnvInfoTestMain {

	public static void main(String[] args) {
		
		
		String config = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("dev? or run?");
		String answer = sc.next();
		
		if (answer.equalsIgnoreCase("dev")) {
			config = "dev";
			
		} else if (answer.equalsIgnoreCase("run")) {
			config = "run";
		} else {
			System.out.println("다시 입력하세요");
			System.exit(0);
		}
		sc.close();
		
		String location1 = "classpath:META-INF/ex4/run.xml";
		String location2 = "classpath:META-INF/ex4/dev.xml";
		
		
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();
		
		try {
			// 외부 설정 파일을 env안의 propertySources에 추가
			String properties1 = "classpath:META-INF/ex4/run.properties";
			String properties2 = "classpath:META-INF/ex4/dev.properties";
			if (config.equals("dev")) {
				propertySources.addLast(new ResourcePropertySource(properties2));
			} else if (config.equals("run")) {
				propertySources.addLast(new ResourcePropertySource(properties1));
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load(location2, location1);
		ctx.refresh();
		EnvInfo info = ctx.getBean("envInfo", EnvInfo.class);
		System.out.println("ipNum : " + info.getIpNum());
		System.out.println("portNum : " + info.getPortNum());
		System.out.println("userId : " + info.getUserId());
		System.out.println("userPw : " + info.getUserPw());
	}
}
