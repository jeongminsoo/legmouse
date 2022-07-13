package com.lec.ch04.ex3;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ServerInfoTestMain {

	public static void main(String[] args) {
		
		String config = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("(dev / run)");
		String str = sc.next();
		
		if (str.equalsIgnoreCase("dev")) {
			config = "dev";
			
		} else if (str.equalsIgnoreCase("run")) {
			config = "run";
		} else {
			System.out.println("다시 입력하세요");
			System.exit(0);
		}
		sc.close();
		
		String location1 = "classpath:META-INF/ex3/CTX_run.xml";
		String location2 = "classpath:META-INF/ex3/CTX_dev.xml";
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load(location1, location2);
		ctx.refresh();
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println(info.getIp());
		System.out.println(info.getPort());
		ctx.close();
	}
}
