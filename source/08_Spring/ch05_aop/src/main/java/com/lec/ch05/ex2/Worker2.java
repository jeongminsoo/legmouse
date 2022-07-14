package com.lec.ch05.ex2;

import lombok.Data;

@Data
public class Worker2 {

	private String name;
	private int age;
	private String job;
	
	public void getWorkerInfo() {  // 호출될 색심기능
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("직업 : " + job);
	}
}
